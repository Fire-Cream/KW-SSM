package com.cream.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> cartItems = new HashMap<>();
    //总计
    private double total;

    //添加购物项的方法
    public void addCartItem(CartItem cartItem) {
        //获取商品id
        int id = cartItem.getItem().getId();
        //根据商品id判断商品是否存在于购物车
        if (!cartItems.containsKey(id)) {
            //如果不存在，直接添加即可
            cartItems.put(id, cartItem);
        } else {
            //如果存在，更新商品数量
            //得到原来的商品信息
            CartItem cartItem_old = cartItems.get(id);
            //更新商品数量
            cartItem_old.setCount(cartItem.getCount() + cartItem_old.getCount());
        }
        //更新统计
        total += cartItem.getSubtotal();
    }

    public void delete(int id) {
        CartItem remove = cartItems.remove(id);
        total -= remove.getSubtotal();
    }

    public void clear() {
        cartItems.clear();
        total = 0;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                ", total=" + total +
                '}';
    }
}
