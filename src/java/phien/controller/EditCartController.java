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
import phientq.dao.ProductDAO;
import phientq.dto.ProductDTO;
import phientq.utils.ProductUtils;

/**
 *
 * @author phien
 */
@WebServlet(name = "EditCartController", urlPatterns = {"/EditCart"})
public class EditCartController extends HttpServlet {

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
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        String mess = "";
        ProductDAO productDAO = new ProductDAO();
        ProductUtils utils = new ProductUtils();
        String url = "Cart.jsp";
        try {
            if (action.equals("Update")) {
                String id = request.getParameter("txtID");
                int newQuantity = Integer.parseInt(request.getParameter("quantity"));
                List<ProductDTO> list = (List<ProductDTO>) session.getAttribute("CARTITEM");
                int oldQuantity = productDAO.checkQuantity(id);
                if (newQuantity > oldQuantity) {
                    mess = "The quantity not enough";
                } else {

                    if (utils.updateProduct(list, id, newQuantity)) {
                        mess = "Update success";
                    } else {
                        mess = "Update fail";
                    }
                }
                float total = utils.totalPriceProduct(list);
                session.setAttribute("TOTAL", total);
                request.setAttribute("UPDATE_MSG", mess);
                
            } else if (action.equals("Delete")) {
                url = "DeleteItemController";
            }
        } catch (SQLException ex) {
            log("Error At UpdateCartController SQL:" + ex.toString());
        } catch (ClassNotFoundException ex) {
            log("Error At UpdateCartController NOT FOUND:" + ex.toString());
        } catch (Exception e) {
            log("Error At UpdateCartController:" + e.toString());
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
