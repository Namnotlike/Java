/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.taikhoan;

import dao.NhomTaiKhoanDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;

/**
 *
 * @author TTC
 */
@WebServlet(name = "EditTK", urlPatterns = {"/admin/editTK"})
public class EditTK extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    TaiKhoanDAO tkDao = new TaiKhoanDAO();
    NhomTaiKhoanDAO ntkDao = new NhomTaiKhoanDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TaiKhoan tk = tkDao.details(request.getParameter("tentk"));
        request.setAttribute("tk", tk);
        request.getRequestDispatcher("/view/admin/taikhoan/edit.jsp").forward(request, response);
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
        String tentk = request.getParameter("tentk");
        String email = request.getParameter("email");
        String nhomtk = request.getParameter("nhomtk");
        boolean trangthai = Boolean.parseBoolean(request.getParameter("trangthai"));
        boolean back = false;
        if (ntkDao.details(nhomtk) == null) {
            request.setAttribute("errorNhomtk", "Hãy nhập AD cho Admin, US cho User hoặc SP cho Support");
            back = true;
        }

        if (back) {
            request.setAttribute("tk", tkDao.details(tentk));
            request.getRequestDispatcher("/view/admin/taikhoan/edit.jsp").forward(request, response);
        }
        else{
            TaiKhoan ncc = new TaiKhoan(tentk, tkDao.details(tentk).getMatkhau(), trangthai, email, ntkDao.details(nhomtk));
            tkDao.update(ncc);
            response.sendRedirect("indexTK");
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
