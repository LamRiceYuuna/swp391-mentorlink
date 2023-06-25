/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Skill;

/**
 *
 * @author Tuan Vinh
 */
public class SkillsDAO extends DBContext {

    public ArrayList<Skill> getAllSkills() {
        ArrayList<Skill> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM swp391_group5.skill";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Skill(rs.getInt("skill_id"), rs.getString("skill_name"), rs.getString("skill_img"), rs.getInt("skill_status")));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
