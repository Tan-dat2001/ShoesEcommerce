package com.shoesecom.Controller;

import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Item;
import com.shoesecom.Model.Product;
import com.shoesecom.Service.IProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddToCartController", value = "/addtocart")
public class AddToCartController extends HttpServlet {

    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Account account = (Account) session.getAttribute("account");
        if(account != null){
            Cart cart = null;
            Object o = session.getAttribute("cart");
            if(o != null){
                cart = (Cart) o;
            }else{
                cart = new Cart();
            }
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            int size = Integer.parseInt(request.getParameter("selectedSize"));
            Product product = productService.getProductById(productId);
            float price =  product.getProduct_price();
            Item item = new Item(product, quantity, price, size);
            cart.addItem(item);
            List<Item> list = cart.getItems();
            session.setAttribute("listItem",list);
            session.setAttribute("cart",cart);
            session.setAttribute("size", list.size()); // .size để lấy số lượng có trong cart
//			RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(request, response);
            response.sendRedirect("web-home");
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
