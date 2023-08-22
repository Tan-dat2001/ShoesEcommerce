package com.shoesecom.Service.ImpService;

import com.shoesecom.DAO.ICategoryDAO;
import com.shoesecom.Model.Category;
import com.shoesecom.Service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO categoryDAO;
    @Override
    public List<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }
}
