package com.shoesecom.DAO;

import com.shoesecom.Model.Order;
import com.shoesecom.Model.Order_status;

import java.util.List;

public interface IStatusDAO {
    List<Order_status> getAll();
    Order_status getStatusByID(int status_id);

}
