package controller.mentee;

import dao.MenteeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Mentee;
import model.Skill;
import model.SkillMentee;

/**
 *
 * @author DuyDepTrai
 */
public class ListMenteeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MenteeDAO u = new MenteeDAO();
        List<Mentee> lst = u.getMentees();
        List<SkillMentee> list = u.getSkillMentees();
        int sum = u.sumMentee(lst);
        request.setAttribute("lst", lst);
        request.setAttribute("sum", sum);
        request.setAttribute("list", list);

        request.getRequestDispatcher("/admin/mentee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MenteeDAO u = new MenteeDAO();
        List<Mentee> lst = u.getMentees();
        List<SkillMentee> list = u.getSkillMentees();
        int sum = u.sumMentee(lst);
        request.setAttribute("lst", lst);
        request.setAttribute("sum", sum);
        request.setAttribute("list", list);
        String xSearch = request.getParameter("search");
        request.getRequestDispatcher("/admin/mentee.jsp").forward(request, response);
        //new list 
    }
}
