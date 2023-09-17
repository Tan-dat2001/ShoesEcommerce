package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Delivery;
import com.shoesecom.Model.Order;
import com.shoesecom.Model.Order_status;
import com.shoesecom.Model.Payment;
import com.shoesecom.Service.IDeliveryService;
import com.shoesecom.Service.IOrderService;
import com.shoesecom.Service.IPaymentService;
import com.shoesecom.Service.IStatusService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderController", value = "/admin-list-order")
public class AdminOrderController extends HttpServlet {
    @Inject
    private IOrderService orderService;
    @Inject
    private IDeliveryService  deliveryService;
    @Inject
    private IPaymentService paymentService;
    @Inject
    private IStatusService statusService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Delivery> delivery = deliveryService.getAll();
        request.setAttribute("delivery",delivery);

        List<Payment> payment = paymentService.getAll();
        request.setAttribute("payment",payment);


        List<Order> orders = orderService.getAll();
        request.setAttribute("orders",orders);

        List<Order_status> status = statusService.getAll();
        request.setAttribute("status",status);

        request.getRequestDispatcher("/views/admin/admin-list-order.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
