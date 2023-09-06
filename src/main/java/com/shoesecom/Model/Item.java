package com.shoesecom.Model;

public class Item {
    private Product product;
    private int quantity;
    private float price;
    private int size;


    public Item(Product product, int quantity, float price, int size ) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
