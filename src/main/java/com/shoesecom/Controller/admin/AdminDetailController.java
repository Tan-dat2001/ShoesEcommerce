package com.shoesecom.Controller.admin;

import com.shoesecom.Model.*;
import com.shoesecom.Service.*;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminDetail", value = "/admin-list-detail")
public class AdminDetailController extends HttpServlet {
    @Inject
    private IDetailService detailService;
    @Inject
    private IOrderService orderService;
    @Inject
    private IProductService productService;
    @Inject
    private IInfo_deliveryService info_deliveryService;
    @Inject
    private IDeliveryService deliveryService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("orderId"));


        List<Detail> detail = detailService.getDetailByID(order_id);
        request.setAttribute("detail",detail);

        List<Product> product = productService.getAllProduct();
        request.setAttribute("product",product);

        Order orders = orderService.getOrderByID(order_id);
        request.setAttribute("orders",orders);

        List<Delivery> delivery = deliveryService.getAll();
        request.setAttribute("delivery",delivery);

        Info_delivery info = info_deliveryService.getInfoByOrderID(order_id);
        request.setAttribute("info",info);
        request.getRequestDispatcher("/views/admin/admin-detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
