/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Feedback;
import model.User;
import org.apache.jasper.tagplugins.jstl.core.ForEach;


/**
 *
 * @author admin
 */
public class FeedbackDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertFeedback(int user_id, int mentor_id, int rate_start, String feedback) {
        long millis= System.currentTimeMillis();   
        java.sql.Date date= new java.sql.Date(millis);   
        String sql = "INSERT INTO `swp391_group5`.`feedback`\n"
                + "(`user_id`,\n"
                + "`mentor_id`,\n"
                + "`rate_start`,\n"
                + "`feedback_comment`,\n"
                + "`create_date`,\n"
                + "`fb_status`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setInt(2, mentor_id);
            ps.setInt(3, rate_start);
            ps.setString(4, feedback);
            ps.setDate(5, date);
            ps.setInt(6, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Feedback> getAllFeedbackByStatus() {

        ArrayList<Feedback> list = new ArrayList<>();
        String query = "SELECT email,full_name, avatar, feedback.user_id, mentor_id, rate_start, feedback_comment, "
                + "feedback.create_date, fb_status FROM user join feedback on feedback.user_id = user.user_id;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(rs.getInt("user_id"),rs.getInt("mentor_id"),rs.getInt("rate_start"),rs.getString("feedback_comment"), 
                        rs.getDate("create_date"), rs.getInt("fb_status"), new User(rs.getString("avatar"), rs.getString("full_name"), rs.getString("email"))));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
