package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Category;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IProductService;
import com.shoesecom.Service.IPscService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminAddProductController", value = "/admin-add-product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
    maxFileSize = 1024 * 1024 * 50,
    maxRequestSize = 1024 * 1024 * 50)
public class AdminAddProductController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IProductService productService;
    @Inject
    private IPscService pscService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.getAllCategory();
        request.setAttribute("listCategory",listCategory);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/add-product.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        int categoryId = Integer.parseInt(request.getParameter("selectedCategory"));
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        productService.addProduct(new Product(0,categoryId,0,0,quantity,productName,description,image1,"enable",productPrice,null,null,null,null));




    }
}
