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
import phientq.dto.OrderDTO;
import phientq.utils.DBUtils;

/**
 *
 * @author phien
 */
public class OrderDAO implements Serializable {

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

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO orders(orderID, fullname, phone, email, address, dateOrder, total) "
                        + "VALUES (?, ?,?,? ,?,getdate(),?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, orderDTO.getOrderID());
                stm.setString(2, orderDTO.getFullname());
                stm.setString(3, orderDTO.getPhoneNumber());
                stm.setString(4, orderDTO.getEmail());
                stm.setString(5, orderDTO.getAddress());
                stm.setFloat(6, orderDTO.getTotal());

                check = stm.executeUpdate() > 0;
            }

        } finally {
            closeDB();
        }
        return check;
    }

    public boolean saveOrderForLogin(OrderDTO order) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO orders(orderID, fullname, phone, email, address, dateOrder, total, userID) "
                        + "VALUES (?,?,?,?,?,getdate(),?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getOrderID());
                stm.setString(2, order.getFullname());
                stm.setString(3, order.getPhoneNumber());
                stm.setString(4, order.getEmail());
                stm.setString(5, order.getAddress());
                stm.setFloat(6, order.getTotal());
                stm.setString(7, order.getUserID());
                check = stm.executeUpdate() > 0;
            }

        } finally {
            closeDB();
        }
        return check;
    }

    public int getOrderID(String userID) throws SQLException, ClassNotFoundException {
        int orderID = 0;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "select orderID "
                        + "from Orders "
                        + "where userID= ? and orderID =(select max(orderID) from Orders)";
            }
        } finally {
            closeDB();
        }
        return orderID;
    }

    public boolean checkOrderIdIsExist(String orderID) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "select orderID "
                        + "from Orders "
                        + "where orderID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            closeDB();
        }
        return false;
    }

    public List<OrderDTO> getListOrder(String userID) throws SQLException, ClassNotFoundException {
        List<OrderDTO> listOrder = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "Select orderID, fullname, phone, email, address, dateOrder,total "
                        + "from Orders "
                        + "Where userID like ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderID = rs.getString("orderID");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String dateOrder = rs.getString("dateOrder");
                    float total = rs.getFloat("total");
                    OrderDTO orderDTO = new OrderDTO(orderID, fullname, phone, email, address, dateOrder, total, userID);
                    listOrder.add(orderDTO);
                }
            }
        } finally {
            closeDB();
        }
        return listOrder;
    }

    public List<OrderDTO> getListOrderAdmin() throws SQLException, ClassNotFoundException {
        List<OrderDTO> listOrderAdmin = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "Select orderID, fullname, phone, email, address,dateOrder,total "
                        + "from Orders";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderID = rs.getString("orderID");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String dateOrder = rs.getString("dateOrder");
                    float total = rs.getFloat("total");
                    OrderDTO orderDTO = new OrderDTO(orderID, fullname, phone, email, address, dateOrder, total);
                    listOrderAdmin.add(orderDTO);
                }
            }
        } finally {
            closeDB();
        }
        return listOrderAdmin;
    }
}
