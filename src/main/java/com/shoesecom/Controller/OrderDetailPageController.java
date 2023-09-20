package com.shoesecom.Controller;

import com.shoesecom.Model.*;
import com.shoesecom.Service.IDetailService;
import com.shoesecom.Service.IInfo_deliveryService;
import com.shoesecom.Service.IOrderService;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderDetailPageController", value = "/order-detail")
public class OrderDetailPageController extends HttpServlet {

    @Inject
    private IInfo_deliveryService infoDeliveryService;
    @Inject
    private IOrderService orderService;
    @Inject
    private IDetailService detailService;
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Info_delivery infoDelivery = infoDeliveryService.getInfoByOrderID(orderId);
        request.setAttribute("infoDelivery",infoDelivery);

        //Lấy thông tin đơn hàng bởi id đơn hàng.
        Order orderInfo = orderService.getOrderByID(orderId);
        request.setAttribute("orderInfo", orderInfo);
        //Lấy danh sách orderDetails, cụ thể là các sản phẩm trong một đơn hàng
        List<Detail> orderDetails = detailService.getDetailByID(orderId);
        request.setAttribute("orderDetails",orderDetails);
        List<Product> products = new ArrayList<>();
        for(Detail orderDetail:orderDetails) {
            Product product = productService.getProductById(orderDetail.getProduct_id());
            products.add(product);
            request.setAttribute("products", products);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/order-detail.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
