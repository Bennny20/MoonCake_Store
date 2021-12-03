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
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

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
        String txtSearch = request.getParameter("txtSearch");
        String pFrom = request.getParameter("txtFrom");
        String pTo = request.getParameter("txtTo");
        ProductDAO dao = new ProductDAO();
        CategoryDAO DaoCategory = new CategoryDAO();
        String action = request.getParameter("btAction");
        try {
            if (action.equals("search")) {
                List<CategoryDTO> listCate = DaoCategory.listCategory();
                List<ProductDTO> list = dao.getProductByName(txtSearch);
                request.setAttribute("LIST_PRODUCT", list);
                request.setAttribute("LIST_CATEGORY", listCate);
            } else if (action.equals("price")) {
                float from = Float.parseFloat(pFrom);
                float to = Float.parseFloat(pTo);
                List<CategoryDTO> listCate = DaoCategory.listCategory();
                request.setAttribute("LIST_CATEGORY", listCate);
                List<ProductDTO> listPro = dao.searchPrice(from, to);
                request.setAttribute("LIST_PRODUCT", listPro);
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
