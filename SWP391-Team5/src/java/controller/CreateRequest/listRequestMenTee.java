/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.CreateRequest;

import dao.requestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Request;
import model.Skill;
import model.User;

/**
 *
 * @author damtu
 */
public class listRequestMenTee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User sessionUser = (User) session.getAttribute("acc");
            String sessionUser_id = sessionUser.getUser_id();
            requestDAO dao = new requestDAO();

            List<Request> list = dao.listRequestByID(sessionUser_id);
            Date currentTime = new Date(); // Lấy thời gian hiện tại
       
            for (Request request1 : list) {
                if(request1.getRequest_status()==1){
                Timestamp timeBeginString = request1.getTime_begin(); // Lấy giá trị time_begin từ cơ sở dữ liệu

                if (timeBeginString.before(currentTime)) {
                    // time_begin xảy ra trước thời gian hiện tại, set request_status = 1
                    request1.setRequest_status(3);
                } else if (timeBeginString.after(currentTime)) {
                    // time_begin xảy ra sau thời gian hiện tại, set request_status = 3
                    request1.setRequest_status(1);
                }}
            }

    // Cập nhật request_status trong cơ sở dữ liệu
            for (Request request1 : list) {
                
                dao.update(request1.getRequest_status(),request1.getRequest_id());
            }

            request.setAttribute("lista", list);
            request.getRequestDispatcher("/mentee/ListRequestByMe.jsp").forward(request, response);

        }
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
        
        processRequest(request, response);
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
