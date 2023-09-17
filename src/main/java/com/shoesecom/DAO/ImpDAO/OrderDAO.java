package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IOrderDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Order;

import java.util.List;

public class OrderDAO implements IOrderDAO {
    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public List<Order> getAllOrderByAccountId(int id) {
        return null;
    }

    @Override
    public void addOrder(Account account, Cart cart, Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }
}
