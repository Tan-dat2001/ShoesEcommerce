package com.shoesecom.Controller;


import com.shoesecom.DAO.ImpDAO.ProductDAO;
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
//        List<Product> product = productService.getAllProduct();
//        request.setAttribute("product", product);

        //Phân trang
        //lấy giá trị index của trang
        String indexPage = request.getParameter("index");
        if(indexPage == null ) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        ProductDAO productDAO = new ProductDAO();
        int count = productDAO.countProduct();
        int endPage = count/18;
        if(count % 18 != 0) {
            endPage++;
        }
        request.setAttribute("endPage", endPage);
        request.setAttribute("index", index);
        List<Product> listProducts = productDAO.pagingProduct(index);
        request.setAttribute("listProducts", listProducts);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword-searching");
        List<Product> listProducts = productService.searchProduct(keyword);
        request.setAttribute("listProducts",listProducts);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request,response);
    }
}
