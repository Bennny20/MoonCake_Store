/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phien.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phientq.dao.ProductDAO;
import phientq.dto.ProductDTO;
import phientq.dto.ProductErr;

/**
 *
 * @author phien
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String ProductID = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        float price = Float.parseFloat(request.getParameter("txtPrice"));
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        String Nsx = request.getParameter("txtCreateDate");
        String Hsd = request.getParameter("txtHSD");
        String image = request.getParameter("txtImage");
        String Des = request.getParameter("txtDescription");
        boolean status = Boolean.parseBoolean(request.getParameter("txtStatus"));
        String category = request.getParameter("category");

        boolean check = true;
        boolean foundErr = false;
        ProductErr error = new ProductErr();
        ProductDAO dao = new ProductDAO();
        try {
            //check ID
//            if (ProductID.trim().length() < 2 || ProductID.trim().length() > 10) {
//                foundErr = true;
//                error.setProductIDLengthViolent("Tên sản phẩm phải từ 2 đén 10 kí tự (P01)");
//            }
            //check name
            if (name.trim().length() < 6 || name.trim().length() > 50) {
                foundErr = true;
                error.setProductNameLengthViolent("Tên sản phẩm phải từ 6 đén 50 kí tự");
            }
            //check price
            if (price <= 0) {
                foundErr = true;
                error.setPriceLengthViolent("Giá tiền không được âm.");
            }
            //check quantity
            if (quantity < 0) {
                foundErr = true;
                error.setPriceLengthViolent("Số lượng không được âm.");
            }
            //check NSX
            if (Nsx.trim().length() < 8 || Nsx.trim().length() > 11) {
                foundErr = true;
                error.setCreateDateLengthViolent("Ngày sản xuất follow (YYYY/MM/DD)");
            }
            //check HSD
            if (Hsd.trim().length() < 8 || Hsd.trim().length() > 11) {
                foundErr = true;
                error.setExpirationDateLengthViolent("Hạn xử dụng follow (YYYY/MM/DD)");
            }
            //check image
            if (name.trim().length() < 5 || name.trim().length() > 100) {
                foundErr = true;
                error.setImageLengthViolent("Ảnh sản phẩm phải từ 5 đén 100 kí tự");
            }
            //check status
            if (Des.trim().length() < 5 || Des.trim().length() > 100) {
                foundErr = false;
                error.setShortDescriptionLengthViolent("Mô tả sản phẩm phải từ 5 đén 100 kí tự");
            }
            //check status
            if (category.trim().length() < 2 || category.trim().length() > 30) {
                foundErr = true;
                error.setShortDescriptionLengthViolent("Loại sản phẩm phải từ 2 đén 30 kí tự");
            }

            if (foundErr) {
                request.setAttribute("ERRORS", error);
                return;
            } else {
                if (check) {
                    ProductDTO product = new ProductDTO(ProductID, name, price, quantity, Hsd, Hsd, image, status, Des, category);
                    check = dao.updateProduct(product);
                }
            }
        } catch (SQLException ex) {
            log("UpdateController SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("UpdateController_ClassNotFound: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("ManagerProduct");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
