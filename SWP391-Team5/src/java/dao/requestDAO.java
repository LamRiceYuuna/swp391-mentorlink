/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Request;
import model.Skill;
import model.User;

/**
 *
 * @author damtu
 */
public class requestDAO extends DBContext {

    public List<Skill> getAllskillBySkill_id(int id_mentor) {

        List<Skill> list = new ArrayList<>();
        String sql = "SELECT cv_skill.mentor_id,cv_skill.skill_id,skill.skill_name,skill.skill_status\n"
                + "FROM swp391_group5.cv_skill\n"
                + "JOIN skill ON cv_skill.skill_id = skill.skill_id where skill.skill_status =1 and cv_skill.mentor_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_mentor);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Skill(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }

        } catch (Exception e) {

        }
        return list;

    }

    public List<Request> listRequestByMetorID(String mentor_id) {
        List<Request> list1 = new ArrayList<>();
        String sql = "SELECT * FROM swp391_group5.request where mentor_id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(mentor_id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list1.add(new Request(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getTimestamp(7),
                        rs.getTimestamp(8),
                        rs.getTimestamp(9),
                        rs.getInt(10)
                ));
            }

        } catch (Exception e) {

        }
        return list1;

    }

    public List<Request> listRequestByID(String mentee_id) {
        List<Request> list1 = new ArrayList<>();
        String sql = "SELECT * FROM swp391_group5.request where mentee_id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(mentee_id));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list1.add(new Request(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getTimestamp(7),
                        rs.getTimestamp(8),
                        rs.getTimestamp(9),
                        rs.getInt(10)
                ));
            }

        } catch (Exception e) {

        }
        return list1;

    }

    public static void main(String[] args) {
        requestDAO dao = new requestDAO();
        int id_mentor = 2;
        String mentee_id = "3";
        String id = "27";
        dao.deletebyID(id);
        //List<Skill> list = dao.getAllskillBySkill_id(id_mentor);
//        List<Request> list = dao.listRequestByID(mentee_id);
//        for (Request o : list) {
//            System.out.println(o);
//        }

    }

    public void insert(String tieude, Timestamp batdau1, int id_mentor, String sessionUser_id, Timestamp ketthuc1,
            String sogiohoc, String noidung, String framework) {

        // Lấy thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();
        // Cộng thêm 12 giờ
        LocalDateTime newTime = currentTime.plusHours(12);
        // Định dạng lại chuỗi thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String currentFormatted = currentTime.format(formatter);
        String newFormatted = newTime.format(formatter);
        LocalDateTime currentDateTime = LocalDateTime.parse(currentFormatted, formatter);
        LocalDateTime newDateTime = LocalDateTime.parse(newFormatted, formatter);
        // In ra kết quả
        System.out.println("Thời gian hiện tại: " + currentDateTime);
        System.out.println("Thời gian sau khi cộng 12 giờ: " + newDateTime);
        // Chuyển đổi LocalDateTime thành Timestamp
        Timestamp timestamp = Timestamp.valueOf(newDateTime);
        //******************************************************
        int request_status = 1;
        String sql = "INSERT INTO `swp391_group5`.`request` ( `mentor_id`, `mentee_id`,  `title`, `request_content`, `time_study`, `time_begin`, `created_date`, `finish_date`, `request_status`)"
                + " VALUES ( ?, ?,  ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_mentor);
            ps.setInt(2, Integer.parseInt(sessionUser_id));
            // ps.setInt(3,Integer.parseInt(skills));
            ps.setString(3, tieude);
            ps.setString(4, noidung);
            ps.setInt(5, Integer.parseInt(sogiohoc));
            ps.setTimestamp(6, timestamp);
            ps.setTimestamp(7, batdau1);
            ps.setTimestamp(8, ketthuc1);
            ps.setInt(9, request_status);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean insert1(String tieude, Timestamp batdau1, int id_mentor, String sessionUser_id, Timestamp ketthuc1,
            String sogiohoc, String noidung, String framework, String[] skills) throws SQLException {

        // Lấy thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();
        // Cộng thêm 12 giờ
        LocalDateTime newTime = currentTime.plusHours(12);
        // Định dạng lại chuỗi thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String currentFormatted = currentTime.format(formatter);
        String newFormatted = newTime.format(formatter);
        LocalDateTime currentDateTime = LocalDateTime.parse(currentFormatted, formatter);
        LocalDateTime newDateTime = LocalDateTime.parse(newFormatted, formatter);
        // In ra kết quả
        System.out.println("Thời gian hiện tại: " + currentDateTime);
        System.out.println("Thời gian sau khi cộng 12 giờ: " + newDateTime);
        // Chuyển đổi LocalDateTime thành Timestamp
        Timestamp timestamp = Timestamp.valueOf(newDateTime);
        //******************************************************
        int request_status = 1;
        int request_id = -1;
        try {

            connection.setAutoCommit(false);  // Vô hiệu hóa tự động xác nhận giao dịch

            //Câu lệnh Insert Information Request vao Table Request
            String sql = "INSERT INTO `swp391_group5`.`request` ( `mentor_id`, `mentee_id`,  "
                    + "`title`, `request_content`, `time_study`, `time_begin`, `created_date`, `finish_date`, `request_status`)"
                    + " VALUES ( ?, ?,  ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_mentor);
            ps.setInt(2, Integer.parseInt(sessionUser_id));
            // ps.setInt(3,Integer.parseInt(skills));
            ps.setString(3, tieude);
            ps.setString(4, noidung);
            ps.setInt(5, Integer.parseInt(sogiohoc));
            ps.setTimestamp(6, timestamp);
            ps.setTimestamp(7, batdau1);
            ps.setTimestamp(8, ketthuc1);
            ps.setInt(9, request_status);
            ps.executeUpdate();

            // Lấy request_id từ bảng A
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                request_id = generatedKeys.getInt(1);
            }
            generatedKeys.close();
            ps.close();

            // Câu lệnh INSERT Skill vao Table request_skill
            String sql2 = "INSERT INTO `swp391_group5`.`request_skill`\n"
                    + "(`skill_id`,\n"
                    + "`request_id`)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?);";
            PreparedStatement ps1 = connection.prepareStatement(sql2);

            for (String id : skills) {
                int value_id = Integer.parseInt(id);

                // Thiết lập các giá trị trong Prepared Statement
                ps1.setInt(1, value_id);
                ps1.setInt(2, request_id);

                // Thực hiện câu lệnh chèn vào cơ sở dữ liệu
                ps1.executeUpdate();
            }

            connection.commit();  // Áp dụng thay đổi vào cơ sở dữ liệu
            return true;
        } catch (Exception e) {
            connection.rollback();  // Hủy bỏ giao dịch nếu có lỗi
            return false;
        } finally {
            connection.setAutoCommit(true);  // Bật lại tự động xác nhận giao dịch
        }
    }

    public void update(int request_status, int request_id) {
        String sql = "UPDATE `swp391_group5`.`request` SET `request_status` = ? WHERE `request_id` = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request_status);
            ps.setInt(2, request_id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletebyID(String request_id) {
        String sql = "DELETE FROM `swp391_group5`.`request` WHERE `request_id` = ? AND `request_status` = 1;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(request_id));

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String SelectNameMentor(int mentor_id) {
        String name = "";
        String sql = "SELECT user.username FROM swp391_group5.request join user "
                + "ON request.mentor_id = user.user_id where mentor_id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, mentor_id);
            if (rs.next()) {
                name = rs.getString("username");
            }
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return name;

    }
    
    
    public void deletebyIDForMente(String request_id) {
        String sql = "DELETE FROM swp391_group5.`request` WHERE request_id = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(request_id));

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean checkTime(Timestamp finish){
        String sql = "SELECT TIMESTAMPADD(SQL_TSI_DAY, 2, '"+finish.toString()+"');";
        Date current = new Date(); 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             return current.after(rs.getTimestamp(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public String GetNameSkillByRequestID(int request_id){
         List<Request> list1 = new ArrayList<>();
        String sql = "select b.skill_name from request_skill a join skill b on a.skill_id=b.skill_id where a.request_id= "+request_id+" ;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {

        }
        return null;
    }

}
