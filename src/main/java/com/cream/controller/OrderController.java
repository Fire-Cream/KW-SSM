package com.cream.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cream.domain.*;
import com.cream.service.OrderService;
import com.cream.utils.AlipayConfig;
import com.cream.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //提交订单
    @RequestMapping("submitOrder")
    public String submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //判断是否登录账号
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("error", "请您登录后再提交订单");
            return "login";
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //创建订单
        Orders order = new Orders();
        order.setOid(UuidUtil.getUuid());//订单编号
        order.setOrderTime(new Date());//下单时间
        order.setTotal(cart.getTotal());//总计
        order.setState(1);//订单状态  未付款
        order.setUser(user);//订单所属用户
        //遍历购物项
        for (Map.Entry<Integer, CartItem> entry : cart.getCartItems().entrySet()) {
            //创建购物项
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UuidUtil.getUuid());//购物项编号
            orderItem.setOrder(order);//购物项所属订单
            orderItem.setCount(entry.getValue().getCount());//购买数量
            orderItem.setSubtotal(entry.getValue().getSubtotal());//小计
            orderItem.setItem(entry.getValue().getItem());//设置购物相对应的商品信息
            order.getOrderItems().add(orderItem);
        }
        orderService.submitOrder(order);
        //清空购物车
        cart.clear();
        request.getSession().removeAttribute("cart");
        //将订单保存到session域
        request.setAttribute("order", order);
        return "order";
    }

    //未付款订单 修改信息 付款
    @RequestMapping("toPay")
    public String toPay(HttpServletRequest request, HttpServletResponse response){
        //获取相关信息
        String oid= request.getParameter("oid");
        String address= request.getParameter("address");
        String name= request.getParameter("name");
        String telephone= request.getParameter("telephone");
        request.setAttribute("oid",oid);
        request.setAttribute("address",address);
        request.setAttribute("name",name);
        request.setAttribute("telephone",telephone);
        return "pay";
    }

    //提交订单
    @RequestMapping("pay")
    public String pay(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");
        //获取订单信息 该order里面没有用户的收货信息 下面可以直接赋值使用
        Orders order = orderService.selectByOid(out_trade_no);
        //判断是否是第一次创建订单
        if(request.getParameter("pay") == null){
            //更新用户信息
            String address = request.getParameter("address");
            String name = request.getParameter("name");
            String telephone = request.getParameter("telephone");
            order.setAddress(address);
            order.setName(name);
            order.setTelephone(telephone);
            orderService.addOrderMsg(order);
        }

        //付款金额，必填
        double total_amount = order.getTotal();
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        //订单名称，必填
        String subject = user.getName()+"的订单";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().println(result);
        return null;
    }

    //提交订单回调函数
    @RequestMapping("callBack")
    public String callBack(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        //将验签结果保存到request域
        request.setAttribute("signVerified",signVerified);
        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            //支付宝交易号
            String trade_no = request.getParameter("trade_no");
            //付款金额
            String total_amount = request.getParameter("total_amount");

            Orders order = new Orders();
            order.setOid(out_trade_no);
            order.setState(2);
            orderService.changeState(order);

            request.setAttribute("out_trade_no",out_trade_no);
            request.setAttribute("trade_no",trade_no);
            request.setAttribute("total_amount",total_amount);
        }
        return "pay-result";
    }

    //查询所有的订单
    @RequestMapping("showOrder")
    public String showOrder(HttpServletRequest request, HttpServletResponse response){
        //获取用户id
        int uid = Integer.parseInt(request.getParameter("uid"));
        List<Orders> orders = orderService.showOrders(uid);
        request.getSession().setAttribute("orders",orders);
        return "order-list";
    }
}
