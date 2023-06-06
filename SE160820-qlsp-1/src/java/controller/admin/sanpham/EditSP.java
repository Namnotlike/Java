/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.sanpham;

import dao.DanhMucDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author TTC
 */
@WebServlet(name = "EditSP", urlPatterns = {"/admin/editSP"})
public class EditSP extends HttpServlet {

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
    DanhMucDAO dmDao = new DanhMucDAO();
    NhaCungCapDAO nccDao = new NhaCungCapDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("masp");
        SanPham sp = spDao.details(masp);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/view/admin/sanpham/edit.jsp").forward(request, response);
        
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
        String masp = request.getParameter("masp");
        String tensp = request.getParameter("tensp");
        String mota = request.getParameter("mota");
        int soluong;
        if (request.getParameter("soluong").isEmpty()) {
            soluong = 0;
        } else {
            soluong = Integer.parseInt(request.getParameter("soluong"));
        }
        float dongia;
        if (request.getParameter("dongia").isEmpty()) {
            dongia = 0;
        } else {
            dongia = Float.parseFloat(request.getParameter("dongia"));
        }
        String hinhanh = request.getParameter("hinhanh");
        boolean trangthai = Boolean.parseBoolean(request.getParameter("trangthai"));
        String madm = request.getParameter("madm");
        String mancc = request.getParameter("mancc");
        boolean back = false;
        if (tensp.length() < 5) {
            request.setAttribute("errorTensp", "Tên sản phẩm phải có ít nhất 5 kí tự");
            back = true;
        }
        if (dmDao.details(madm) == null) {
            request.setAttribute("errorMadm", "Mã danh mục không tồn tại");
            back = true;
        }
        if (nccDao.details(mancc) == null) {
            request.setAttribute("errorMancc", "Mã nhà cung cấp không tồn tại");
            back = true;
        }

        if (back) {
            request.setAttribute("sp", spDao.details(masp));
            request.getRequestDispatcher("/view/admin/sanpham/edit.jsp").forward(request, response);
        }
        if (!back) {
            SanPham sp = new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, dmDao.details(madm), nccDao.details(mancc));
            spDao.update(sp);
            response.sendRedirect("indexSP");
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
