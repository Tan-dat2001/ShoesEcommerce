package com.shoesecom.Model;

import java.sql.Timestamp;

public class Delivery {
    private int delivery_id;
    private String delivery_name, status;
    private float delivery_price;

    public Delivery() {
    }

    public Delivery(int delivery_id, String delivery_name, String status, float delivery_price) {
        this.delivery_id = delivery_id;
        this.delivery_name = delivery_name;
        this.status = status;
        this.delivery_price = delivery_price;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDelivery_name() {
        return delivery_name;
    }

    public void setDelivery_name(String delivery_name) {
        this.delivery_name = delivery_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(float delivery_price) {
        this.delivery_price = delivery_price;
    }
}
