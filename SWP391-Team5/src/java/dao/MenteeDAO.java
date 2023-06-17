package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Mentee;
import model.SkillMentee;

/**
 *
 * @author admin
 */
//Test merge
//Test 2
//Test tiep
//Test tiep2
public class MenteeDAO extends DBContext {

//    private int mentee_id;
//    private String mentee_name;
//    private String mentee_account;
//    private String mentee_avatar_img;
//    private byte mentee_gender;
//    private byte mentee_status;
//    private int mentee_hours;
    public List<Mentee> getMentees() {
        List<Mentee> t = new ArrayList<>();

        try {
            String sql = "select b.mentee_id, a.full_name, a.username, a.avatar, a.gender, a.user_status, sum(b.time_study) as time_study from user as a join request as b on a.user_id = b.mentee_id group by b.mentee_id order by a.full_name;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            int xMentee_id;
            String xMentee_name, xMentee_account, xMentee_avatar_img;
            byte xMentee_gender, xMentee_status;
            int xMentee_hours;
            Mentee x;
            while (rs.next()) {
                xMentee_id = rs.getInt("mentee_id");
                xMentee_name = rs.getString("full_name");
                xMentee_account = rs.getString("username");
                xMentee_avatar_img = rs.getString("avatar");
                xMentee_gender = rs.getByte("gender");
                xMentee_status = rs.getByte("user_status");
                xMentee_hours = rs.getInt("time_study");
                x = new Mentee(xMentee_id, xMentee_name, xMentee_account, xMentee_avatar_img, xMentee_gender, xMentee_status, xMentee_hours);
                t.add(x);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<SkillMentee> getSkillMentees() {
        List<SkillMentee> s = new ArrayList<>();

        try {
            String sql = "select c.mentee_id, a.skill_name, a.skill_status, a.skill_img from skill as a join request_skill  as b on a.skill_id = b.skill_id join request as c on b.request_id = c.request_id;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            int xMentee_id;
            String xMenteeSkillName, xMenteeImage;
            byte xMenteeStatus;
            SkillMentee x;
            while (rs.next()) {
                xMentee_id = rs.getInt("mentee_id");
                xMenteeSkillName = rs.getString("skill_name");
                xMenteeImage = rs.getString("skill_img");
                xMenteeStatus = rs.getByte("skill_status");
                x = new SkillMentee(xMentee_id, xMenteeSkillName, xMenteeStatus, xMenteeImage);
                s.add(x);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (s);
    }

    public int sumMentee(List<Mentee> t) {
        int result = 0;
        for (Mentee mentee : t) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        MenteeDAO d = new MenteeDAO();
        List<SkillMentee> t = d.getSkillMentees();
        for (SkillMentee mentee : t) {
            System.out.println(mentee.getSkillName());
        }
    }

}
