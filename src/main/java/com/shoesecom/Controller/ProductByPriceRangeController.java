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

@WebServlet(name = "ProductByPriceRangeController", value = "/product-rangePrice")
public class ProductByPriceRangeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);
//        String minPrice = request.getParameter("lowerValue");
//        String maxPrice = request.getParameter("upperValue");
        float minPrice = Float.parseFloat(request.getParameter("lowerValue"));
        float maxPrice = Float.parseFloat(request.getParameter("upperValue"));
        List<Product> p2 = productService.getProductByPrice(minPrice,maxPrice);
        request.setAttribute("product",p2);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/category-product.jsp");
        rd.forward(request,response);
    }
}
