
import dao.requestDAO;
import java.util.List;
import model.Request_Skill;
import model.skill_Request;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author damtu
 */
public class test {
     public static void main(String[] args) {
        requestDAO dao = new requestDAO();
        String request_id ="40";
        List<skill_Request> list = dao.listRequest_SkillByID(request_id);
        for (skill_Request o : list) {
            System.out.println(o);
        }
       
        
       
    }
}
