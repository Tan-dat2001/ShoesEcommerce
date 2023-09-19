package com.shoesecom.Service;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    Order getOrderByID(int order_id);

    List<Order> getAllOrderByAccountId(int id);

    void addOrder(Account account, Cart cart, Order order);

}
