package com.european.ed.model;

import java.util.Date;

public class Role {
    private int id;
    private String title;
    private Date creationDate;
    private boolean active;

    public Role() {
    }
    

    public Role(String title) {
        this.title = title;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", title=" + title + ", creationDate=" + creationDate + ", active=" + active + '}';
    }
    
    
}
