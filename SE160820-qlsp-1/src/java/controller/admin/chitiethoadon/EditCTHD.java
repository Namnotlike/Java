/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.chitiethoadon;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ChiTietHoaDon;

/**
 *
 * @author TTC
 */
@WebServlet(name = "EditCTHD", urlPatterns = {"/admin/editCTHD"})
public class EditCTHD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ChiTietHoaDonDAO cthdDao = new ChiTietHoaDonDAO();
    HoaDonDAO hdDao = new HoaDonDAO();
    SanPhamDAO spDao = new SanPhamDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ChiTietHoaDon cthd = cthdDao.details(request.getParameter("mahd"), request.getParameter("masp"));
        request.setAttribute("cthd", cthd);
        request.getRequestDispatcher("/view/admin/chitiethoadon/edit.jsp").forward(request, response);
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
        String masp = request.getParameter("masp");
        String masp1 = request.getParameter("masp1");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        float dongia = Float.parseFloat(request.getParameter("dongia"));
        float khuyenmai = Float.parseFloat(request.getParameter("khuyenmai"));
        boolean back = false;
        if (spDao.details(masp) == null) {
            request.setAttribute("errorMasp", "Mã sản phẩm không tồn tại");
            back = true;
        } 
        List<ChiTietHoaDon> list= cthdDao.details1(mahd);
        for (ChiTietHoaDon cthd : list) {
            if (cthd.getMasp().getMasp().equals(masp) && !masp.equals(masp1)) {
            request.setAttribute("errorMasp", "Mã sản phẩm đã tồn tại trong chi tiết hóa đơn");
            back = true;
            break;
        }
        }
        if (cthdDao.details(mahd) == null) {
            request.setAttribute("errorMasp", "Mã sản phẩm không tồn tại");
            back = true;
        }
        if (khuyenmai <0 || khuyenmai >100) {
            request.setAttribute("errorKhuyenmai", "Khuyến mại chỉ từ 0% đến 100%");
            back = true;
        }
        if (back) {
            request.setAttribute("cthd", cthdDao.details(mahd, masp1));
            request.getRequestDispatcher("/view/admin/chitiethoadon/edit.jsp").forward(request, response);
        }
        else{
            ChiTietHoaDon cthd = new ChiTietHoaDon(hdDao.details(mahd), spDao.details(masp), 
                    soluong, dongia, khuyenmai, soluong*dongia*(1-(khuyenmai/100)));
            cthdDao.delete(mahd, masp1);
            cthdDao.create(cthd);
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
