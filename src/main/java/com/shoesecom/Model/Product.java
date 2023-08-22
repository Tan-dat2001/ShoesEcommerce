package com.shoesecom.Model;

import java.sql.Timestamp;

public class Product {
    private int product_id, category_id, discount_id, purchases, quantity;
    private String product_name, product_desc, product_image, status ;
    private float product_price;
    private Timestamp create_at;
    private String create_by;
    private Timestamp update_at;
    private String update_by;

    public Product(int product_id, int category_id, int discount_id, int purchases, int quantity, String product_name, String product_desc, String product_image, String status, float product_price, Timestamp create_at, String create_by, Timestamp update_at, String update_by) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.discount_id = discount_id;
        this.purchases = purchases;
        this.quantity = quantity;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_image = product_image;
        this.status = status;
        this.product_price = product_price;
        this.create_at = create_at;
        this.create_by = create_by;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
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
        return "Product{" +
                "product_id=" + product_id +
                ", category_id=" + category_id +
                ", discount_id=" + discount_id +
                ", purchases=" + purchases +
                ", quantity=" + quantity +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", product_image='" + product_image + '\'' +
                ", status='" + status + '\'' +
                ", product_price=" + product_price +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
