package com.shoesecom.Service;

import com.shoesecom.Model.Info_delivery;

import java.util.List;

public interface IInfo_deliveryService {
    Info_delivery getInfoByOrderID(int order_id);

    void addInfoDelivery(Info_delivery infoDelivery);

}
