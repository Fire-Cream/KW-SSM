package com.cream.mapper;

import com.cream.domain.OrderItem;
import com.cream.domain.Orders;

import java.util.List;

public interface OrdersMapper {
    //生成订单信息
    void insertOrder(Orders order);

    //生成订单项信息
    void insertOrderItem(OrderItem orderItem);

    //添加订单信息
    void addOrderMsg(Orders order);
    //获取订单信息
    Orders selectByOid(String out_trade_no);

    //修改订单状态
    void changeState(Orders order);

    //根据uid获取全部订单
    List<Orders> selectOrdersByUid(int uid);

    //根据oid获取全部订单项
    List<OrderItem> selectOrderItemsByOid(String oid);
}