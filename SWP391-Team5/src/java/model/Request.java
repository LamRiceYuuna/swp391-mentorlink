/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.*;
/**
 *
 * @author admin
 */
public class Request {
    private int request_id;
    private int mentor_id;
    private int mentee_id;
    private int skill_id;
    private String title;
    private String request_content;
    private int request_status;
    private Date created_date;
    private Date finish_date;

    public Request() {
    }

    public Request(int request_id, int mentor_id, int mentee_id, int skill_id, String title, String request_content, int request_status, Date created_date, Date finish_date) {
        this.request_id = request_id;
        this.mentor_id = mentor_id;
        this.mentee_id = mentee_id;
        this.skill_id = skill_id;
        this.title = title;
        this.request_content = request_content;
        this.request_status = request_status;
        this.created_date = created_date;
        this.finish_date = finish_date;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public int getMentee_id() {
        return mentee_id;
    }

    public void setMentee_id(int mentee_id) {
        this.mentee_id = mentee_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequest_content() {
        return request_content;
    }

    public void setRequest_content(String request_content) {
        this.request_content = request_content;
    }

    public int getRequest_status() {
        return request_status;
    }

    public void setRequest_status(int request_status) {
        this.request_status = request_status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }
    
    
}
