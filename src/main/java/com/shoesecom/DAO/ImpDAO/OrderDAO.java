package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IOrderDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.*;

import java.sql.*;
import java.time.LocalDateTime;
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
                Timestamp timestamp = rs.getTimestamp("order_date");
                LocalDateTime orderDate = timestamp.toLocalDateTime();
                list.add(new Order(rs.getInt("order_id"),
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("status_id"),
                        rs.getString("payment_transaction"),
                        rs.getString("order_note"),
                        rs.getFloat("total_amount"),
                        orderDate,
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
                Timestamp timestamp = rs.getTimestamp("order_date");
                LocalDateTime orderDate = timestamp.toLocalDateTime();
                list.add(new Order(order_id,
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("status_id"),
                        rs.getString("payment_transaction"),
                        rs.getString("order_note"),
                        rs.getFloat("total_amount"),
                        orderDate,
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
        List<Order> orderList = new ArrayList<>();
        String sql = "select * from orderclothes where account_id = ?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                Timestamp timestamp = rs.getTimestamp("order_date");
                LocalDateTime orderDate = timestamp.toLocalDateTime();
                orderList.add(new Order(rs.getInt("order_id"),
                        rs.getInt("account_id"),
                        rs.getInt("payment_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("status_id"),
                        rs.getString("payment_transaction"),
                        rs.getString("order_note"),
                        rs.getFloat("total_amount"),
                        orderDate,
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by")));
            }
        }catch (SQLException e){
            return null;
        }
        return orderList;
    }

    @Override
    public void addOrder(Account account, Cart cart, Order order) {
        LocalDateTime currentTime = java.time.LocalDateTime.now();
        String dateTime = currentTime.toString();
        String sql = "insert into orderclothes(account_id, payment_id, delivery_id, payment_transaction, order_date, order_note, total_amount)" +
                "values(?,?,?,?,?,?,?)";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, account.getAccount_id());
            ps.setInt(2,order.getPayment_id());
            ps.setInt(3, order.getDelivery_id());
            ps.setString(4, order.getPayment_transaction());
            ps.setString(5, dateTime);
            ps.setString(6, order.getOrder_note());
            ps.setFloat(7, order.getTotal_amount());
            ps.executeUpdate();
            ResultSet generateKeys = ps.getGeneratedKeys();
            if(generateKeys.next()){
                int orderId = generateKeys.getInt(1);
                order.setOrder_id(orderId);
            }
            generateKeys.close();
            ps.close();
            //Lấy id vừa add
            String sql1 = "select max(order_id) as order_id from orderclothes";
            PreparedStatement ps1 = statement.getConnection().prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                int orderId = rs1.getInt("order_id");
                for(Item i:cart.getItems()){
                    String sql2 = "insert into order_detail(product_id, order_id, price, quantity, total_amount)" +
                            "values(?,?,?,?,?)";
                    PreparedStatement ps2 = statement.getConnection().prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
                    ps2.setInt(1, i.getProduct().getProduct_id());
                    ps2.setInt(2, orderId);
                    ps2.setFloat(3, i.getPrice());
                    ps2.setInt(4, i.getQuantity());
                    ps2.setFloat(5, i.getTotalAmount());
                    ps2.executeUpdate();
                }
            }
            ps1.close();
            rs1.close();
            String sql3 = "update product set quantity = quantity - ?, purchases = purchases + ? where product_id=?";
            PreparedStatement ps3 = statement.getConnection().prepareStatement(sql3);
            for(Item i: cart.getItems()){
                ps3.setInt(1, i.getQuantity());
                ps3.setInt(2, i.getQuantity());
                ps3.setInt(3, i.getProduct().getProduct_id());
                ps3.executeUpdate();
            }
            ps3.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {

    }

    public static void main(String[] args) {
        System.out.println(new OrderDAO().getAllOrderByAccountId(1));
    }
}
