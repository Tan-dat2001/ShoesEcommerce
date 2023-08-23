package com.shoesecom.Service;


import com.shoesecom.Model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product getProductById(int id);
    List<Product> getProductByCategory(int category_id);
    int countProduct();
}
