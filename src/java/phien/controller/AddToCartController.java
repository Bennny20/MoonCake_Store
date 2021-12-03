
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phien.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phientq.dto.ProductDTO;
import phientq.utils.ProductUtils;

/**
 *
 * @author phien
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

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
        try {
        HttpSession session = request.getSession();
        ProductUtils util = new ProductUtils();
        String prodcutID = request.getParameter("productID");
        String name = request.getParameter("nameProduct");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = 1;
        List<ProductDTO> listProduct = null;
        String mess = "";     
            if (session.getAttribute("CARTITEM") == null) {
                listProduct = new ArrayList<>();
            } else {
                listProduct = (List<ProductDTO>) session.getAttribute("CARTITEM");
            }
            if (util.checkExistInList(listProduct, prodcutID)) {
                int oldQuantity = util.getProQuantity(listProduct, prodcutID);
                quantity += oldQuantity;
                util.updateProQuantity(listProduct, prodcutID, quantity);
                mess = "Add success";
                url = "LoadProduct";
            } else {
                ProductDTO productDTO = new ProductDTO(prodcutID, name, price, quantity);
                listProduct.add(productDTO);
                mess = "Add success";
                url = "LoadProduct";
            }
            float total = util.totalPriceProduct(listProduct);
            session.setAttribute("CARTITEM", listProduct);
            session.setAttribute("TOTAL", total);
            session.setAttribute("ADDTOCART_MESS", mess);
        } catch (Exception e) {
            log("AddToCartController: " + e.getMessage());
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
