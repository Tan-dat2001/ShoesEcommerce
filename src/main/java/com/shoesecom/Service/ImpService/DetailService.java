package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IDetailDAO;
import com.shoesecom.Model.Detail;
import com.shoesecom.Service.IDetailService;

import javax.inject.Inject;
import java.util.List;

public class DetailService implements IDetailService {
    @Inject
    private IDetailDAO detailDAO;
    @Override
    public List<Detail> getAll() {
        return detailDAO.getAll();
    }

    @Override
    public List<Detail> getDetailByID(int order_id) {
        return detailDAO.getDetailByID(order_id);
    }
}
