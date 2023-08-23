package com.shoesecom.DAO;

import com.shoesecom.Model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();
    List<Product> getProductByCategory(int category_id);
    int countProduct();
}
