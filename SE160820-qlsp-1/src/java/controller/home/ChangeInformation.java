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
@WebServlet(name = "ChangeInformation", urlPatterns = {"/changeInformation"})
public class ChangeInformation extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
//        if (session.getAttribute("taikhoan") == null) {
//            response.sendRedirect("login");
//        } else {
            request.setAttribute("taikhoan", (TaiKhoan) session.getAttribute("taikhoan"));
            request.getRequestDispatcher("/view/home/changeInformation.jsp").forward(request, response);
//        }
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
        if (matkhau.length() < 3) {
            request.setAttribute("taikhoan", taikhoan);
            request.setAttribute("errorMk", "Mật khẩu không đủ độ dài");
            request.getRequestDispatcher("/view/home/changeInformation.jsp").forward(request, response);
        } else if (matkhau.equals(matkhauxn)) {
            taikhoan = new TaiKhoan(tentk, matkhau, taikhoan.isTrangthai(), email, taikhoan.getNhomtk());
            tkDao.update(taikhoan);
            session.setAttribute("taikhoan", taikhoan);
            response.sendRedirect("logout");
        } else {
            request.setAttribute("taikhoan", taikhoan);
            request.setAttribute("errorMk", "Mật khẩu không giống nhau");
            request.getRequestDispatcher("/view/home/changeInformation.jsp").forward(request, response);
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
