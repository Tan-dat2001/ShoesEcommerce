package com.shoesecom.Controller;

import com.shoesecom.Model.*;
import com.shoesecom.Service.IDeliveryService;
import com.shoesecom.Service.IInfo_deliveryService;
import com.shoesecom.Service.IOrderService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/checkout")
public class CheckoutController extends HttpServlet {
    @Inject
    private IDeliveryService deliveryService;
    @Inject
    private IInfo_deliveryService infoDeliveryService;
    @Inject
    private IOrderService orderService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Delivery> listDelivery = deliveryService.getAll();
        request.setAttribute("listDelivery",listDelivery);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/checkout.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("number");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        LocalDateTime currentTime = java.time.LocalDateTime.now();

        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        Cart cart = (Cart) session.getAttribute("cart");
        List<Item> list = cart.getItems();
        float total=0;
        for(Item item:list) {
            total += item.getProduct().getProduct_price() * item.getQuantity();
        }
        Order order = new Order();
        order.setAccount_id(account.getAccount_id());
        order.setPayment_id(4);
        order.setDelivery_id(5);
//        order.setStatus_id(1);
        order.setPayment_transaction("chưa thanh toán");
        order.setOrder_date(currentTime);
        order.setOrder_note(note);
        order.setTotal_amount(total-deliveryService.getDeliveryByID(5).getDelivery_price());

        orderService.addOrder(account,cart,order);

        Info_delivery infoDelivery = new Info_delivery(0,order.getOrder_id(), name, phone, address,note);
        infoDeliveryService.addInfoDelivery(infoDelivery);
        session.removeAttribute("cart");
        session.setAttribute("size",0);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/success.jsp");
        rd.forward(request,response);

    }
}
