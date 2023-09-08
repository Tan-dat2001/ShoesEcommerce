package com.shoesecom.Model;

public class PSC {
    private int id;
    private int product_id;
    private int size_id;
    private int quantity;

    public PSC(int id, int product_id, int size_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.size_id = size_id;
        this.quantity = quantity;
    }

    public PSC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PSC{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", size_id=" + size_id +
                ", quantity=" + quantity +
                '}';
    }
}
