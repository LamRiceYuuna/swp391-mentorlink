/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.CreateRequest;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import dao.requestDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Skill;

/**
 *
 * @author damtu
 */
public class requestMentor extends HttpServlet {
    static int id_temp;
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
        
        
        //   request.setAttribute("errE", "Lỗi: Thời điểm kết thúc nhỏ hơn thời điểm bắt đầu");
       requestDAO dao = new requestDAO();
        List<Skill> list = dao.getAllskillBySkill_id(id_temp);
        // day data len jsp
        request.setAttribute("listp", list);
//            request.setAttribute("id", id_mentor);
        request.getRequestDispatcher("mentee/createRequest.jsp").forward(request, response);
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_mentor = request.getParameter("mentor_id");
        id_temp = Integer.parseInt(id_mentor);
        //   request.setAttribute("errE", "Lỗi: Thời điểm kết thúc nhỏ hơn thời điểm bắt đầu");
        requestDAO dao = new requestDAO();
        List<Skill> list = dao.getAllskillBySkill_id(Integer.parseInt(id_mentor));
        // day data len jsp
        request.setAttribute("listp", list);
//            request.setAttribute("id", id_mentor);
        request.getRequestDispatcher("mentee/createRequest.jsp").forward(request, response);
    }

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
        String tieude = request.getParameter("tieude");
        String batdau = request.getParameter("batdau");
        String ketthuc = request.getParameter("ketthuc");
        String sogiohoc = request.getParameter("sogiohoc");
        String noidung = request.getParameter("noidung");
        String[] skills = request.getParameterValues("skills");
        String framework = request.getParameter("framework");
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
                || isEmpty(noidung) || skills == null || isEmpty(framework)) {
            request.setAttribute("errE", "Không được để trống thông tin nào!");
            processRequest(request, response);
        } else if (skills == null || skills.length < 1 || skills.length > 3) {
            System.out.println("Lỗi: Số lượng kỹ năng phải từ 1 đến 3");
            request.setAttribute("errE", "Lỗi: Số lượng kỹ năng phải từ 1 đến 3");
            processRequest(request, response);
        } else if (khoangCach < soGioHoc1) {
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
//                DAO.insert1(tieude, batdau1, id_mentor, "2", ketthuc1, sogiohoc, noidung, framework, skills);

                try {
                    result = DAO.insert1(tieude, batdau1, id_temp, sessionUser_id, ketthuc1, sogiohoc, noidung, framework, skills);
                    request.getRequestDispatcher("/common/Successfully.html").forward(request, response);
                } catch (SQLException e) {
                    // Xử lý ngoại lệ ở đây
                    result = false; // hoặc thực hiện hành động khác khi có lỗi
                }
                //processRequest(request, response);
                try {
                    ml.send(mail, name, tieude, batdau1, ketthuc1, sogiohoc, noidung);
                   
                } catch (ParseException ex) {
                    Logger.getLogger(requestMentor.class.getName()).log(Level.SEVERE, null, ex);
                }
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

}
