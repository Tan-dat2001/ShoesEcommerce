package com.shoesecom.Controller.admin;

import com.shoesecom.Model.*;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IProductService;
import com.shoesecom.Service.IPscService;
import com.shoesecom.Service.ImpService.ImageService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminAddProductController", value = "/admin-add-product")
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
//    maxFileSize = 1024 * 1024 * 50,
//    maxRequestSize = 1024 * 1024 * 50)
public class AdminAddProductController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IProductService productService;
    @Inject
    private IPscService pscService;
    @Inject
    private ImageService imageService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.getAllCategory();
        request.setAttribute("listCategory",listCategory);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/add-product.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productName = request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        int categoryId = Integer.parseInt(request.getParameter("selectedCategory"));
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int q38 = Integer.parseInt(request.getParameter("size38"));
        int q39 = Integer.parseInt(request.getParameter("size39"));
        int q40 = Integer.parseInt(request.getParameter("size40"));
        int q41 = Integer.parseInt(request.getParameter("size41"));
        int q42 = Integer.parseInt(request.getParameter("size42"));
        int q43 = Integer.parseInt(request.getParameter("size43"));
        int totalQuantitySize = q38 + q39 + q40 + q41 + q42 + q43;
        if(totalQuantitySize == quantity){
            productService.addProduct(new Product(0,categoryId,0,20,quantity,productName,description,image1,"enabled",productPrice,null,null,null,null));
            //1.find product by Newest Product
            int productId = productService.searchNewestProduct();
            Product product = productService.getProductById(productId);
            //3.add into image vs psc
            pscService.addPSC(new PSC(0,productId,1,q38));
            pscService.addPSC(new PSC(0,productId,2,q39));
            pscService.addPSC(new PSC(0,productId,3,q40));
            pscService.addPSC(new PSC(0,productId,4,q41));
            pscService.addPSC(new PSC(0,productId,5,q42));
            pscService.addPSC(new PSC(0,productId,6,q43));


            imageService.addImage(new Image(0,productId,image1,image2,image3));
            response.sendRedirect("admin-product");
        }else{
            request.setAttribute("errorMessageQuantity", "Thông báo lỗi!!! <br>Tổng số lượng các size phải bằng với số lượng sản phẩm nhập vào!!!");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/add-product.jsp");
            rd.forward(request,response);
        }

    }
}
