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

}
