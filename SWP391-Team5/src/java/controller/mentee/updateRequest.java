/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.mentee;

import controller.CreateRequest.Mail;
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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.Skill;
import model.User;
import model.skill_Request;

/**
 *
 * @author damtu
 */
@WebServlet(name = "updateRequest", urlPatterns = {"/updateRequest"})
public class updateRequest extends HttpServlet {

    static int id_temp;
    static int id_request;

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
        HttpSession session = request.getSession();

        String request_id = "42";
        requestDAO dao = new requestDAO();
        //list request theo id
        Request re = dao.listbyRequest_ID(request_id);
        //list skill menter of request
//             String id_mentor = request.getParameter("mentor_id");
        String id_mentor = "2";
        List<Skill> list_a = dao.getAllskillBySkill_id(Integer.parseInt(id_mentor));
        List<skill_Request> list_b = dao.listRequest_SkillByID(request_id);
        request.setAttribute("List_skillRequest", list_b);
        request.setAttribute("request", re);
        request.setAttribute("list_Skill", list_a);
        request.getRequestDispatcher("/mentee/updateRequest.jsp").forward(request, response);

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
//        String id_mentor = request.getParameter("mentor_id");
//        id_temp = Integer.parseInt(id_mentor);
//          String request_id = request.getParameter("request_id");
//          id_request = Integer.parseInt(request_id);

        String request_id = "42";
        requestDAO dao = new requestDAO();
        //list request theo id
        Request re= dao.listbyRequest_ID(request_id);
        //list skill menter of request
//             String id_mentor = request.getParameter("mentor_id");
        String id_mentor = "2";
        List<Skill> list_a = dao.getAllskillBySkill_id(Integer.parseInt(id_mentor));
        List<skill_Request> list_b = dao.listRequest_SkillByID(request_id);
        request.setAttribute("List_skillRequest", list_b);
        request.setAttribute("request", re);
        request.setAttribute("list_Skill", list_a);
        request.getRequestDispatcher("/mentee/updateRequest.jsp").forward(request, response);
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
        //String request_id ="46";
        //String request_id = request.getParameter("request_id");
        String Request_id = "42";
        String tieude = request.getParameter("tieude");
        String batdau = request.getParameter("batdau");
        String ketthuc = request.getParameter("ketthuc");
        String sogiohoc = request.getParameter("sogiohoc");
        String noidung = request.getParameter("noidung");
        String[] skills = request.getParameterValues("skills");
        request.setAttribute("skills", skills);
        Mail ml = new Mail();
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
        //***********************************************************************
        if (isEmpty(tieude) || isEmpty(batdau) || isEmpty(ketthuc) || isEmpty(sogiohoc)
                || isEmpty(noidung) || skills == null) {
            request.setAttribute("errE", "Không được để trống thông tin nào!");
            processRequest(request, response);
        }  else if (khoangCach < soGioHoc1) {
            System.out.println("Lỗi: Thời gian bắt đầu và kết thúc phải lớn hơn hoạc bằng với số giờ học");
            request.setAttribute("errE", "Lỗi: Thời gian bắt đầu và kết thúc phải lớn hơn hoạc bằng với số giờ học");
            processRequest(request, response);
        } else if (ketthuc1.before(batdau1)) {
            System.out.println("Lỗi: Thời điểm kết thúc nhỏ hơn thời điểm bắt đầu ");
            request.setAttribute("errE", "Lỗi: Thời điểm kết thúc nhỏ hơn thời điểm bắt đầu");
            processRequest(request, response);
        } else {
            // Kiểm tra nếu kết thúc cách bắt đầu ít nhất 1 giờ
            long diffInMillies = ketthuc1.getTime() - batdau1.getTime();
            long diffInHours = diffInMillies / (60 * 60 * 1000);
            // Chuyển đổi milliseconds sang giờ

            if (diffInHours < 1) {
                System.out.println("Lỗi: Thời điểm kết thúc phải cách bắt đầu ít nhất 1 giờ");
                request.setAttribute("errE", "Lỗi: Thời điểm kết thúc phải cách bắt đầu ít nhất 1 giờ!");
                processRequest(request, response);
            } else {
                requestDAO DAO = new requestDAO();
                try {
                    result = DAO.update_request(Request_id, tieude, batdau1, ketthuc1, sogiohoc, noidung, skills); // Xử lý ngoại lệ ở đây
                    request.getRequestDispatcher("/common/Successfully.html").forward(request, response);
                    
                    if(result== true){
                        request.setAttribute("mess", "thanh cong ");
                        
                    }else{
                         request.setAttribute("mess", "that bai  ");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(updateRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                // hoặc thực hiện hành động khác khi có lỗi
//                processRequest(request, response);
//                try {
//                    ml.send(mail, name, tieude, batdau1, ketthuc1, sogiohoc, noidung, skills, framework);
//                   
//                } catch (ParseException ex) {
//                    Logger.getLogger(requestMentor.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
            }
            

        }
       

    }

    boolean isEmpty(String msg) {
        boolean result = false;
        if (msg.isEmpty()) {
            result = true;
        }
        return result;
    }

    public static Timestamp convertToTimestamp(String timestampString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        try {
            // Chuyển đổi chuỗi thành đối tượng java.util.Date
            java.util.Date parsedDate = dateFormat.parse(timestampString);

            // Chuyển đổi java.util.Date thành Timestamp
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
