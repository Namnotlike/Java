/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import dao.NhaCungCapDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NhaCungCap;

/**
 *
 * @author TTC
 */
@WebServlet(name = "CreateNCC", urlPatterns = {"/admin/createNCC"})
public class CreateNCC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    NhaCungCapDAO nccDao = new NhaCungCapDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/nhacungcap/create.jsp").forward(request, response);
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
        String mancc = request.getParameter("mancc");
        String tenncc = request.getParameter("tenncc");
        String diachi = request.getParameter("diachi");
        boolean back = false;
        if (nccDao.details(mancc) != null) {
            request.setAttribute("errorMancc", "Mã nhà cung cấp đã tồn tại");
            back = true;
        }
        if (nccDao.checkMancc(mancc) != "") {
            request.setAttribute("errorMancc", nccDao.checkMancc(mancc));
            back = true;
        }
        if (tenncc.length() < 5) {
            request.setAttribute("errorTenncc", "Tên nhà cung cấp phải có ít nhất 5 kí tự");
            back = true;
        }

        if (back) {
            request.getRequestDispatcher("/view/admin/nhacungcap/create.jsp").forward(request, response);
        }
        else{
            NhaCungCap ncc = new NhaCungCap(mancc, tenncc, diachi, true);
            nccDao.create(ncc);
            response.sendRedirect("indexNCC");
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
