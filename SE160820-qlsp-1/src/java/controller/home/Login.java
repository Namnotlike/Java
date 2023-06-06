/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author TTC
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/home/login.jsp").forward(request, response);
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
        TaiKhoan taikhoan = tkDao.details(tentk);
        HttpSession session = request.getSession();
        if (taikhoan == null) {
            PrintWriter out = response.getWriter();
            out.print("<h1>tai khoan hoac mat khau sai</h1>");
            out.print("<a href=\"login\"><button>Vui long dang nhap lai</button></a>");
        }
        else if (taikhoan.getMatkhau().equals(matkhau)) {
            session.setAttribute("taikhoan", taikhoan);
            String role = taikhoan.getNhomtk().getNhomtk();
            String role1 = taikhoan.getNhomtk().getNhomtk();
            if (!role.equals("AD")) {
                role = null;
            }
            session.setAttribute("role", role);
            session.setAttribute("role1", role1);
            response.sendRedirect("index");
        }else{
            PrintWriter out = response.getWriter();
            out.print("<h1>tai khoan hoac mat khau sai</h1>");
            out.print("<a href=\"login\"><button>Vui long dang nhap lai</button></a>");
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
