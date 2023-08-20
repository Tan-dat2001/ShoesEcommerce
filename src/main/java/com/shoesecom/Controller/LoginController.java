package com.shoesecom.Controller;

import com.shoesecom.Model.Account;
import com.shoesecom.Service.IAccountService;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("views/web/login.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        boolean isValid = accountService.checkLogin(email,password);
        if(isValid){
            Account account = accountService.getAccountByEmail(email);
            session.setAttribute("account",account);
            session.setAttribute("email", email);
            session.setAttribute("name", account.getName());
            session.setAttribute("account_id", account.getAccount_id());
            if (account.getRole() == "admin"){
                Account admin = accountService.getAccountByEmail(email);
                session.setAttribute("admin",admin);

                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/admin.jsp");
                rd.forward(request,response);
                response.sendRedirect("admin-home");

            }else if (account.getRole() == "user"){
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(request,response);
                response.sendRedirect("web-home");

            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request,response);
            }

        }
        else {
            session.setAttribute("errorMessage", "Đăng nhập thất bại! <br> Vui lòng kiểm tra lại email và mật khẩu.");
            response.sendRedirect("login");
        }



    }
}
