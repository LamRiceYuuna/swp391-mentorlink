/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Request_Skill;
import model.Skill;

/**
 *
 * @author Tuan Vinh
 */
public class requestSkillDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Request_Skill getRequestSkillID() {
        String query = "SELECT distinct request_skill.skill_id FROM swp391_group5.request join swp391_group5.request_skill on "
                + "request.request_id = request_skill.request_id where mentee_id = 3;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            ArrayList<Integer> skillIds = new ArrayList<>();

            while (rs.next()) {
                int skillId = rs.getInt("skill_id");
                skillIds.add(skillId);
            }

            Request_Skill request_skillID = new Request_Skill(skillIds);

            return request_skillID;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        requestSkillDAO obj = new requestSkillDAO(); // Thay YourClassName bằng tên lớp chứa phương thức getRequestSkillID()
        Request_Skill requestSkill = obj.getRequestSkillID();

        if (requestSkill != null) {
            ArrayList<Integer> skillIds = requestSkill.getItg();
            System.out.println("Skill IDs:");
            for (int skillId : skillIds) {
                System.out.println(skillId);
            }
        } else {
            System.out.println("Không có kết quả trả về từ phương thức getRequestSkillID()");
        }
    }
}
