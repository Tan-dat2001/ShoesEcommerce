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

    @Override
    public Category getCategoryByID(int category_id) {

        String sql= "select * from category where category_id= ? ";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,category_id);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Category(rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by"));

            }

        }catch (SQLException e){
            throw new RuntimeException();
        }
        return new Category();

    }


    @Override
    public void deleteCategory(int category_id) {
        String sql="delete from category where category_id = ?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, category_id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void addCategory(Category category) {
        String sql = "INSERT INTO `category`(`category_name`) VALUES (?)";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1, category.getCategory_name());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateCategory(Category category) {
        String sql= "UPDATE category SET category_name = ? WHERE category_id = ? ";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1,category.getCategory_name());
            ps.setInt(2,category.getCategory_id());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        //c.getCategoryByID(5);
        c.getAllCategory();

    }


}
