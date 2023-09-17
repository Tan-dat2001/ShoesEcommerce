package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IDeliveryDAO;
import com.shoesecom.Model.Delivery;
import com.shoesecom.Service.IDeliveryService;

import javax.inject.Inject;
import java.util.List;

public class DeliveryService implements IDeliveryService {
    @Inject
    private IDeliveryDAO deliveryDAO;
    @Override
    public List<Delivery> getAll() {
        return deliveryDAO.getAll();
    }

    @Override
    public Delivery getDeliveryByID(int delivery_id) {
        return deliveryDAO.getDeliveryByID(delivery_id);
    }
}
