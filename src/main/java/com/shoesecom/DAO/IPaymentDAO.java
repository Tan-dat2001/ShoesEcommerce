package com.shoesecom.DAO;

import com.shoesecom.Model.Payment;

import java.util.List;

public interface IPaymentDAO {
    List<Payment> getAll();
    Payment getDeliveryByID(int payment_id);
}
