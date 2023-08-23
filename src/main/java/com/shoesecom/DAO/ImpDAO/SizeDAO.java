package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.ISizeDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Size;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SizeDAO implements ISizeDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Size> getAllSize() {
        List<Size> results = new ArrayList<>();
        String sql = "select * from size";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                results.add(new Size(rs.getInt("size_id"),rs.getInt("size_name")));
            }
        }catch (SQLException e ){
            return null;
        }
        return results;
    }
}
