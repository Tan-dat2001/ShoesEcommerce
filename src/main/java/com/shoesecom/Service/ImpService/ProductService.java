package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.IProductDAO;
import com.shoesecom.Model.Image;
import com.shoesecom.Model.PSC;
import com.shoesecom.Model.Product;
import com.shoesecom.Model.Size;
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
    public int searchNewestProduct() {
        return productDAO.searchNewestProduct();
    }

    @Override
    public List<Product> getProductByPrice(float minPrice, float maxPrice) {
        return productDAO.getProductByPrice(minPrice,maxPrice);
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}
