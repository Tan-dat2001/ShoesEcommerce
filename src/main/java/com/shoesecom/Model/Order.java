package com.shoesecom.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Order {
    private int order_id, account_id, payment_id,delivery_id,status_id;
    private String payment_transaction,order_note;
    private float total_amount;
    private LocalDateTime order_date;
    private Timestamp createAt;
    private String createBy;
    private Timestamp updateAt;
    private String updateBy;

    public Order() {
    }

    public Order(int order_id, int account_id, int payment_id, int delivery_id, int status_id, String payment_transaction, String order_note, float total_amount, LocalDateTime order_date, Timestamp createAt, String createBy, Timestamp updateAt, String updateBy) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.payment_id = payment_id;
        this.delivery_id = delivery_id;
        this.status_id = status_id;
        this.payment_transaction = payment_transaction;
        this.order_note = order_note;
        this.total_amount = total_amount;
        this.order_date = order_date;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getPayment_transaction() {
        return payment_transaction;
    }

    public void setPayment_transaction(String payment_transaction) {
        this.payment_transaction = payment_transaction;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", account_id=" + account_id +
                ", payment_id=" + payment_id +
                ", delivery_id=" + delivery_id +
                ", status_id=" + status_id +
                ", payment_transaction='" + payment_transaction + '\'' +
                ", order_note='" + order_note + '\'' +
                ", total_amount=" + total_amount +
                ", order_date=" + order_date +
                ", createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}' + "\n";
    }
}
