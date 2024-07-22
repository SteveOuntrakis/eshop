package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.CustomerCategory;

public class Customer {

    private int id;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory category;

    public Customer() {
    }

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(int id) {
        this.id = id;
    }
    
    public Customer(int id, String name, String email, CustomerCategory category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
    }

    public Customer(int id, String name, String email, String address, String nationality, CustomerCategory category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", nationality=" + nationality + ", category=" + category;
    }

}
