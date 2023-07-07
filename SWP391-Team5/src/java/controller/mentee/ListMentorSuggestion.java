/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import dao.MentorCVDAO;
import dao.requestSkillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.CV_Mentor;
import model.Request_Skill;
import model.User;

/**
 *
 * @author Tuan Vinh
 */
public class ListMentorSuggestion extends HttpServlet {

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
        HttpSession session = request.getSession();
        // Lấy thông tin người dùng từ session lưu trữ trong thuộc tính có tên "acc"
        User sessionUser = (User) session.getAttribute("acc");
        // Lấy user_id từ đối tượng User lấy từ session
        String sessionUser_id = sessionUser.getUser_id();
        int mentee_id = Integer.parseInt(sessionUser_id);
        //Khoi tao cac doi tuong tuong ung
        MentorCVDAO dao = new MentorCVDAO();
        requestSkillDAO obj = new requestSkillDAO();
        //Lay thong tin ve ki nang ma mentee da request truoc do
        Request_Skill requestSkill = obj.getRequestSkillID(mentee_id);
        //Lay ra ki nang
        ArrayList<Integer> skillIds = requestSkill.getItg();
        //Ham list ra cac mentor phu hop voi ki nang ma mentee da yeu cau
        ArrayList<CV_Mentor> list = dao.listMentorSuggestion(skillIds);
        request.setAttribute("listS", list);
        request.getRequestDispatcher("common/listMentorSuggestion.jsp").forward(request, response);
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
        //Loai sap xep ma nguoi dung chon ben jsp
        String typeSort = request.getParameter("sort");
        HttpSession session = request.getSession();
        // Lấy thông tin người dùng từ session lưu trữ trong thuộc tính có tên "acc"
        User sessionUser = (User) session.getAttribute("acc");
        // Lấy user_id từ đối tượng User lấy từ session
        String sessionUser_id = sessionUser.getUser_id();
        int mentee_id = Integer.parseInt(sessionUser_id);

        MentorCVDAO dao = new MentorCVDAO();
        requestSkillDAO obj = new requestSkillDAO();
        //Lay thong tin ve ki nang ma mentee da request truoc do
        Request_Skill requestSkill = obj.getRequestSkillID(mentee_id);
        ArrayList<Integer> skillIds = requestSkill.getItg();

        //Kiem tra loai sap xep ma nguoi dung chon va goi den ham xu li sap xep
        if (typeSort.equals("default")) {
            ArrayList<CV_Mentor> list = dao.listMentorSuggestion(skillIds);
            request.setAttribute("listS", list);
        } else {         
            ArrayList<CV_Mentor> list = dao.listMentorSuggestionSort(skillIds, typeSort);
            request.setAttribute("listS", list);
        }         

        request.getRequestDispatcher("common/listMentorSuggestion.jsp").forward(request, response);
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
