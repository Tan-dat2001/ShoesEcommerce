package com.shoesecom.Controller;

import com.shoesecom.DAO.IImageDAO;
import com.shoesecom.Model.Image;
import com.shoesecom.Model.Product;
import com.shoesecom.Model.Size;
import com.shoesecom.Service.IImageService;
import com.shoesecom.Service.IProductService;
import com.shoesecom.Service.ISizeService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "ProductDetail", value = "/product-detail")
public class ProductDetailController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private ISizeService sizeService;
    @Inject
    private IImageService imageService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.getProductById(productId);
        request.setAttribute("product",product);
        DecimalFormat decimalFormat = new DecimalFormat("#,### đ");
        String formattedPrice = decimalFormat.format(product.getProduct_price());
        request.setAttribute("productPrice",formattedPrice);
        List<Size> listSize = sizeService.getAllSize();
        request.setAttribute("listSize",listSize);
        Image image = imageService.getImageByProductId(productId);
        request.setAttribute("image",image);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/product-detail.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
