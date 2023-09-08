package com.shoesecom.Controller;

import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessCartController", value = "/process-cart")
public class ProcessCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if(o != null){
            cart = (Cart) o;
        }else{
            cart = new Cart();
        }
        cart.removeItem(productId);
        // Lấy lại danh sách items trong giỏ hàng
        List<Item> list = cart.getItems();
        session.setAttribute("listItem", list);
        session.setAttribute("cart", cart);
        session.setAttribute("size", list.size()); // .size để lấy số lượng có trong cart

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
