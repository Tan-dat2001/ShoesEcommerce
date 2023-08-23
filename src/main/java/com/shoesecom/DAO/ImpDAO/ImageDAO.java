package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IImageDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ImageDAO implements IImageDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Image> getAllImage() {
        return null;
    }

    @Override
    public Image getImageById(int id) {
        String sql = "select * from image where image_id=?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())    {
                return new Image(id,rs.getInt("product_id"),rs.getString("image1"),rs.getString("image2"), rs.getString("image3"));
            }
        }catch (SQLException e){
            return null;
        }
        return null;
    }

    @Override
    public Image getImageByProductId(int productId) {
        String sql = "select * from image where product_id=?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while(rs.next())    {
                return new Image(rs.getInt("image_id"),productId, rs.getString("image1"),rs.getString("image2"), rs.getString("image3"));
            }
        }catch (SQLException e){
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(new ImageDAO().getImageById(1));
        System.out.println(new ImageDAO().getImageByProductId(1));
    }
}