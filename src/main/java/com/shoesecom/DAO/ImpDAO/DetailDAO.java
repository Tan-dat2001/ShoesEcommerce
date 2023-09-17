package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IDetailDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Detail;
import com.shoesecom.Model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailDAO implements IDetailDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Detail> getAll() {
        List<Detail> list = new ArrayList<>();
        String sql ="SELECT * FROM Detail";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Detail(rs.getInt("order_detail_id"),
                        rs.getInt("product_id"),
                        rs.getInt("order_id"),
                        rs.getString("discount_code"),
                        rs.getFloat("price"),
                        rs.getFloat("total_amount"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public List<Detail> getDetailByID(int order_id) {
        List<Detail> list = new ArrayList<>();

        String sql = "SELECT * FROM order_detail where order_id=?";
                try {
                    statement = DBConnect.getInstall().get();
                    ps = statement.getConnection().prepareStatement(sql);
                    ps.setInt(1,order_id);
                    rs = ps.executeQuery();
                    while (rs.next()){
                        list.add(new Detail(rs.getInt("order_detail_id"),
                                rs.getInt("product_id"),
                                order_id,
                                rs.getString("discount_code"),
                                rs.getFloat("price"),
                                rs.getFloat("total_amount"),
                                rs.getInt("quantity")));
                    }
                } catch (SQLException e) {
                    return null;
                }
                return list;
    }

    public static void main(String[] args) {
        DetailDAO detailDAO = new DetailDAO();
        System.out.println(detailDAO.getDetailByID(1));

    }
}
