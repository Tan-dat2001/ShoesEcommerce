package com.shoesecom.Model;

public class Payment {
    private int payment_id;
    private String payment_name, status;

    public Payment() {
    }

    public Payment(int payment_id, String payment_name, String status) {
        this.payment_id = payment_id;
        this.payment_name = payment_name;
        this.status = status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
