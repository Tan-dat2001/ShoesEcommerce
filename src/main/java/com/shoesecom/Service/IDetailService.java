package com.shoesecom.Service;

import com.shoesecom.Model.Detail;

import java.util.List;

public interface IDetailService {
    List<Detail> getAll();
    List<Detail> getDetailByID(int order_id);
}
