package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminAccountController", value = "/admin-list-account")
public class AdminAccountController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = accountService.getAll();
        request.setAttribute("acc",accounts);

        RequestDispatcher rd = request.getRequestDispatcher("views/admin/admin-list-account.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
