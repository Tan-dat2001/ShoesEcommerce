package com.shoesecom.Model;

public class Detail {
    private int order_detail_id, product_id, order_id;
    private String discount_code;
    private float price, total_amount;
    private int quantity;

    public Detail() {
    }

    public Detail(int order_detail_id, int product_id, int order_id, String discount_code, float price, float total_amount, int quantity) {
        this.order_detail_id = order_detail_id;
        this.product_id = product_id;
        this.order_id = order_id;
        this.discount_code = discount_code;
        this.price = price;
        this.total_amount = total_amount;
        this.quantity = quantity;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "order_detail_id=" + order_detail_id +
                ", product_id=" + product_id +
                ", order_id=" + order_id +
                ", discount_code='" + discount_code + '\'' +
                ", price=" + price +
                ", total_amount=" + total_amount +
                ", quantity=" + quantity +
                '}';
    }
}
