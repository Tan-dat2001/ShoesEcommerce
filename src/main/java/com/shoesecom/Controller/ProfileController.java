package com.shoesecom.Controller;

import com.shoesecom.Model.Account;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "ProfileController", value = {"/web-profile","/update-profile"})

public class ProfileController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        RequestDispatcher rs = request.getRequestDispatcher("/views/web/profile.jsp");
        rs.forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String url = request.getRequestURI().replace("/","");

        int account_id = Integer.parseInt( request.getParameter("account_id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");

        String selectedDateStr = request.getParameter("dateofbirth");
        java.sql.Date dateofbirth = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(selectedDateStr);
            dateofbirth = new java.sql.Date(utilDate.getTime());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(url.equals("update-profile")){
            Account account = (Account) session.getAttribute("account");
            account.setAccount_id(account_id);
            account.setName(name);
            account.setPhone(phone);
            account.setGender(gender);
            account.setAddress(address);
            account.setDateofbirth(dateofbirth);
            accountService.updateAccount(account);


            session.setAttribute("account",account);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/profile.jsp");
            rd.forward(request,response);



        }


    }
}
