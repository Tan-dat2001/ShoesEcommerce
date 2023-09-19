package com.shoesecom.Controller;

import com.shoesecom.DAO.ImpDAO.Info_DeliveyDAO;
import com.shoesecom.Model.*;
import com.shoesecom.Service.IDetailService;
import com.shoesecom.Service.IInfo_deliveryService;
import com.shoesecom.Service.IOrderService;
import com.shoesecom.Service.IStatusService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "YourOrderPageController", value = "/your-order")
public class YourOrderPageController extends HttpServlet {
    @Inject
    private IOrderService orderService;
    @Inject
    private IInfo_deliveryService infoDeliveryService;
    @Inject
    private IDetailService detailService;
    @Inject
    private IStatusService statusService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        List<Order> listOrder = orderService.getAllOrderByAccountId(account.getAccount_id());
        request.setAttribute("listOrder",listOrder);
        List<Info_delivery> infoDeliveries = new ArrayList<>();
        Info_delivery infoDelivery = new Info_delivery();
        Info_DeliveyDAO infoDeliveyDAO = new Info_DeliveyDAO();
        for(Order order:listOrder){
            //Lấy thông tin đơn hàng
            List<Detail> listOrderDetail = detailService.getDetailByID(order.getOrder_id());
            request.setAttribute("listOrderDetail",listOrderDetail);
            //Vận chuyển
            infoDelivery = infoDeliveryService.getInfoByOrderID(order.getOrder_id());
            infoDeliveries.add(infoDelivery);
            request.setAttribute("infoDeliveries",infoDeliveries);
            //            System.out.println(infoDelivery);
            //Trạng thái đơn hàng
            List<Order_status> orderStatus = statusService.getStatusByID(order.getStatus_id());
            request.setAttribute("orderStatus",orderStatus);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/your-order.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
