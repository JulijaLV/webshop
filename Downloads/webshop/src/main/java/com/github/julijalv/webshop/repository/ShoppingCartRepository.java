package com.github.julijalv.webshop.repository;

import com.github.julijalv.webshop.backend.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingCartRepository {
    private List<Product> cartProducts;
    public void addItem() {
        System.out.println("adding item");
    }
}


