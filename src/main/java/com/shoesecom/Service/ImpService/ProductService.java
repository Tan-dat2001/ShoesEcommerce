package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IProductDAO;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService {
    @Inject
    private IProductDAO productDAO;

    @Override
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
    @Override
    public List<Product> getProductByCategory(int category_id) {
        return productDAO.getProductByCategory(category_id);
    }
    @Override
    public int countProduct() {
        return productDAO.countProduct();
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return productDAO.searchProduct(keyword);
    }

    @Override
    public List<Product> getProductByPrice(float minPrice, float maxPrice) {
        return productDAO.getProductByPrice(minPrice,maxPrice);
    }
}
