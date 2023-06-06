/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CartItemDao;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.SanPham;

/**
 *
 * @author TTC
 */
@WebServlet(name = "Order", urlPatterns = {"/order"})
public class Order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    SanPhamDAO spDao = new SanPhamDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPham p = spDao.details(request.getParameter("masp"));
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("giohang") == null) {
            CartItemDao myCard = new CartItemDao();
            CartItem item = new CartItem();
            
            if (p.getSoluong() > 0) {
                item.setSp(p);
                item.setAmount(1);
                myCard.getList().add(item);
                session.setAttribute("giohang", myCard);
            } else {
                out.print("San pham da het hang");
            }

        } else {
            int i = 0;
            CartItemDao myCard = (CartItemDao) session.getAttribute("giohang");
            for (CartItem item : myCard.getList()) {
                if (item.getSp().getMasp().trim().equals(request.getParameter("masp").trim())) {
                    if (p.getSoluong() > item.getAmount()) {
                        item.setAmount(item.getAmount() + 1);

                    } else {
                        out.write("Khong du so luong");
                    }
                    i = 1;
                }
            }
            if (i == 0) {
                CartItem item = new CartItem();
                

                if (p.getSoluong() > 0) {
                    item.setSp(p);
                    item.setAmount(1);
                    myCard.getList().add(item);
                }
                
            }

            session.setAttribute("giohang", myCard);
        }
        response.sendRedirect("index");
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
        request.getRequestDispatcher("/view/home/order.jsp").forward(request, response);
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
