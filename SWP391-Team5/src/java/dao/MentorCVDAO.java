/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CV_Mentor;
import model.MentorInfo;
import model.User;

/**
 *
 * @author Tuan Vinh
 */
public class MentorCVDAO extends DBContext {

    public boolean createCV(int mentor_id, String fullName, String date_of_birth, int gender, String address,
            String profession, String profession_intro, String service_des, String archivement, String archivement_des, String programming, String[] skillId) throws SQLException {
        try {

            connection.setAutoCommit(false);  // Vô hiệu hóa tự động xác nhận giao dịch

            //Câu lệnh Update Information user
            String sql1 = "UPDATE `swp391_group5`.`user`\n"
                    + "SET\n"
                    + "`gender` = ?,\n"
                    + "`full_name` = ?,\n"
                    + "`date_of_birth` = ?,\n"
                    + "`address` = ?\n"
                    + "WHERE `user_id` = ?;";

            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, gender);
            ps1.setString(2, fullName);
            ps1.setDate(3, java.sql.Date.valueOf(date_of_birth));
            ps1.setString(4, address);
            ps1.setInt(5, mentor_id);
            ps1.executeUpdate();

            // Câu lệnh INSERT vào table_Cv of Mentor
            String sql2 = "INSERT INTO swp391_group5.`cv_of_mentor`\n"
                    + "(mentor_id,\n"
                    + "profession,\n"
                    + "profession_introduction,\n"
                    + "service_description,\n"
                    + "achievements,\n"
                    + "achievements_des,\n"
                    + "language)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?);";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setInt(1, mentor_id);
            ps2.setString(2, profession);
            ps2.setString(3, profession_intro);
            ps2.setString(4, service_des);
            ps2.setString(5, archivement);
            ps2.setString(6, archivement_des);
            ps2.setString(7, programming);
            ps2.executeUpdate();
            // Câu lệnh INSERT vào table_B
            String sql3 = "INSERT INTO `swp391_group5`.`cv_skill`\n"
                    + "(`mentor_id`,\n"
                    + "`skill_id`)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?);";
            PreparedStatement ps3 = connection.prepareStatement(sql3);

            for (String id : skillId) {
                int value_id = Integer.parseInt(id);

                // Thiết lập các giá trị trong Prepared Statement
                ps3.setInt(1, mentor_id);
                ps3.setInt(2, value_id);

                // Thực hiện câu lệnh chèn vào cơ sở dữ liệu
                ps3.executeUpdate();
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
    
    public CV_Mentor getCvMentorById(String mentor_id) {

        String sql = "select mentor_id ,full_name, avatar, email, username, phone, profession, profession_introduction,service_description, "
                + "achievements,achievements_des, language from user join cv_of_mentor on user_id = mentor_id where mentor_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, mentor_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new CV_Mentor(rs.getInt("mentor_id"), rs.getString("profession"), rs.getString("profession_introduction"),
                        rs.getString("service_description"), rs.getString("achievements"), rs.getString("achievements_des"), rs.getString("language"),
                        new User(rs.getString("avatar"), rs.getString("full_name"), rs.getString("email"), rs.getString("username"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    

   public List<CV_Mentor> getTopListMentor() {
        List<CV_Mentor> list = new ArrayList<>();
        String sql = "select *  from(select   mentor_id ,email,full_name, avatar, profession, profession_introduction,service_description, achievements \n" +
        "  from user inner join cv_of_mentor on user_id = mentor_id) as top limit 4";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new CV_Mentor(rs.getInt("mentor_id"), rs.getString("profession"), 
                        rs.getString("profession_introduction"), rs.getString("service_description"), rs.getString("achievements"), 
                        new User(rs.getString("avatar"), rs.getString("full_name"), rs.getString("email"))));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
   
   public List<CV_Mentor> getAllListMentor() {
        List<CV_Mentor> list = new ArrayList<>();
        String sql = "select   mentor_id ,email,full_name, avatar, profession, profession_introduction,service_description, achievements \n" +
        "  from user inner join cv_of_mentor on user_id = mentor_id";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new CV_Mentor(rs.getInt("mentor_id"), rs.getString("profession"), 
                        rs.getString("profession_introduction"), rs.getString("service_description"), rs.getString("achievements"), 
                        new User(rs.getString("avatar"), rs.getString("full_name"), rs.getString("email"))));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
   
   public List<CV_Mentor> getListByPage(List<CV_Mentor> lisst, int start, int end){
     List<CV_Mentor> arr = new ArrayList<>();
       for (int i = start; i < end; i++) {
           arr.add(lisst.get(i));
       }
       return arr;
   };
   
   public List<CV_Mentor> search(String keyword, String professtion, String service ,String achievements){
       List<CV_Mentor> list = new ArrayList<>();
       String sql = "select   mentor_id ,email,full_name, avatar, profession, profession_introduction,service_description, achievements \n" +
        "  from user inner join cv_of_mentor on user_id = mentor_id where 1=1 ";
       if(keyword!=null && !keyword.equals("")){
           sql += " and full_name like '%" + keyword + "%' " ;
       }
       if(professtion!= null && !professtion.equals("")){
           sql += " and profession like '%" + professtion + "%' " ;
       }
       if(service != null && !service.equals("")){
           sql += " and service_description like '%" + service +"%'  " ;
       }
       if(achievements != null && !achievements.equals("")){
           sql += " and achievements like '%" + achievements +"%'  " ;
       }
       //sql += " order by mentor_id  limit " + pageSize + " offset " + (index -1) * pageSize;
       
       try{
           PreparedStatement stm = connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               list.add(new CV_Mentor(rs.getInt("mentor_id"), rs.getString("profession"), 
                        rs.getString("profession_introduction"), rs.getString("service_description"), rs.getString("achievements"), 
                        new User(rs.getString("avatar"), rs.getString("full_name"), rs.getString("email"))));
           }
            
       }catch(SQLException e){
           System.out.println(e);
       }
        return list;
           
        
   }

   
   Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
   
   public void updateStatus(int id, int s) {

        String query = "Update swp391_group5.user SET user_status = ? where user_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, s);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public User GetByIdMentor(int id) {
        User u = new User();
        try {
            String query = "SELECT * FROM swp391_group5.user where user_id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getDate(13),
                        rs.getInt(14));
            }

        } catch (Exception e) {

        }
        return null;
    }
    
    //list Search Mentor: Da Phan Trang
    //List all mentor -> Da Phan Trang -> Vi tri trang.
    public List<MentorInfo> GetListMentorPagingSearchAdm(int index, String txtSearch ) {
        List<MentorInfo> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "ROW_NUMBER() OVER (ORDER BY cv_of_mentor.mentor_id) AS STT,\n"
                    + "user.user_id AS ID,\n"
                    + "user.full_name AS `Full name`,\n"
                    + "user.username AS `Account name`,\n"
                    + "cv_of_mentor.profession AS  `Occupation`,\n"
                    + "COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END) AS `Number of currently`,\n"
                    + "CONCAT(ROUND((COUNT(CASE WHEN request.request_status = 4 THEN 1 ELSE NULL END) / COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END)) * 100), '%') AS  `Percentage completed`,\n"
                    + "ROUND(AVG(feedback.rate_start), 1) AS  `Average star rating`,\n"
                    + "CASE WHEN user.user_status = 1 THEN 1 ELSE 0 END AS `Active status of the advisor`\n"
                    + "FROM swp391_group5.user\n"
                    + "JOIN cv_of_mentor ON user.user_id = cv_of_mentor.mentor_id\n"
                    + "LEFT JOIN request ON user.user_id = request.mentor_id\n"
                    + "LEFT JOIN feedback ON user.user_id = feedback.mentor_id\n"
                    //Them Dieu kien search tu khoa cua ten.
                    + "WHERE user.role = 2 and user.full_name like ? \n"
                    + "GROUP BY user.user_id\n"
                    // SET Ban Ghi bat dau va ban ghi cuoi cung -> lay ra toi da 10 ban ghi
                    + "LIMIT 10 OFFSET ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Moi page 10 rows: Index  là vi tri page
            ps.setInt(2, (index - 1) * 10);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int stt = rs.getInt("STT");
                int id = rs.getInt("ID");
                String fullName = rs.getString("Full name");
                String accountName = rs.getString("Account name");
                String occupation = rs.getString("Occupation");
                int numberOfCurrently = rs.getInt("Number of currently");
                String percentageCompleted = rs.getString("Percentage completed");
                double averageStarRating = rs.getDouble("Average star rating");
                int activeStatusOfAdvisor = rs.getInt("Active status of the advisor");

                MentorInfo mentorInfo = new MentorInfo(stt, id, fullName, accountName, occupation, numberOfCurrently, percentageCompleted, averageStarRating, activeStatusOfAdvisor);
                list.add(mentorInfo);
            }
            return list;
        } catch (Exception ex) {
        }
        return null;
    }
    
    //Lấy ra số lượng trang n /  trên tổng số trang.
    public int getNumberPageSearch(String txtSearch) {
        String query = "Select count(*) from swp391_group5.user where user.role = 2  and user.full_name like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                //Tổng số bản ghi mentor được lấy ra.
                int total = rs.getInt(1);
                int countPage = 0;
                //Tổng số bản ghi mentor được lấy ra / Số lượng bản ghi sẽ có trên một trang. 
                // Lay Ra So luong trang ( Moi trang la 10 bang ghi).
                countPage = total / 10;
                if (total % 10 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    //Lấy ra số lượng trang n /  trên tổng số trang.
    public int getNumberPage() {
        String query = "Select count(*) from swp391_group5.user where user.role = 2";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Tổng số bản ghi mentor được lấy ra.
                int total = rs.getInt(1);
                int countPage = 0;
                //Tổng số bản ghi mentor được lấy ra / Số lượng bản ghi sẽ có trên một trang. 
                // Lay Ra So luong trang ( Moi trang la 10 bang ghi).
                countPage = total / 10;
                if (total % 10 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    //List all mentor -> Da Phan Trang -> Vi tri trang.
    public List<MentorInfo> GetListMentorPagingAdm(int index) {
        List<MentorInfo> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "ROW_NUMBER() OVER (ORDER BY cv_of_mentor.mentor_id) AS STT,\n"
                    + "user.user_id AS ID,\n"
                    + "user.full_name AS `Full name`,\n"
                    + "user.username AS `Account name`,\n"
                    + "cv_of_mentor.profession AS  `Occupation`,\n"
                    + "COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END) AS `Number of currently`,\n"
                    + "CONCAT(ROUND((COUNT(CASE WHEN request.request_status = 4 THEN 1 ELSE NULL END) / COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END)) * 100), '%') AS  `Percentage completed`,\n"
                    + "ROUND(AVG(feedback.rate_start), 1) AS  `Average star rating`,\n"
                    + "CASE WHEN user.user_status = 1 THEN 1 ELSE 0 END AS `Active status of the advisor`\n"
                    + "FROM swp391_group5.user\n"
                    + "JOIN cv_of_mentor ON user.user_id = cv_of_mentor.mentor_id\n"
                    + "LEFT JOIN request ON user.user_id = request.mentor_id\n"
                    + "LEFT JOIN feedback ON user.user_id = feedback.mentor_id\n"
                    + "WHERE user.role = 2\n"
                    + "GROUP BY user.user_id\n"
                    // SET Ban Ghi bat dau va ban ghi cuoi cung -> lay ra toi da 10 ban ghi
                    + "LIMIT 10 OFFSET ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            // Moi page 10 rows: Index  là vi tri page
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                int stt = rs.getInt("STT");
                int id = rs.getInt("ID");
                String fullName = rs.getString("Full name");
                String accountName = rs.getString("Account name");
                String occupation = rs.getString("Occupation");
                int numberOfCurrently = rs.getInt("Number of currently");
                String percentageCompleted = rs.getString("Percentage completed");
                double averageStarRating = rs.getDouble("Average star rating");
                int activeStatusOfAdvisor = rs.getInt("Active status of the advisor");

                MentorInfo mentorInfo = new MentorInfo(stt, id, fullName, accountName, occupation, numberOfCurrently, percentageCompleted, averageStarRating, activeStatusOfAdvisor);
                list.add(mentorInfo);
            }
            return list;
        } catch (Exception ex) {
        }
        return null;
    }

    //List all mentor -> Chua phan trang.
    public List<MentorInfo> GetListMentorAdm() {
        List<MentorInfo> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "    ROW_NUMBER() OVER (ORDER BY cv_of_mentor.mentor_id) AS STT,\n"
                    + "    user.user_id AS ID,\n"
                    + "    user.full_name AS `Full name`,\n"
                    + "    user.username AS `Account name`,\n"
                    + "    cv_of_mentor.profession AS `Occupation`,\n"
                    //  Đếm số lượng yêu cầu đã chấp thuận: 1.Open    2.Processing     3.Cancel     4.Closed   ->  1 or 2 or 4 là OKE -> 4 La HỦY
                    + "    COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END) AS `Number of currently`,\n"
                    //  Tính % tỉnh lệ hoàn thành:  Số lượng hoàn thành /  Số yêu cầu chấp thuận.         -> Closed: HỦY -> Là đã hoàn thành
                    + "    CONCAT(ROUND((COUNT(CASE WHEN request.request_status = 4 THEN 1 ELSE NULL END) / "
                    + "    COUNT(CASE WHEN request.request_status IN (1, 2, 4) THEN 1 ELSE NULL END)) * 100), '%') AS `Percentage completed`,\n"
                    //  Tính trung bình cộng số lượng Rate_Star.
                    + "	   ROUND(AVG(feedback.rate_start), 1) AS  `Average star rating`,\n"
                    + "    CASE WHEN user.user_status = 1 THEN 1 ELSE 0 END AS `Active status of the advisor`\n"
                    + "FROM swp391_group5.user\n"
                    + "JOIN cv_of_mentor ON user.user_id = cv_of_mentor.mentor_id\n"
                    + "LEFT JOIN request ON user.user_id = request.mentor_id\n"
                    + "LEFT JOIN feedback ON user.user_id = feedback.mentor_id\n"
                    //  Điều kiện role = 2 (Mentor)
                    + "WHERE user.role = 2\n"
                    + "GROUP BY user.user_id";

            //ORDER BY `Average star rating` DESC: -> Dung de  sap xep mentor theo so luong rate giam dan.
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int stt = rs.getInt("STT");
                int id = rs.getInt("ID");
                String fullName = rs.getString("Full name");
                String accountName = rs.getString("Account name");
                String occupation = rs.getString("Occupation");
                int numberOfCurrently = rs.getInt("Number of currently");
                String percentageCompleted = rs.getString("Percentage completed");
                double averageStarRating = rs.getDouble("Average star rating");
                int activeStatusOfAdvisor = rs.getInt("Active status of the advisor");

                MentorInfo mentorInfo = new MentorInfo(stt, id, fullName, accountName, occupation, numberOfCurrently, percentageCompleted, averageStarRating, activeStatusOfAdvisor);
                list.add(mentorInfo);
            }
            return list;
        } catch (Exception ex) {
        }
        return null;
    }
    
    
    public boolean updateCV(int mentor_id, String fullName, String date_of_birth, int gender, String address,
            String profession, String profession_intro, String service_des, String archivement, String archivement_des, String programming, String[] skillId) throws SQLException {
        try {

            connection.setAutoCommit(false);  // Vô hiệu hóa tự động xác nhận giao dịch

            //Câu lệnh Update Information user
            String sql1 = "UPDATE `swp391_group5`.`user`\n"
                    + "SET\n"
                    + "`gender` = ?,\n"
                    + "`full_name` = ?,\n"
                    + "`date_of_birth` = ?,\n"
                    + "`address` = ?\n"
                    + "WHERE `user_id` = ?;";

            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, gender);
            ps1.setString(2, fullName);
            ps1.setDate(3, java.sql.Date.valueOf(date_of_birth));
            ps1.setString(4, address);
            ps1.setInt(5, mentor_id);
            ps1.executeUpdate();

            // Câu lệnh INSERT vào table_Cv of Mentor
            String sql2 = "UPDATE `swp391_group5`.`cv_of_mentor`\n"
                    + "SET\n"
                    + "`profession` = ?,\n"
                    + "`profession_introduction` = ?,\n"
                    + "`service_description` = ?,\n"
                    + "`achievements` = ?,\n"
                    + "`achievements_des` = ?,\n"
                    + "`language` = ?\n"
                    + "WHERE `mentor_id` = ?;";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, profession);
            ps2.setString(2, profession_intro);
            ps2.setString(3, service_des);
            ps2.setString(4, archivement);
            ps2.setString(5, archivement_des);
            ps2.setString(6, programming);
            ps2.setInt(7, mentor_id);
            ps2.executeUpdate();
            // Câu lệnh INSERT vào table_B
//            String sql3 = "UPDATE `swp391_group5`.`cv_skill`\n"
//                    + "SET `skill_id` = ?\n"
//                    + "WHERE `mentor_id` = ?;";
//            PreparedStatement ps3 = connection.prepareStatement(sql3);
//
//            for (String id : skillId) {
//                int value_id = Integer.parseInt(id);
//
//                // Thiết lập các giá trị trong Prepared Statement
//                ps3.setInt(1, value_id);
//                ps3.setInt(2, mentor_id);
//
//                // Thực hiện câu lệnh cập nhật trong cơ sở dữ liệu
//                ps3.executeUpdate();
//            }

            connection.commit();  // Áp dụng thay đổi vào cơ sở dữ liệu
            return true;
        } catch (Exception e) {
            connection.rollback();  // Hủy bỏ giao dịch nếu có lỗi
            return false;
        } finally {
            connection.setAutoCommit(true);  // Bật lại tự động xác nhận giao dịch
        }

    }
    
    
    public CV_Mentor getInfoCvMentorById(String mentor_id) {

        String sql = "select mentor_id ,username, gender, full_name, date_of_birth, email, address, profession, profession_introduction,service_description, "
                + "achievements,achievements_des, language from user join cv_of_mentor on user_id = mentor_id where mentor_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, mentor_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new CV_Mentor(rs.getInt("mentor_id"), rs.getString("profession"), rs.getString("profession_introduction"),
                        rs.getString("service_description"), rs.getString("achievements"), rs.getString("achievements_des"), rs.getString("language"),
                        new User(rs.getString("username"), rs.getInt("gender"), rs.getString("full_name"), rs.getDate("date_of_birth"), rs.getString("email"), rs.getString("address")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
   
    public static void main(String[] args) {
        
    }
}
