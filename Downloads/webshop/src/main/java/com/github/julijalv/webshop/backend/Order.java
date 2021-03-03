package com.github.julijalv.webshop.backend;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class Order {
   private enum statusEnum {DRAFT, CONFIRMED, PAYED, CANCELLED}
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    Date creationDate;
    double sum;
    String paymentMethod;
    String deliveryMethod;
    statusEnum status;

    private List<OrderItem> orderedItems = new ArrayList<OrderItem>();
    public Order(){
        status = statusEnum.DRAFT;
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }
    private OrderItem getOrderItemForProduct( Product product) {
        for (OrderItem item: getOrderedItems()) {
            if (item.getItem().equals(product.getId())) {
               return item;
            }
        }
        return null;
    }

    public void addItem (Product item, int quantity) {
        OrderItem orderItem = getOrderItemForProduct(item);
        if (orderItem != null) {
            orderItem.setQuantity( orderItem.getQuantity() + quantity );
        } else {
           orderItem = new OrderItem();
           orderItem.setItem(item);
           orderItem.setQuantity(quantity);
           getOrderedItems().add(orderItem);
        }
    }

    public void deleteItem(Product item) {
        OrderItem orderItem = getOrderItemForProduct(item);
        if (orderItem != null) {
            getOrderedItems().remove(orderItem);
        }
    }

    public long getId() {
        return this.id;
    }
    public void setCreationDate() {
        this.creationDate = new java.util.Date();
    }

    public Date getCreationDate() {
        return this.creationDate;
    }
    public void setSum( double sum) {
        this.sum = sum;
    }
    public double getSum() {
        return this.sum;
    }
}
