/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.CartItemDao;
import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author TTC
 */
@WebServlet(name = "Payment", urlPatterns = {"/payment"})
public class Payment extends HttpServlet {

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
    HoaDonDAO hdDao = new HoaDonDAO();
    ChiTietHoaDonDAO cthdDao = new ChiTietHoaDonDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartItemDao listSP = (CartItemDao) session.getAttribute("giohang");
        long millis= System.currentTimeMillis();
        Date d = new Date(millis);
        
        HoaDon hd =new HoaDon(hdDao.randomMahd(), d, 1, (TaiKhoan)session.getAttribute("taikhoan"));
        hdDao.create(hd);
        for (CartItem cart : listSP.getList()) {
            SanPham sp = spDao.details(cart.getSp().getMasp());
            sp.setSoluong(sp.getSoluong() - cart.getAmount());
            spDao.update(sp);
            cthdDao.create(new ChiTietHoaDon(hd, cart.getSp(), cart.getAmount()
                    , cart.getSp().getDongia(), 0, cart.getAmount()*cart.getSp().getDongia()*(1-0)));
        }
        
        
        session.removeAttribute("giohang");
        request.setAttribute("thanhcong", "1");
        request.getRequestDispatcher("/view/home/order.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
//        if (session.getAttribute("taikhoan") == null) {
//            response.sendRedirect("login");
//        } else {
            request.getRequestDispatcher("/view/home/payment.jsp").forward(request, response);
//        }
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
