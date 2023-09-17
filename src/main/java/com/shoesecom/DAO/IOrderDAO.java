package com.shoesecom.DAO;

import com.shoesecom.Model.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> getAll();
    List<Order> getOrderByID(int order_id);
}
