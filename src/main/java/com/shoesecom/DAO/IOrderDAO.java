package com.shoesecom.DAO;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> getAllOrder();

    List<Order> getAllOrderByAccountId(int id);

    void addOrder(Account account, Cart cart, Order order);

    void updateOrder(Order order);


}
