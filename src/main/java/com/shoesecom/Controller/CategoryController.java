package com.shoesecom.Controller;

import com.shoesecom.Model.Category;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/web-category")
public class CategoryController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);

        List<Product> product = productService.getAllProduct();
        request.setAttribute("product",product);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/category-product.jsp");
        rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
