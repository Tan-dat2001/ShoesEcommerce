package com.shoesecom.Controller;

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

@WebServlet(name = "ProcessNumCartController", value = "/processNum")
public class ProcessNumCartController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        //co roi
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String requestURI = request.getRequestURI();
        String processString = requestURI.substring(requestURI.lastIndexOf('/') + 1);
        //Lấy id sản phẩm cần xóa khỏi giỏ hàng
        int productId = Integer.parseInt(request.getParameter("productId"));
        int num = Integer.parseInt(request.getParameter("num").trim());
        int size = Integer.parseInt(request.getParameter("size"));
        //thêm và giảm số lượng sản phẩm
        try {
            if (num == -1 && cart.getQuantityById(productId) <= 1) {
                cart.removeItem(productId);
            } else {
                Product product = productService.getProductById(productId);
                float price = product.getProduct_price();
                Item item = new Item(product, num, price, size);
                cart.addItem(item);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }


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
