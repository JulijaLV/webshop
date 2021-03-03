package com.github.julijalv.webshop.backend;

public class OrderItem {
    private Product item;
    private double price;
    private int quantity;

    public OrderItem() {

    }
    public void setItem(Product item) {
        this.item = item;
    }
    public Product getItem() {
        return this.item;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public double setSum() {
        return this.quantity * this.price;
    }


}
