package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IOrderDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Cart;
import com.shoesecom.Model.Order;
import com.shoesecom.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Order> getAll() {
        List<Order> list = new ArrayList<>();
        String sql ="SELECT * FROM orderclothes order by order_id desc";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Order(rs.getInt("order_id"),
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("status_id"),
                        rs.getString("payment_transaction"),
                        rs.getString("order_note"),
                        rs.getFloat("total_amount"),
                        rs.getDate("order_date"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public List<Order> getOrderByID(int order_id) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orderclothes where order_id=?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,order_id);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Order(order_id,
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("status_id"),
                        rs.getString("payment_transaction"),
                        rs.getString("order_note"),
                        rs.getFloat("total_amount"),
                        rs.getDate("order_date"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public List<Order> getAllOrderByAccountId(int id) {
        return null;
    }

    @Override
    public void addOrder(Account account, Cart cart, Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }
}
