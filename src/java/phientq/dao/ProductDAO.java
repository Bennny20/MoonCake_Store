/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phientq.dto.ProductDTO;
import phientq.utils.DBUtils;

/**
 *
 * @author phien
 */
public class ProductDAO implements Serializable {

    public List<ProductDTO> searchPrice(float from, float to) throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT * FROM Products "
                        + "WHERE price BETWEEN ? AND ?";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, from);
                stm.setFloat(2, to);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ProductDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getBoolean(8),
                            rs.getString(9),
                            rs.getString(10)));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<ProductDTO> listProduct() throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [productID],[productName],[price],[quantity],[createDate],"
                        + "[expirationDate],[image],[status],[shortDescription],[categoryID] FROM Products";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ProductDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getBoolean(8),
                            rs.getString(9),
                            rs.getString(10)));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductByCategory(String categoryID) throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [productID],[productName],[price],[quantity],[createDate],"
                        + "[expirationDate],[image],[status],[shortDescription],[categoryID] "
                        + "FROM Products "
                        + "WHERE categoryID=N'" + categoryID + "'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ProductDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getBoolean(8),
                            rs.getString(9),
                            rs.getString(10)));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductByName(String keyword) throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [productID], [productName],[price],[quantity],[createDate],[expirationDate], "
                        + "[image],[status],[shortDescription],[categoryID] FROM Products WHERE productName LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ProductDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getBoolean(8),
                            rs.getString(9),
                            rs.getString(10)));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean insertProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[Products]"
                        + "([productID], [productName],[price],[quantity],[createDate],[expirationDate],"
                        + "[image],[status],[shortDescription],[categoryID])"
                        + "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductID());
                stm.setString(2, product.getProductName());
                stm.setFloat(3, product.getPrice());
                stm.setInt(4, product.getQuantity());
                stm.setString(5, product.getCreateDate());
                stm.setString(6, product.getExpirationDate());
                stm.setString(7, product.getImage());
                stm.setBoolean(8, product.isStatus());
                stm.setString(9, product.getShortDescription());
                stm.setString(10, product.getCategoryID());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean updateProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "UPDATE [dbo].[Products]"
                        + "SET [productName] = ?, [price] = ?, [quantity] = ?, [createDate] = ?, [expirationDate] = ?, "
                        + "[image] = ?, [status] = ?, [shortDescription] = ?, [categoryID] = ? "
                        + "WHERE  [productID] =  ?";
                stm = con.prepareStatement(sql);

                stm.setString(1, product.getProductName());
                stm.setFloat(2, product.getPrice());
                stm.setInt(3, product.getQuantity());
                stm.setString(4, product.getCreateDate());
                stm.setString(5, product.getExpirationDate());
                stm.setString(6, product.getImage());
                stm.setBoolean(7, product.isStatus());
                stm.setString(8, product.getShortDescription());
                stm.setString(9, product.getCategoryID());
                stm.setString(10, product.getProductID());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public ProductDTO getProductByID(String ID) throws SQLException, ClassNotFoundException {
        ProductDTO product = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [productID],[productName],[price],[quantity],[createDate],"
                        + "[expirationDate],[image],[status],[shortDescription],[categoryID] "
                        + "FROM Products WHERE productID LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + ID + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    product = new ProductDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getBoolean(8),
                            rs.getString(9),
                            rs.getString(10));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return product;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductDAO dao = new ProductDAO();
        List<ProductDTO> list = dao.listProduct();
        for (ProductDTO productDTO : list) {
            System.out.println(productDTO);
        }
    }

    public boolean updateProductQuantity(String productID, int newQuantity) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "update Products set quantity = ? where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, newQuantity);
                stm.setString(2, productID);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public int checkQuantity(String id) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "Select quantity "
                        + "From Products "
                        + "Where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("quantity");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public void delete(String id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "Delete "
                        + "From Products "
                        + "Where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.executeUpdate();
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
