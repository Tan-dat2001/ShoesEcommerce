package com.shoesecom.Service;

import com.shoesecom.Model.PSC;

import java.util.List;

public interface IPscService {
    List<PSC> GetAllPSC();
    List<PSC> GetPSCBySize(int product_id);
    void addPSC(PSC psc);
    void editPSC(PSC psc);
    void deletePSC(int id);
}
