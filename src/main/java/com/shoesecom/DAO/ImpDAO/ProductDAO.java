package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IProductDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();
        String sql ="SELECT * FROM product";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                productList.add(new Product(rs.getInt("product_id"),
                        rs.getInt("category_id"),
                        rs.getInt("discount_id"),
                        rs.getInt("purchases"),
                        rs.getInt("quantity"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getString("product_image"),
                        rs.getString("status"),
                        rs.getFloat("product_price"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by")));


            }


        } catch (SQLException e) {
            return null;
        }
        return productList;

    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().getAllProduct());

    }
}
