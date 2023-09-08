package com.shoesecom.DAO;

import com.shoesecom.Model.PSC;

import java.util.List;

public interface IPscDAO {
    List<PSC> GetAllPSC();
    List<PSC> GetPSCBySize(int product_id);

}

