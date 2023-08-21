package com.shoesecom.Controller;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Random;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String selectedDateStr = request.getParameter("date");
        java.sql.Date dateofbirth = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(selectedDateStr);
            dateofbirth = new java.sql.Date(utilDate.getTime());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        int code = random.nextInt(999999);

        Account acc = accountService.getAccountByEmail(email);
        if (password == null){
            String errorMessage = "Vui lòng nhập lại";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("register");

        }else if (acc!= null) {
            String errorMessage = "Vui lòng nhập email khác";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("register");
        }
        else {
            Register register = new Register(1,email,password,name,null,null,gender,address,phone,dateofbirth,code);
            accountService.sendEmail(register);
            HttpSession session = request.getSession();
            session.setAttribute("register", register);
            response.sendRedirect("register-code");
        }


    }
}
