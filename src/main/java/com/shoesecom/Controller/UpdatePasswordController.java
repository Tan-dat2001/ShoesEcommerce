package com.shoesecom.Controller;

import com.shoesecom.Model.Account;
import com.shoesecom.Service.IAccountService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordController", value = "/update-pass")
public class UpdatePasswordController extends HttpServlet {
    @Inject
    private IAccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if(account != null) {
            RequestDispatcher rs = request.getRequestDispatcher("/views/web/update-pass.jsp");
            rs.forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old = request.getParameter("old-password");
        String newP = request.getParameter("new-password");
        String conf = request.getParameter("confirm-password");

        int account_id = Integer.parseInt( request.getParameter("account_id"));

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");


        if(account != null){

            if(old.equals(account.getPassword())){
                if(newP.equals(conf)){

                    account.setAccount_id(account_id);
                    account.setPassword(newP);
                    accountService.updatePassword(account);
                    JOptionPane.showMessageDialog(null, "Thay đổi thành công!");

                }else{
                    request.setAttribute("error1","Mật khẩu không trùng khớp!");
                }
            }else{
                request.setAttribute("error2","Mật khẩu cũ không trùng khớp");
            }
            session.setAttribute("account",account);
            RequestDispatcher rs = request.getRequestDispatcher("/views/web/update-pass.jsp");
            rs.forward(request, response);

        }

    }
}
