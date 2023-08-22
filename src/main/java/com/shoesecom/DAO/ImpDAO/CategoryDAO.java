package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.ICategoryDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Category;
import com.shoesecom.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    Statement statement =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql= "select * from category";
        statement = DBConnect.getInstall().get();
        try {
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Category(rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
