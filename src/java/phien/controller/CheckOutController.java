/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phien.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phientq.dao.OrderDAO;
import phientq.dao.OrderDetailDAO;
import phientq.dao.ProductDAO;
import phientq.dto.OrderDTO;
import phientq.dto.OrderDetailDTO;
import phientq.dto.ProductDTO;
import phientq.dto.UserDTO;
import phientq.utils.ProductUtils;

/**
 *
 * @author phien
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOut"})
public class CheckOutController extends HttpServlet {

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
        String url = "LoadProduct";
        ProductUtils utils = new ProductUtils();
        HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO detailDAO = new OrderDetailDAO();
        try {
            List<ProductDTO> list = (List<ProductDTO>) session.getAttribute("CARTITEM");
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user == null) {
                url = "GiveInfomation.jsp";
            } else {
                String orderID = utils.getAutoNumber(5);
                if (orderDAO.checkOrderIdIsExist(orderID)) {
                    orderID = utils.getAutoNumber(6);
                }
                float total = (float) session.getAttribute("TOTAL");
                OrderDTO order = new OrderDTO(orderID,
                        user.getUserName(),
                        user.getPhone(),
                        user.getEmail(),
                        user.getAddress(),
                        "", total,
                        user.getUserID());

                if (orderDAO.saveOrderForLogin(order)) {
                    for (int i = 0; i < list.size(); i++) {
                        OrderDetailDTO od = new OrderDetailDTO(orderID,
                                list.get(i).getProductID(),
                                list.get(i).getPrice(),
                                list.get(i).getQuantity());
                        if (detailDAO.saveOrderDetail(od)) {
                            int newQuantity = list.get(i).getQuantity();
                            int oldQuantity = dao.checkQuantity(list.get(i).getProductID());
                            int totalQuantity = oldQuantity - newQuantity;
                            dao.updateProductQuantity(list.get(i).getProductID(), totalQuantity);
                        }
                    }

                    url = "LoadProduct";
                    session.setAttribute("CARTITEM", null);
                } else {
                    url = "Cart.jsp";
                }
            }
        } catch (SQLException ex) {
            log("CheckOutController SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("CheckOutController ClassNotFound: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
