package com.shoesecom.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Item getItemById(int id){ //id chinh laf id san pham
        for(Item item:items){
            if(item.getProduct().getProduct_id() == id){
                return item; // trả về id có trong giỏ chính là item.
            }
        }
        return null;
    }

    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }

    public void addItem(Item item){
        if(getItemById(item.getProduct().getProduct_id()) != null){
            Item m = getItemById(item.getProduct().getProduct_id());
            m.setQuantity(m.getQuantity()+item.getQuantity());
        }else{
            items.add(item);
        }
    }

    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }

    public float getTotalMoney(){
        float total = 0;
        for(Item item:items){
            total += (item.getQuantity()*item.getProduct().getProduct_price());
        }
        return total;
    }
}
