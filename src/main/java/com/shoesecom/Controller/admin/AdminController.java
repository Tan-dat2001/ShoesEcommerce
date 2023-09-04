package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.ImpDAO.ProductDAO;
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

@WebServlet(name = "AdminController", value = "/admin-home")
public class AdminController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private ICategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);
        List<Product> listProducts = productDAO.pagingProduct(index);
        request.setAttribute("listProducts", listProducts);
        RequestDispatcher rd = request.getRequestDispatcher("views/admin/admin.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
