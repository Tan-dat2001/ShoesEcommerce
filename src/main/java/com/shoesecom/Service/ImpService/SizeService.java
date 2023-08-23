package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.ISizeDAO;
import com.shoesecom.Model.Size;
import com.shoesecom.Service.ISizeService;

import javax.inject.Inject;
import java.util.List;

public class SizeService implements ISizeService {
    @Inject
    private ISizeDAO sizeDAO;
    @Override
    public List<Size> getAllSize() {
        return sizeDAO.getAllSize();
    }
}
