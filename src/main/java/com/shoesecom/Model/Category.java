package com.shoesecom.Model;

import java.sql.Timestamp;

public class Category {
    private int category_id;
    private String category_name;
    private Timestamp create_at;
    private String create_by;
    private Timestamp update_at;
    private String update_by;

    public Category(int category_id, String category_name, Timestamp create_at, String create_by, Timestamp update_at, String update_by) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.create_at = create_at;
        this.create_by = create_by;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
