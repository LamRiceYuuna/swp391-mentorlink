/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.home;

import dao.MentorCVDAO;
import dao.SkillDAO;
import dao.requestDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.CV_Mentor;
import model.MentorRatingStats;
import model.MentorRequest;
import model.MentorRequestStats;
import model.Skill;
import model.User;

/**
 *
 * @author Tuan Vinh
 */
public class HomePage extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Get data top mentor 
        MentorCVDAO cv = new MentorCVDAO();
        List<CV_Mentor> listT = cv.getTopListMentor();
        request.setAttribute("listT", listT);
        //Get data top skill
        SkillDAO sk = new SkillDAO();
        List<Skill> listS = sk.getTop3Skill();
        request.setAttribute("listS", listS);
        //Getdata request static
        try{
        HttpSession session = request.getSession();
        User abc = (User) session.getAttribute("acc");
        int user_id = Integer.parseInt(abc.getUser_id());
        requestDAO rq = new requestDAO();
        MentorRequestStats mrs = rq.getStatisticByMentorId(user_id);
        List<MentorRequest> listR = rq.getListRequestByMentorId(user_id);
        int topRank = rq.getTopRateAVGStarByMentorId(user_id);
        List<MentorRatingStats> listRS = rq.getListTopRankStar();
        request.setAttribute("object", mrs);
        request.setAttribute("listR", listR);
        request.setAttribute("top", topRank);
        request.setAttribute("listRS", listRS);
        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        
        request.getRequestDispatcher("home/home.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
