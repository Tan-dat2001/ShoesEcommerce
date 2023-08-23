package com.shoesecom.DAO;

import com.shoesecom.Model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();

    Product getProductById(int id);
}
