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
import phientq.dto.CategoryDTO;
import phientq.dto.ProductDTO;
import phientq.utils.DBUtils;

/**
 *
 * @author phien
 */
public class CategoryDAO implements Serializable {

    List<CategoryDTO> list = new ArrayList<>();

    public List<CategoryDTO> listCategory() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT categoryID, categoryName FROM Categories";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new CategoryDTO(rs.getString(1),
                            rs.getString(2)));
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
    
    public CategoryDTO getCategoryByID(String categoryID) throws SQLException, ClassNotFoundException{
        if (list.size()==0) listCategory();
        for (int i=0; i<list.size(); i++){
            if(list.get(i).getCategoryID().equals(categoryID)){
                return list.get(i);
            }
        }
        return null;
    }

}
