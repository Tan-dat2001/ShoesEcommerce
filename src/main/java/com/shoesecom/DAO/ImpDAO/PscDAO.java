package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IPscDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.PSC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PscDAO implements IPscDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<PSC> GetAllPSC() {
        List<PSC> list = new ArrayList<>();
        String sql = "SELECT * FROM psc;";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PSC psc = new PSC(
                        rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("size_id"),
                        rs.getInt("quantity"));
                list.add(psc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<PSC> GetPSCBySize(int product_id) {
        List<PSC> list = new ArrayList<>();
        String sql = "SELECT * FROM psc where product_id = ?;";

        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new PSC(rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("size_id"),
                        rs.getInt("quantity")));

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addPSC(PSC psc) {
        String sql = "insert into psc(product_id, size_id, quantity) values(?,?,?)";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,psc.getProduct_id());
            ps.setInt(2,psc.getSize_id());
            ps.setInt(3,psc.getQuantity());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editPSC(PSC psc) {

    }

    @Override
    public void deletePSC(int id) {

    }

    public static void main(String[] args) {
        System.out.println(new PscDAO().GetPSCBySize(1));

    }
}


