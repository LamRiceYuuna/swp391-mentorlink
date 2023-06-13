/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.common;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Tuan Vinh
 */
public class UserProfile extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserProfile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProfile at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        
//        HttpSession session = request.getSession();
//        User u = (User)session.getAttribute("acc");
//        String idS_raw = (String)u.getUser_id();
//        int idSI = Integer.parseInt(idS_raw);
        int idSI = 2;
        User userIf = dao.getUserById(idSI);
        if (userIf == null) {
            request.setAttribute("mess", "Error");
        } else {
            request.setAttribute("InfoUser", userIf);
        }
        request.getRequestDispatcher("/common/userProfile.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String full_name = request.getParameter("full_name");
        int gender = "Male".equals(request.getParameter("gender")) ? 1 : 0;
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        UserDAO dao = new UserDAO();
        boolean insertSuccess = dao.UpdateUser(gender ,full_name, birthdate, email, address, phone, 2);
         if (insertSuccess == true) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failure");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
