package com.cream.service;

import com.cream.domain.Orders;

import java.util.List;

public interface OrderService {
    //生成订单
    void submitOrder(Orders order);
    //添加用户信息
    void addOrderMsg(Orders order);
    //获取订单信息
    Orders selectByOid(String out_trade_no);
    //修改订单状态
    void changeState(Orders order);
    //获取全部订单
    List<Orders> showOrders(int uid);

}
