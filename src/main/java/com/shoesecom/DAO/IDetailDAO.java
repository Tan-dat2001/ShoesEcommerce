package com.shoesecom.DAO;


import com.shoesecom.Model.Detail;

import java.util.List;

public interface IDetailDAO {
    List<Detail> getAll();
    List<Detail> getDetailByID(int order_id);
}
