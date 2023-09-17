package com.shoesecom.Service;

import com.shoesecom.Model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> getAll();
    Payment getDeliveryByID(int payment_id);
}
