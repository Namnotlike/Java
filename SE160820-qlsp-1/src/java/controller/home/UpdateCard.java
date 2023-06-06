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
@WebServlet(name = "UpdateCard", urlPatterns = {"/updateCard"})
public class UpdateCard extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String masp = request.getParameter("masp");
        String n = request.getParameter("newAmount");
        int newAmount = Integer.parseInt(request.getParameter("newAmount"));
        SanPham sp = spDao.details(masp);
        HttpSession session = request.getSession();
        CartItemDao giohang = (CartItemDao) session.getAttribute("giohang");
        if (giohang == null) {
            PrintWriter out = response.getWriter();
            out.print("<h1>Bạn chưa add gì vào giỏ hàng cả</h1>");
        } else {
            for (int i = 0; i < giohang.getList().size(); i++) {
                if (giohang.getList().get(i).getSp().getMasp().equals(masp)) {
                    if (newAmount <= 0) {
                        request.setAttribute("errorUpdateCard", "So luong phai lon hon 0");
                        request.getRequestDispatcher("/view/home/order.jsp").forward(request, response);
                    } else if (sp.getSoluong() >= newAmount) {
                        giohang.getList().get(i).setAmount(newAmount);
                        session.setAttribute("giohang", giohang);
                        request.getRequestDispatcher("/view/home/order.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errorUpdateCard", "So luong trong kho khong du");
                        request.getRequestDispatcher("/view/home/order.jsp").forward(request, response);
                    }
                }
            }
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
