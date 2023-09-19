package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IOrderDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Order;
import com.shoesecom.Service.IOrderService;

import javax.inject.Inject;
import java.util.List;

public class OrderService implements IOrderService {
    @Inject
    private IOrderDAO orderDAO;
    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order getOrderByID(int order_id) {
        return orderDAO.getOrderByID(order_id);
    }

    @Override
    public List<Order> getAllOrderByAccountId(int id) {
        return orderDAO.getAllOrderByAccountId(id);
    }

    @Override
    public void addOrder(Account account, Cart cart, Order order) {
        orderDAO.addOrder(account,cart,order);
    }

}
