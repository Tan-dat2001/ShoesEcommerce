package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.ImpDAO.ProductDAO;
import com.shoesecom.Model.Category;
import com.shoesecom.Model.PSC;
import com.shoesecom.Model.Product;
import com.shoesecom.Model.Size;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IProductService;
import com.shoesecom.Service.IPscService;
import com.shoesecom.Service.ISizeService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductController", value = "/admin-product")
public class AdminProductController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IPscService pscService;

    @Inject
    private ISizeService sizeService;
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

        List<Product> listProducts = productDAO.pagingProduct(index);
        request.setAttribute("listProducts", listProducts);

        List<Category> category = categoryService.getAllCategory();
        request.setAttribute("category",category);


        //int product_id = Integer.parseInt(request.getParameter("product_id"));

        List<PSC> psc = pscService.GetAllPSC();
        //List<PSC> psc = pscService.GetPSCBySize(product_id);
        request.setAttribute("psc",psc);

        List<Size> size = sizeService.getAllSize();
        request.setAttribute("size",size);



        RequestDispatcher rd = request.getRequestDispatcher("views/admin/admin-list-product.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
