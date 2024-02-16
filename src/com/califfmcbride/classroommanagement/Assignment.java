package com.califfmcbride.classroommanagement;
import java.util.Date;

public class Assignment {
    private String title;
    private String description;
    private Date dueDate;
    private Course course;
    private int assignmentId;

    public Assignment(String title, String description, Date dueDate, Course course, int assignmentId){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.course = course;
        this.assignmentId = assignmentId;
    }

    





}
