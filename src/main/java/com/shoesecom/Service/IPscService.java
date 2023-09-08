package com.shoesecom.Service;

import com.shoesecom.Model.PSC;

import java.util.List;

public interface IPscService {
    List<PSC> GetAllPSC();
    List<PSC> GetPSCBySize(int product_id);
}
