package com.shoesecom.Service;

import com.shoesecom.Model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category getCategoryByID(int category_id);
    void deleteCategory(int category_id);
    void addCategory(Category category);
    void updateCategory(Category category);
}
