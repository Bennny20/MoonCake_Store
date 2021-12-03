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
import phientq.dao.CategoryDAO;
import phientq.dao.ProductDAO;
import phientq.dto.CategoryDTO;
import phientq.dto.ProductDTO;

/**
 *
 * @author phien
 */
@WebServlet(name = "LoadProduct", urlPatterns = {"/LoadProduct"})
public class LoadProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String homepage = "Home.jsp";
        String loginpage = "Login.jsp";

        String action = request.getParameter("action");
        ProductDAO daoProduct = new ProductDAO();
        CategoryDAO DaoCategory = new CategoryDAO();
        List<CategoryDTO> listCate;
        List<ProductDTO> listPro;
        try {
            if (action == null) {
                listPro = daoProduct.listProduct();
                request.setAttribute("LIST_PRODUCT", listPro);
                listCate = DaoCategory.listCategory();
                request.setAttribute("LIST_CATEGORY", listCate);
            } else if (action.equals("showCategory")) {
                String categoryID = request.getParameter("categoryID");
                listPro = daoProduct.getProductByCategory(categoryID);
                listCate = DaoCategory.listCategory();
                String catogpryName = DaoCategory.getCategoryByID(categoryID).getCategoryName();
                request.setAttribute("categoryName", catogpryName);
                request.setAttribute("LIST_PRODUCT", listPro);
                request.setAttribute("LIST_CATEGORY", listCate);
            } 

        } catch (SQLException ex) {
            log("LoadListServlet_SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("LoadListServlet_ClassNotFound: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
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
