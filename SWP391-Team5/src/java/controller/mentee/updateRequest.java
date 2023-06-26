/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import controller.CreateRequest.requestMentor;
import dao.requestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import model.Request;
import model.Skill;
import model.User;

/**
 *
 * @author damtu
 */
@WebServlet(name = "updateRequest", urlPatterns = {"/updateRequest"})
public class updateRequest extends HttpServlet {

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
            String errE = (String) request.getAttribute("errE");
            if (errE != null) {
                // Đẩy giá trị "errE" lên JSP
                request.setAttribute("errE", errE);
                System.out.println(errE);
            }
            User sessionUser = (User) session.getAttribute("acc");
            String sessionUser_id = sessionUser.getUser_id();
            String request_id = "6";
            requestDAO dao = new requestDAO();
            //list request theo id
            List<Request> list = dao.listbyRequest_ID(request_id);
            //list skill menter of request
//             String id_mentor = request.getParameter("mentor_id");
            String id_mentor = "2";
            List<Skill> list_a = dao.getAllskillBySkill_id(Integer.parseInt(id_mentor));
            request.setAttribute("list_request", list);
            request.setAttribute("list_Skill", list_a);
            request.getRequestDispatcher("/mentee/updateRequest.jsp").forward(request, response);
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
        // lấy id của mentee
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("acc");
        String sessionUser_id = sessionUser.getUser_id();

        //lấy mail của mentee  
        String mail = sessionUser.getEmail();
        String name = sessionUser.getFull_name();
        //lấy id mentor
        // trước hết cứ mặc định là 2
        int id_mentor = 2;
        String tieude = request.getParameter("tieude");
        String batdau = request.getParameter("batdau");
        String ketthuc = request.getParameter("ketthuc");
        String sogiohoc = request.getParameter("sogiohoc");
        String noidung = request.getParameter("noidung");
        String[] skills = request.getParameterValues("skills");
        String framework = request.getParameter("framework");
        request.setAttribute("skills", skills);
        //********************************************************
        requestMentor rq = new requestMentor();
        Timestamp batdau1 = rq.convertToTimestamp(batdau);
        System.out.println(batdau);
        System.out.println(ketthuc);
        Timestamp ketthuc1 = rq.convertToTimestamp(ketthuc);
        //***********************************************************************
        long khoangCach = ketthuc1.getTime() - batdau1.getTime();
        long soGioHoc1 = Long.parseLong(sogiohoc) * 3600000; // Chuyển số giờ học thành mili giây
        boolean result = false;
        if (khoangCach < soGioHoc1) {
            System.out.println("Lỗi: Thời gian bắt đầu và kết thúc phải lớn hơn hoạc bằng với số giờ học");
            request.setAttribute("errE", "Lỗi: Thời gian bắt đầu và kết thúc phải lớn hơn hoạc bằng với số giờ học");
            processRequest(request, response);
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
