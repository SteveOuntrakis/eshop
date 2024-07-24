package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.CustomerCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory category;

    public Customer(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", nationality=" + nationality + ", category=" + category;
    }

}
