package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Category;
import com.shoesecom.Service.ICategoryService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryController", value = "/admin-list-category")
public class AdminCategoryController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);


        RequestDispatcher rd = request.getRequestDispatcher("views/admin/admin-list-category.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
