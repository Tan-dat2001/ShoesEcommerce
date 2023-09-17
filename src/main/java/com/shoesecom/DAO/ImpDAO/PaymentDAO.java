package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IPaymentDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Order;
import com.shoesecom.Model.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements IPaymentDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Payment> getAll() {
        List<Payment> list = new ArrayList<>();
        String sql ="select * from Payment";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Payment(rs.getInt("payment_id"),
                        rs.getString("payment_name"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public Payment getDeliveryByID(int payment_id) {
        String sql ="select * from Payment where payment_id=?";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,payment_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Payment(payment_id,
                        rs.getString("payment_name"),
                        rs.getString("status"));
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
