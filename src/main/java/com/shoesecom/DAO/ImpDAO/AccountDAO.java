package com.shoesecom.DAO.ImpDAO;

import com.shoesecom.DAO.IAccountDAO;
import com.shoesecom.DbConnect.DBConnect;
import com.shoesecom.Model.Account;
import com.shoesecom.Model.Register;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

    @Override
    public void crateAccount(Register register) {
        String sql = "INSERT INTO `account`( `email`, `password`, `name`, `gender`, `address`, `phone`, `dateofbirth`) " +
                "VALUES " +
                "(?,?,?,?,?,?,?)";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setString(1,register.getEmail());
            ps.setString(2,register.getPassword());
            ps.setString(3,register.getName());
            ps.setString(4,register.getGender());
            ps.setString(5,register.getAddress());
            ps.setString(6,register.getPhone());
            ps.setDate(7,register.getDateofbirth());


            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void sendEmail(Register register) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.name", "Karma");
        String subject = " Code OTP Register shop karma";
        String text="<h1>Mã code nhập để xác nhận đăng ký \n"+register.getCode()+"</h1>";
        String account = "thuyhien15082002@gmail.com";
        String pass = "tuciuneysyypbuim";

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account,pass);
            }
        });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setRecipient(RecipientType.TO, new InternetAddress(register.getEmail()));
            message.setHeader("Content-type","text/html;charset=UTF-8");
            message.setSubject(subject);
            message.setContent(text,"text/html;charset=UTF-8");
            Transport.send(message);

        }catch (MessagingException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Account> getAll() {
        List<Account> accountList = new ArrayList<>();
        String sql = "select * from account";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                accountList.add(new Account(rs.getInt("account_id"),
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
                        rs.getString("update_by")));
            }
            return accountList;
        }catch (SQLException e){
            return null;
        }

    }

    @Override
    public List<Account> getAccountbyID(int account_id) {
        List<Account> accountList = new ArrayList<>();
        String sql = "SELECT * FROM `account` WHERE account_id = ?;\n";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, account_id);
            rs = ps.executeQuery();
            while (rs.next()){
                 accountList.add(new Account(rs.getInt("account_id"),
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
                        rs.getString("update_by")));
            }
            return accountList;
        }catch (SQLException e){
            return null;
        }

    }

    public static void main(String[] args) {
        AccountDAO acc = new AccountDAO();
        acc.getAll();


    }
}
