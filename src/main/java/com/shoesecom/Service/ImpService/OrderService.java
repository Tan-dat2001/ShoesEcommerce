package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IOrderDAO;
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
    public List<Order> getOrderByID(int order_id) {
        return orderDAO.getOrderByID(order_id);
    }

}
