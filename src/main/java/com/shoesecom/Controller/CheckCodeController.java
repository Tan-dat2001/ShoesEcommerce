package com.shoesecom.Controller;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.Model.Register;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCodeController", value = "/register-code")
public class CheckCodeController extends HttpServlet {
    @Inject
    private IAccountDAO accountDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/web/register-code.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer code = Integer.parseInt(request.getParameter("code"));
        Register register = (Register) request.getSession().getAttribute("register");
        if (code != (register.getCode())) {
            String errorMessage = "Vui lòng nhập lại mã";
            request.getSession().setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("views/web/register-code.jsp").forward(request,response);
        } else {

            accountDAO.crateAccount(register);
            request.getSession().setAttribute("register", null);
            request.getRequestDispatcher("/views/web/login.jsp").forward(request, response);
        }

    }
}
