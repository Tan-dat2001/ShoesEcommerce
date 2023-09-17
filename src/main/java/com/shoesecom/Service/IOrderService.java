package com.shoesecom.Service;

import com.shoesecom.Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    List<Order> getOrderByID(int order_id);
}
