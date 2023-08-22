package com.shoesecom.Controller;


import com.shoesecom.Model.Product;
import com.shoesecom.Service.IAccountService;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/web-home")
public class HomeController extends HttpServlet {
    @Inject
    private IProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        List<Product> product = productService.getAllProduct();
        request.setAttribute("product", product);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
