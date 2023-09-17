package com.shoesecom.Service;

import com.shoesecom.Model.Delivery;

import java.util.List;

public interface IDeliveryService {
    List<Delivery> getAll();
    Delivery getDeliveryByID(int delivery_id);
}
