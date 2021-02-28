package com.github.julijalv.webshop.repository;

import com.github.julijalv.webshop.backend.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class ProductRepository {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();
        Product prd1 = new Product();
        prd1.setId("PRD1");
        prd1.setName("Product 1");
        prd1.setDescription("Product 1 Description");
        list.add(prd1);

        Product prd2 = new Product();
        prd2.setId("PRD2");
        prd2.setName("Product 2");
        prd2.setDescription("Product 2 Description");
        list.add(prd2);
        return list;
    }
}
