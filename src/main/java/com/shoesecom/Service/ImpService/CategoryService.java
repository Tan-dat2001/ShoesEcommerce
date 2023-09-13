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

    @Override
    public Category getCategoryByID(int category_id) {
        return categoryDAO.getCategoryByID(category_id);
    }


    @Override
    public void deleteCategory(int category_id) {
        categoryDAO.deleteCategory(category_id);
    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);

    }
}
