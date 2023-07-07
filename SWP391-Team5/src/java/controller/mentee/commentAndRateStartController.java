/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import dao.FeedbackDAO;
import dao.MentorCVDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.CV_Mentor;
import model.Feedback;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "commentAndRateStartController", urlPatterns = {"/commentAndRateStart"})
public class commentAndRateStartController extends HttpServlet {

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
        // Retrieve rating and opinion from the request
        int rating = Integer.parseInt(request.getParameter("rating"));
        String opinion = request.getParameter("opinion");

        // Retrieve user_id from the session
        HttpSession session = request.getSession();
        User abc = (User) session.getAttribute("acc");
        int user_id = Integer.parseInt(abc.getUser_id());

        // Retrieve mentor_id from the request
        int mentor_id = Integer.parseInt(request.getParameter("mentor_id"));

        // Insert feedback into the database
        FeedbackDAO fb = new FeedbackDAO();
        if (fb.insertFeedback(user_id, mentor_id, rating, opinion)) {
            // Retrieve CV details of the mentor
            MentorCVDAO dao = new MentorCVDAO();
            CV_Mentor cv = dao.getCvMentorById(String.valueOf(mentor_id));

            // Retrieve the list of all mentors
            List<CV_Mentor> list = dao.getAllListMentor();

            // Retrieve the list of feedback for the mentor
            FeedbackDAO dao1 = new FeedbackDAO();
            List<Feedback> listF = dao1.getAllFeedbackOfMentor(mentor_id);

            // Set attributes in the request for further processing
            request.setAttribute("mentor_id", mentor_id);
            request.setAttribute("cv", cv);
            request.setAttribute("listMentor", list);
            request.setAttribute("listF", listF);

            // Forward the request to the specified JSP file for rendering
            request.getRequestDispatcher("common/viewCvMentor.jsp").forward(request, response);
        }

    }
}
