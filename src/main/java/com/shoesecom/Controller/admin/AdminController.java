package com.shoesecom.Controller.admin;

import com.shoesecom.DAO.ImpDAO.ProductDAO;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Category;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.ICategoryService;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", value = "/admin-home")
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (!isAdminUser(request)) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "access-denied.jsp");
    //        RequestDispatcher rd = request.getRequestDispatcher("views/access-denied.jsp");
    //        rd.forward(request,response);
            //return;
//        }else {
            RequestDispatcher rd = request.getRequestDispatcher("views/admin/admin.jsp");
            rd.forward(request,response);

        //}


    }

//    private boolean isAdminUser(HttpServletRequest request) {
//        HttpSession session = request.getSession(false); // Lấy session hiện tại, không tạo mới nếu chưa tồn tại
//        if (session != null) {
//            // Lấy thông tin về quyền của người dùng từ session hoặc cơ sở dữ liệu
//            String role = (String) session.getAttribute("admin");
//
//            // Kiểm tra xem người dùng có quyền admin không
//            return "admin".equals(role);
//        }
//
//        // Nếu không có session hoặc không có thông tin quyền, trả về false
//        return false;
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
