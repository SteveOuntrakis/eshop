package com.european.ed.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date date_of_birth = new Date();
    private Role role= new Role();
    private boolean active;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }
    

    public Employee(int id, String name, Date date_of_birth, Role role, boolean active) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.role = role;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", date_of_birth=" + date_of_birth + ", role=" + role + ", active=" + active + '}';
    }
    
}
