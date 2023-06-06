/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.NhomTaiKhoanDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.NhomTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author TTC
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

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
        request.getRequestDispatcher("/view/home/register.jsp").forward(request, response);

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
        String matkhau = request.getParameter("matkhau");
        String matkhauxn = request.getParameter("matkhauxn");
        String email = request.getParameter("email");
        TaiKhoan taikhoan = tkDao.details(tentk);
        HttpSession session = request.getSession();
        if (taikhoan != null) {
            request.setAttribute("errorTk", "Tài khoản đã tồn tại");
            request.getRequestDispatcher("/view/home/register.jsp").forward(request, response);
        }
        else if(matkhau.length()<10){
            request.setAttribute("errorMk", "Mật khẩu không đủ độ dài");
            request.getRequestDispatcher("/view/home/register.jsp").forward(request, response);
        }
        else if(matkhau.equals(matkhauxn)) {
            taikhoan = new TaiKhoan(tentk, matkhau, true, email, ntkDao.details("US"));
            tkDao.create(taikhoan);
            session.setAttribute("taikhoan", taikhoan);
            response.sendRedirect("index");
        } else {
            request.setAttribute("errorMk", "Mật khẩu không giống nhau");
            request.getRequestDispatcher("/view/home/register.jsp").forward(request, response);
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
