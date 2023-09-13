package com.shoesecom.Controller.admin;

import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminChangeStatusAccount", value = "/admin-change-status-account")
public class AdminChangeStatusAccount extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int account_id = Integer.parseInt(request.getParameter("account_id"));
        String status = request.getParameter("status");
        if (status.equals("disable")){
            accountService.changeStatusAccount(account_id,"enable");
            response.sendRedirect("admin-list-account");
        }else {
            accountService.changeStatusAccount(account_id,"disable");
//            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/admin-list-account.jsp");
//            rd.forward(request,response);
            response.sendRedirect("admin-list-account");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
