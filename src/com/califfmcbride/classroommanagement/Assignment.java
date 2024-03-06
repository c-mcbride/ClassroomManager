package com.califfmcbride.classroommanagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Assignment {
    private String title;
    private String description;
    private Date dueDate;
    private int assignmentId;
    private List<Submission> submissions; //List to hold all the submissions for that assignment

    public Assignment(String title, String description, Date dueDate, int assignmentId){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignmentId = assignmentId;
        this.submissions = new ArrayList<>();
    }

    //Getters and setters
    public String getTitle(){ return this.title; }
    public void setTitle(String title){ this.title = title; }
    public String getDescription(){ return this.description; }
    public void setDescription(String description){ this. description = description; }
    public Date getDueDate() { return this.dueDate; }
    public void setDueDate(Date date) { this.dueDate = date; }
    public int getAssignmentId() { return this.assignmentId; }
    public void setAssignmentId(int assignmentId){ this.assignmentId = assignmentId; }


    //Add submissions to this assignment
    public void addSubmission(Submission submission){
        this.submissions.add(submission);
    }

    //Returns the list of submissions for this assignment
    public List<Submission> getSubmissions(){
        return this.submissions;
    }
}
