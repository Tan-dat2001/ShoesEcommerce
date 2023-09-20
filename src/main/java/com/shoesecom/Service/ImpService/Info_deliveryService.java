package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IInfo_DeliveyDAO;
import com.shoesecom.Model.Info_delivery;
import com.shoesecom.Service.IInfo_deliveryService;

import javax.inject.Inject;
import java.util.List;

public class Info_deliveryService implements IInfo_deliveryService {
    @Inject
    private IInfo_DeliveyDAO info_deliveyDAO;

    @Override
    public Info_delivery getInfoByOrderID(int order_id) {
        return info_deliveyDAO.getInfoByOrderID(order_id);
    }

    @Override
    public void addInfoDelivery(Info_delivery infoDelivery) {
        info_deliveyDAO.addInfoDelivery(infoDelivery);
    }
}
