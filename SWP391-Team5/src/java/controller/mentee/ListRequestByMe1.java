package controller.mentee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.requestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import model.Request;
import model.User;

/**
 *
 * @author SANG
 */
public class ListRequestByMe1 extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ListRequestByMe1</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ListRequestByMe1 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String request_id=request.getParameter("idDel");
        String idp = request.getParameter("id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("acc"); 
        requestDAO dao = new requestDAO();
        String id = "3";
        Date currentTime = new Date(); 
        if(request_id!=null){
        dao.deletebyIDForMente(request_id);
        }
        
        int sum=0;
        if(idp!=null){
            int idr = Integer.parseInt(idp);
            dao.update(4, idr);
            
        }
        List<Request> list = dao.listRequestByID(id);
        sum=list.size();
        request.setAttribute("sum", sum);
        
        for (Request request1 : list) {
            if (request1.getRequest_status() == 5) {
                if(dao.checkTime(request1.getFinish_date())){
                dao.update(4, request1.getRequest_id());
                }
            }
            if(request1.getRequest_status()==1){
                Timestamp timeBeginString = request1.getTime_begin();

                if (timeBeginString.before(currentTime)) {
                    request1.setRequest_status(3);
                } else if (timeBeginString.after(currentTime)) {
                    request1.setRequest_status(1);
                }}
        }
        for (Request request1 : list) {
                dao.update(request1.getRequest_status(),request1.getRequest_id());
            }
        request.setAttribute("lista", list);
        request.getRequestDispatcher("/mentee/ListRequestByMe1.jsp").forward(request, response);

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
