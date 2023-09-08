package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IPscDAO;
import com.shoesecom.Model.PSC;
import com.shoesecom.Service.IPscService;

import javax.inject.Inject;
import java.util.List;

public class PscService implements IPscService {
    @Inject
    private IPscDAO pcsDAO;
    @Override
    public List<PSC> GetAllPSC() {
       return pcsDAO.GetAllPSC();

    }

    @Override
    public List<PSC> GetPSCBySize(int product_id) {
        return pcsDAO.GetPSCBySize(product_id);
    }
}
