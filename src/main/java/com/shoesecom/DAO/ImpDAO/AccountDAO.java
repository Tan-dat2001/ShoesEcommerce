package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO implements IAccountDAO {
    Statement statement = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean checkLogin(String email, String password) {
        boolean isValid = false;
        String sql = "SELECT * FROM `account` WHERE email=? and password=?";
        statement = DBConnect.getInstall().get();
        try {
            ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()){
                isValid = true;
                System.out.println("dung");

            }else {
                isValid = false;
                System.out.println("sai");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return isValid;



    }

    @Override
    public Account getAccountByEmail(String email) {
        String sql = "select * from account where email=?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1,email);
            rs = ps.executeQuery();
            while (rs.next()){
                return new Account(
                        rs.getInt("account_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("status"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getDate("dateofbirth"),
                        rs.getTimestamp("create_at"),
                        rs.getString("create_by"),
                        rs.getTimestamp("update_at"),
                        rs.getString("update_by"));
            }
        }catch (SQLException e){
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO acc = new AccountDAO();
        acc.checkLogin("user@gmail.com","user");


    }
}
