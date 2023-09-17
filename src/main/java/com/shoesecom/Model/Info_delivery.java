package com.shoesecom.Model;

public class Info_delivery {
    private int info_id, order_id;
    private String name,phone,address, note;

    public Info_delivery() {
    }

    public Info_delivery(int info_id, int order_id, String name, String phone, String address, String note) {
        this.info_id = info_id;
        this.order_id = order_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.note = note;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
