package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IPscDAO;
import com.shoesecom.Model.PSC;
import com.shoesecom.Service.IPscService;

import javax.inject.Inject;
import java.util.List;

public class PscService implements IPscService {
    @Inject
    private IPscDAO pscDAO;
    @Override
    public List<PSC> GetAllPSC() {
       return pscDAO.GetAllPSC();

    }

    @Override
    public List<PSC> GetPSCBySize(int product_id) {
        return pscDAO.GetPSCBySize(product_id);
    }

    @Override
    public void addPSC(PSC psc) {
        pscDAO.addPSC(psc);
    }

    @Override
    public void editPSC(PSC psc) {
//        pscDAO.editPSC(productId,sizeId,quantity);
        pscDAO.editPSC(psc);
    }


    @Override
    public void deletePSC(int id) {
        pscDAO.deletePSC(id);
    }
}
