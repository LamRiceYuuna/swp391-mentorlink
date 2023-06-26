
import dao.requestDAO;
import java.util.List;
import model.Request_Skill;

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
        String request_id ="41";
        List<Request_Skill> list = dao.listRequest_SkillByID(request_id);
        for (Request_Skill o : list) {
            System.out.println(o);
        }

    }
}
