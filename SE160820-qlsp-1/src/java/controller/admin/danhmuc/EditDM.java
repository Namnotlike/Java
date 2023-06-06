/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.danhmuc;

import dao.DanhMucDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;

/**
 *
 * @author TTC
 */
@WebServlet(name = "EditDM", urlPatterns = {"/admin/editDM"})
public class EditDM extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DanhMucDAO dmDao = new DanhMucDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DanhMuc dm = dmDao.details(request.getParameter("madm"));
        request.setAttribute("dm", dm);
        request.getRequestDispatcher("/view/admin/danhmuc/edit.jsp").forward(request, response);
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
        String madm = request.getParameter("madm");
        String tendm = request.getParameter("tendm");
        boolean trangthai = Boolean.parseBoolean(request.getParameter("trangthai"));
        boolean back = false;
        if (tendm.length() < 5) {
            request.setAttribute("errorTendm", "Tên danh mục phải có ít nhất 5 kí tự");
            back = true;
        }
        if (back) {
            request.setAttribute("dm", dmDao.details(madm));
            request.getRequestDispatcher("/view/admin/danhmuc/edit.jsp").forward(request, response);
        } else {
            DanhMuc dm = new DanhMuc(madm, tendm, trangthai);
            dmDao.update(dm);
            response.sendRedirect("indexDM");
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
