package com.shoesecom.Controller.admin;

import com.shoesecom.Model.Order;
import com.shoesecom.Service.IOrderService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminChangeStatusOrderController", value = "/admin-change-status-order")
public class AdminChangeStatusOrderController extends HttpServlet {
    @Inject
    private IOrderService orderService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));

        Order orders = orderService.getOrderByID(order_id);
        request.setAttribute("orders",orders);

        if (status_id == 1){
            orderService.changeStatusOrder(order_id,1);
            response.sendRedirect("admin-list-order");
        }else if (status_id == 2){
            orderService.changeStatusOrder(order_id,2);
            response.sendRedirect("admin-list-order");

        }else if (status_id == 3){
            orderService.changeStatusOrder(order_id,3);
            response.sendRedirect("admin-list-order");

        }else if (status_id == 4){
            orderService.changeStatusOrder(order_id,4);
            response.sendRedirect("admin-list-order");

        }
        else {
            orderService.changeStatusOrder(order_id,5);
            response.sendRedirect("admin-list-order");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
