package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.ICategoryDAO;
import com.shoesecom.Service.ICategoryService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "admin-delete-category", value = "/admin-delete-category")
public class AdminDeletecategory extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        categoryService.deleteCategory(category_id);
        response.sendRedirect("admin-list-category");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
