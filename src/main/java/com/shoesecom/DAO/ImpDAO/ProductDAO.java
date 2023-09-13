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
        String sql ="SELECT * FROM product order by product_id desc";

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

    @Override
    public Product getProductById(int id) {
        String sql = "select * from product where product_id=?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(id,
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
                        rs.getString("update_by"));
            }
        }catch (SQLException e){
            return null;
        }
        return null;
    }

    @Override
    public List<Product> getProductByCategory(int category_id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where category_id =?";

        try {
            statement= DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1,category_id);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Product(
                        rs.getInt("product_id"),
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
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int countProduct() {
        String sql ="select count(*) from product";
        try {
            statement= DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Product> pagingProduct(int index) {
        List<Product> results = new ArrayList<>();
        String sql = " SELECT * FROM product ORDER BY product_id desc LIMIT 18 OFFSET ? ";
        //litmit 18 chỉ định 18 sản phẩm được hiển thị
        //offset ? chỉ định bắt đầu từ hàng(row) thứ mấy
        try {
           statement = DBConnect.getInstall().get();
           ps = statement.getConnection().prepareStatement(sql);
           ps.setInt(1, (index-1)*18);
           rs = ps.executeQuery();
           while(rs.next()){
                results.add(new Product(
                       rs.getInt("product_id"),
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
        }catch (SQLException e){
            return null;
        }
        return results;
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        List<Product> results = new ArrayList<>();
        String sql = "select * from product where product_name like ?";
        try {
             statement = DBConnect.getInstall().get();
             ps = statement.getConnection().prepareStatement(sql);
             ps.setString(1,"%" + keyword + "%");
             rs = ps.executeQuery();
             while(rs.next()){
                 results.add(new Product(
                         rs.getInt("product_id"),
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
        }catch (SQLException e ){
            return null;
        }
        return results;
    }

    @Override
    public int searchNewestProduct() {
        String sql = "select max(product_id) as product_id from product";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("product_id");
            }
        }catch (SQLException e){
            return 0;
        }
        return 0;
    }

    @Override
    public List<Product> getProductByPrice(float minPrice, float maxPrice) {
        List<Product> results = new ArrayList<>();
        String sql = "select * from product where product_price >= ? and product_price <= ?";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setFloat(1, minPrice);
            ps.setFloat(2, maxPrice);
            rs = ps.executeQuery();
            while(rs.next()){
                 results.add(new Product(
                        rs.getInt("product_id"),
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
        }catch (SQLException e){
            return null;
        }
        return results;
    }

    @Override
    public void addProduct(Product product) {
        String insertProductSQL = "INSERT INTO product (category_id, discount_id, product_name, product_desc, product_price, product_image, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";


        try{
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(insertProductSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, product.getCategory_id());
            ps.setInt(2, product.getDiscount_id());
            ps.setString(3, product.getProduct_name());
            ps.setString(4, product.getProduct_desc());
            ps.setFloat(5, product.getProduct_price());
            ps.setString(6, product.getProduct_image());
            ps.setInt(7, product.getQuantity());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi hoặc log lỗi ở đây
        }
//        String sql = "insert into product(category_id, discount_id, product_name, product_desc, product_price, product_image, quantity)"
//                + "values(?,?,?,?,?,?,?)";
//        try {
//            statement = DBConnect.getInstall().get();
//            ps = statement.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, product.getCategory_id());
//            ps.setInt(2, product.getDiscount_id());
//            ps.setString(3, product.getProduct_name());
//            ps.setString(4, product.getProduct_desc());
//            ps.setFloat(5, product.getProduct_price());
//            ps.setString(6, product.getProduct_image());
//            ps.setInt(7, product.getQuantity());
//            ps.executeUpdate();
//            ResultSet generateKeys = statement.getGeneratedKeys();
//            if(generateKeys.next()){
//                int productId = generateKeys.getInt(1);
//                product.setProduct_id(productId);
//            }
//            generateKeys.close();
//            ps.close();
//            // Lấy id của product vừa add
//            String sql1 = "select max(product_id) as product_id from product";
//            PreparedStatement ps1 = statement.getConnection().prepareStatement(sql1);
//            ResultSet rs1 = ps1.executeQuery();
//            if(rs1.next()){
//                int productId = rs1.getInt("product_id");
//                String sql2 = "insert into psc(product_id) values(?)";
//                PreparedStatement ps2 = statement.getConnection().prepareStatement(sql2);
//                ps2.setInt(1, productId);
//                ps2.executeUpdate();
//
//                String sql3 = "insert into image(product_id) values(?)";
//                PreparedStatement ps3 = statement.getConnection().prepareStatement(sql3);
//                ps3.setInt(1, productId);
//                ps3.executeUpdate();
//            }
//            ps1.close();
//            rs1.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void editProduct(Product product) {
        String sql = "update product set category_id = ?, discount_id=?, product_name=?, product_desc=?, product_price=?, " +
                "product_image=?, quantity=?, status=? where product_id=? ";
        try {
            statement = DBConnect.getInstall().get();
            ps = statement.getConnection().prepareStatement(sql);
            ps.setInt(1, product.getCategory_id());
            ps.setInt(2, product.getDiscount_id());
            ps.setString(3, product.getProduct_name());
            ps.setString(4,product.getProduct_desc());
            ps.setFloat(5, product.getProduct_price());
            ps.setString(6, product.getProduct_image());
            ps.setInt(7, product.getQuantity());
            ps.setString(8, product.getStatus());
            ps.setInt(9, product.getProduct_id());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(int id) {

    }


    public static void main(String[] args) {
//        System.out.println(new ProductDAO().getAllProduct());
//        System.out.println(new ProductDAO().getProductById(1));
//        System.out.println(new ProductDAO().searchProduct("Jordan"));

//        new ProductDAO().addProduct(new Product(0,1,0,20,100,"Giay New1","KKKKKKKKK","image1","enabled",200000,null,null,null,null));
        System.out.println(new ProductDAO().searchNewestProduct());

    }
}
