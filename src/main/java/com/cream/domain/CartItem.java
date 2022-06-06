package com.cream.domain;

public class CartItem {
    //购买的商品
    private Item item;
    //购买的数量
    private int count;
    //小计
    private double subtotal;

    public CartItem() {
    }

    public CartItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        subtotal = item.getShopPrice() * count;
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "item=" + item +
                ", count=" + count +
                ", subtotal=" + subtotal +
                '}';
    }
}
