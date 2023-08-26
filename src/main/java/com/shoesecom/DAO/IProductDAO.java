package com.shoesecom.DAO;

import com.shoesecom.Model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();
    Product getProductById(int id);
    List<Product> getProductByCategory(int category_id);
    int countProduct();
    List<Product> pagingProduct(int index);
    List<Product> searchProduct(String keyword);
    List<Product> getProductByPrice(float minPrice, float maxPrice);
}
