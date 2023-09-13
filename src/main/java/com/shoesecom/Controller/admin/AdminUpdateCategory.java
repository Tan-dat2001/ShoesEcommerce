package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Category;
import com.shoesecom.Service.ICategoryService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUpdateCategory", value = "/admin-edit-category")
public class AdminUpdateCategory extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category  c = categoryService.getCategoryByID(category_id);
        request.setAttribute("c",c);
        request.getRequestDispatcher("views/admin/admin-update-category.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String category_name = request.getParameter("category_name");
        Category category = new Category(category_id,category_name,null,null,null,null);

        categoryService.updateCategory(category);
        request.getRequestDispatcher("views/admin/admin-list-category.jsp").forward(request, response);
        response.sendRedirect("admin-list-category");


    }
}
