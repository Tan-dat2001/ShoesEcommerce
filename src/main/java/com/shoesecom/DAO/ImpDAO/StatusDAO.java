package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IStatusDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Delivery;
import com.shoesecom.Model.Info_delivery;
import com.shoesecom.Model.Order_status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Order_status> getAll() {
        List<Order_status> list = new ArrayList<>();
        String sql ="select * from order_status";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Order_status(rs.getInt("status_id"),
                        rs.getString("status_name")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public List<Order_status> getStatusByID(int status_id) {
        List<Order_status> list = new ArrayList<>();
        String sql ="SELECT * FROM order_status where status_id = ?";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,status_id);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Order_status(
                        status_id,
                        rs.getString("status_name")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }
}
