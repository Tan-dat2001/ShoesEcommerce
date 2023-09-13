package com.shoesecom.Service;


import com.shoesecom.Model.Image;
import com.shoesecom.Model.PSC;
import com.shoesecom.Model.Product;
import com.shoesecom.Model.Size;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product getProductById(int id);
    List<Product> getProductByCategory(int category_id);
    int countProduct();
    List<Product> searchProduct(String keyword);
    int searchNewestProduct();
    List<Product> getProductByPrice(float minPrice, float maxPrice);
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(int id);
}
