package com.cream.service.impl;

import com.cream.domain.OrderItem;
import com.cream.domain.Orders;
import com.cream.mapper.ItemMapper;
import com.cream.mapper.OrdersMapper;
import com.cream.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    //注入mapper
    @Autowired
    private OrdersMapper ordersMapper;

    public void submitOrder(Orders order) {
        //向订单表添加订单信息
        ordersMapper.insertOrder(order);
        for (OrderItem orderItem : order.getOrderItems()) {
            ordersMapper.insertOrderItem(orderItem);
        }
    }

    public void addOrderMsg(Orders order) {
        ordersMapper.addOrderMsg(order);
    }

    public Orders selectByOid(String out_trade_no) {
        return ordersMapper.selectByOid(out_trade_no);
    }

    public void changeState(Orders order) {
        ordersMapper.changeState(order);
    }

    public List<Orders> showOrders(int uid) {
        List<Orders> orders = ordersMapper.selectOrdersByUid(uid);
        for(Orders order : orders){
            List<OrderItem> orderItems = ordersMapper.selectOrderItemsByOid(order.getOid());
            order.setOrderItems(orderItems);
        }
        return orders;
    }
}
