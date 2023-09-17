package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IPaymentDAO;
import com.shoesecom.Model.Payment;
import com.shoesecom.Service.IPaymentService;

import javax.inject.Inject;
import java.util.List;

public class PaymentService implements IPaymentService {
    @Inject
    private IPaymentDAO paymentDAO;
    @Override
    public List<Payment> getAll() {
        return paymentDAO.getAll();
    }

    @Override
    public Payment getDeliveryByID(int payment_id) {
        return paymentDAO.getDeliveryByID(payment_id);
    }
}
