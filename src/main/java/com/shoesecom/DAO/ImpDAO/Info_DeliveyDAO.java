package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IInfo_DeliveyDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Detail;
import com.shoesecom.Model.Info_delivery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Info_DeliveyDAO implements IInfo_DeliveyDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;



    @Override
    public List<Info_delivery> getInfoByOrderID(int order_id) {
        List<Info_delivery> list = new ArrayList<>();
        String sql ="SELECT * FROM info_delivery where order_id = ?";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,order_id);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Info_delivery(rs.getInt("info_id"),
                        order_id,
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("note")));
            }
        } catch (SQLException e) {
            return null;
        }
        return list;

    }
}
