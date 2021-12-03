/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phientq.dto.OrderDetailDTO;
import phientq.utils.DBUtils;

/**
 *
 * @author phien
 */
public class OrderDetailDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeDB() throws NullPointerException, SQLException {
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

    public boolean saveOrderDetail(OrderDetailDTO od) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[OrderDetail]([orderID],[productID],[price],[quantity]) "
                        + "VALUES(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, od.getOrderID());
                stm.setString(2, od.getProductID());
                stm.setFloat(3, od.getPrice());
                stm.setInt(4, od.getQuantity());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return check;
    }

    public List<OrderDetailDTO> getListOrderDetails(String orderID) throws SQLException, ClassNotFoundException {
        List<OrderDetailDTO> listDetailsDTO = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "select OrderDetail.orderID, OrderDetail.productID, "
                        + " OrderDetail.quantity, OrderDetail.price, Products.productName "
                        + "from OrderDetail "
                        + "INNER JOIN Products on OrderDetail.productID = Products.productID "
                        + "Where orderID like '" + orderID + "'";

                stm = con.prepareStatement(sql);
                //stm.setString(1, orderID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    String nameProduct = rs.getString("productName");
                    OrderDetailDTO orderDetails = new OrderDetailDTO(orderID, productID, nameProduct, quantity, price);
                    listDetailsDTO.add(orderDetails);

                }
            }
        } finally {
            closeDB();
        }
        return listDetailsDTO;
    }

   
}
