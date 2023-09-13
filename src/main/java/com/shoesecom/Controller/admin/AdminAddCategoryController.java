package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Category;
import com.shoesecom.Service.ICategoryService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminAddCategory", value = "/admin-add-category")
public class AdminAddCategoryController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/admin/admin-add-category.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String category_name = request.getParameter("category_name");
        Category category = new Category(0, category_name, null, null, null, null);

        categoryService.addCategory(category);
        request.getRequestDispatcher("views/admin/admin-list-category.jsp").forward(request, response);
        response.sendRedirect("admin-list-category");


    }
}
