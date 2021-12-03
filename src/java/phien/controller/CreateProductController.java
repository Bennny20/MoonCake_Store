/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phien.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {

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
        String id = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        float price = Float.parseFloat(request.getParameter("txtPrice"));
        int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        String Nsx = request.getParameter("txtCreateDate");
        String Hsd = request.getParameter("txtHSD");
        String image = request.getParameter("txtImage");
        String Des = request.getParameter("txtDescription");
        boolean status = Boolean.parseBoolean(request.getParameter("txtStatus"));
        String category = request.getParameter("category");
        ProductDAO dao = new ProductDAO();
        boolean check = true;
        boolean foundErr = false;
        ProductErr error = new ProductErr();
        String url = "ManagerProduct";
        try {
            
            ProductDTO product = new ProductDTO(id, name, price, quantity, Hsd, Hsd, image, status, Des, category);
            check = dao.insertProduct(product);
            if (check) {
                url="LoadProduct";
            }
        } catch (SQLException ex) {            
            String msg = ex.getMessage();
            log("CreateProductController_SQL: " + ex.getMessage());
            if (msg.contains("duplicate")) {
                error.setProductIDIsExiste(id + " is existed.");
                request.setAttribute("SIGNUP_ERRS", error);
            }
        } catch (ClassNotFoundException ex) {
            log("CreateProductController_ClassNotFound: " + ex.getMessage());
        }finally{
             RequestDispatcher rd = request.getRequestDispatcher(url);
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

    private Date Date(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
