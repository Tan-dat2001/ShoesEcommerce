package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IStatusDAO;
import com.shoesecom.Model.Order_status;
import com.shoesecom.Service.IStatusService;

import javax.inject.Inject;
import java.util.List;

public class StatusService implements IStatusService {
    @Inject
    private IStatusDAO statusDAO;
    @Override
    public List<Order_status> getAll() {
        return statusDAO.getAll();
    }

    @Override
    public List<Order_status> getStatusByID(int status_id) {
        return statusDAO.getStatusByID(status_id);
    }
}
