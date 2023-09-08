package com.shoesecom.Controller;

import com.shoesecom.Model.Category;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IImageService;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductByCategoryController", value = "/product-category")
public class ProductByCategoryController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        List<Product> p = productService.getProductByCategory(categoryId);
        request.setAttribute("product",p);

        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/category-product.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
