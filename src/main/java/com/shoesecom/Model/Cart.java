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

//    public void addItem(Item item){
//        if(getItemById(item.getProduct().getProduct_id()) != null && item.getSize() != null ){
//            Item m = getItemById(item.getProduct().getProduct_id());
//            m.setQuantity(m.getQuantity()+item.getQuantity());
//        }else{
//            items.add(item);
//        }
//    }
    public void addItem(Item item){
        // Tạo một biến để kiểm tra xem item đã tồn tại trong danh sách chưa
        boolean itemExists = false;

        // Lặp qua danh sách items
        for (Item existingItem : items) {
            // Kiểm tra xem có mặt hàng với cùng product_id và size không
            if (existingItem.getProduct().getProduct_id() == item.getProduct().getProduct_id()
                    && existingItem.getSize()==item.getSize()) {
                // Nếu có, tăng số lượng của mặt hàng đó
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                itemExists = true; // Đánh dấu là mặt hàng đã tồn tại
                break; // Thoát khỏi vòng lặp vì đã tìm thấy và thực hiện tăng số lượng
            }
        }

        // Nếu mặt hàng không tồn tại, thêm mặt hàng mới vào danh sách
        if (!itemExists) {
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
