/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.hoadon;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HoaDon;

/**
 *
 * @author TTC
 */
@WebServlet(name = "EditHD", urlPatterns = {"/admin/editHD"})
public class EditHD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HoaDonDAO hdDao = new HoaDonDAO();
    TaiKhoanDAO tkDao = new TaiKhoanDAO();
    ChiTietHoaDonDAO cthdDao = new ChiTietHoaDonDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HoaDon hd = hdDao.details(request.getParameter("mahd"));
        request.setAttribute("hd", hd);
        request.getRequestDispatcher("/view/admin/hoadon/edit.jsp").forward(request, response);

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
        String mahd = request.getParameter("mahd");
        Date ngaydh = Date.valueOf(request.getParameter("ngaydh"));
        int trangthaixuli = Integer.parseInt(request.getParameter("trangthaixuli"));
        String makh = request.getParameter("makh");
        boolean back = false;
        if (tkDao.details(makh) == null) {
            request.setAttribute("errorMakh", "Mã khách hàng không tồn tại");
            back = true;
        }

        if (back) {
            request.setAttribute("hd", hdDao.details(mahd));
            request.getRequestDispatcher("/view/admin/hoadon/edit.jsp").forward(request, response);
        }
        else{
            HoaDon hd = new HoaDon(mahd, ngaydh, trangthaixuli, tkDao.details(makh));
            hdDao.update(hd);
            response.sendRedirect("indexHD");
        }
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
