package com.github.julijalv.webshop.backend;
//import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


public class Product {
    private String id;
    private String name;
    private String description;

    public Product() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return  this.name;
    }


}
