package com.shoesecom.DAO;

import com.shoesecom.Model.Delivery;


import java.util.List;

public interface IDeliveryDAO {
    List<Delivery> getAll();
    Delivery getDeliveryByID(int delivery_id);
}
