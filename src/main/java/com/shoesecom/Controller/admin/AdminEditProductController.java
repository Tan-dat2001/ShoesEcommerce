package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.ISizeDAO;
import com.shoesecom.Model.*;
import com.shoesecom.Service.*;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminEditProductController", value = "/admin-edit-product")
public class AdminEditProductController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private IImageService imageService;
    @Inject
    private ICategoryService categoryService;
    @Inject
    private IPscService pscService;
    @Inject
    private ISizeService sizeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.getAllCategory();
        request.setAttribute("listCategory",listCategory);
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.getProductById(productId);
        request.setAttribute("product",product);
        Image image = imageService.getImageByProductId(productId);
        request.setAttribute("image",image);
        List<PSC> listPSC = pscService.GetPSCBySize(productId);
        request.setAttribute("listPSC",listPSC);
        List<Size> listSize = sizeService.getAllSize();
        request.setAttribute("listSize",listSize);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/admin-edit-product.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        String status = request.getParameter("selectedStatus");
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
        int[] arrayQuantitySize = {q38,q39,q40,q41,q42,q43};

        int totalQuantitySize = q38 + q39 + q40 + q41 + q42 + q43;
        if(totalQuantitySize == quantity){
            //1. get product by id and update the infomation of product
            Product product = productService.getProductById(productId);
            product.setProduct_name(productName);
            product.setCategory_id(categoryId);
            product.setProduct_price(productPrice);
            product.setProduct_image(image1);
            product.setProduct_desc(description);
            product.setQuantity(quantity);
            product.setStatus(status);
            productService.editProduct(product);
            //2. update psc
            List<PSC> listPSC = pscService.GetPSCBySize(productId);
            for (PSC psc:listPSC) {
                for (int i=1;i<=arrayQuantitySize.length;i++) {
                    if(psc.getSize_id() == i){
                        PSC psc1 = new PSC(0, productId, psc.getSize_id(), arrayQuantitySize[i-1]);
                        pscService.editPSC(psc1);
                    }
                }
            }
            imageService.editImage(new Image(0,productId,image1,image2,image3));
            response.sendRedirect("admin-product");
        }else{
            request.setAttribute("errorMessageQuantity", "Thông báo lỗi!!! <br>Tổng số lượng các size phải bằng với số lượng sản phẩm nhập vào!!!");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/add-product.jsp");
            rd.forward(request,response);
        }
    }
}
