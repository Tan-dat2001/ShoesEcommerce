package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IDeliveryDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Delivery;
import com.shoesecom.Model.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO implements IDeliveryDAO {

    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Delivery> getAll() {
        List<Delivery> list = new ArrayList<>();
        String sql ="select * from Delivery";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Delivery(rs.getInt("delivery_id"),
                        rs.getString("delivery_name"),
                        rs.getString("status"),rs.getFloat("delivery_price")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public Delivery getDeliveryByID(int delivery_id) {
        String sql ="select * from Delivery where delivery_id=?";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,delivery_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Delivery(delivery_id,
                        rs.getString("delivery_name"),
                        rs.getString("status"),rs.getFloat("delivery_price"));
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
