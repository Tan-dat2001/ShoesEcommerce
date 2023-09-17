package com.shoesecom.DAO;

import com.shoesecom.Model.Info_delivery;

import java.util.List;

public interface IInfo_DeliveyDAO {
    List<Info_delivery> getInfoByOrderID(int order_id);
}
