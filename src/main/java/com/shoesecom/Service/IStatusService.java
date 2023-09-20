package com.shoesecom.Service;

import com.shoesecom.Model.Order_status;

import java.util.List;

public interface IStatusService {

    List<Order_status> getAll();
    Order_status getStatusByID(int status_id);
}
