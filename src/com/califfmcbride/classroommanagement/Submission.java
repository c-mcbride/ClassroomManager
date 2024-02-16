package com.califfmcbride.classroommanagement;
import java.time.LocalDateTime;

public class Submission {
    private int submissionId;
    private Student student;
    private Assignment assignment;
    private Grade grade;
    private String content;
    private LocalDateTime timeStamp;

    public Submission(int submissionId, Student student, Assignment assignment, String content, LocalDateTime timeStamp){
        this.submissionId = submissionId;
        this.student = student;
        this.assignment = assignment;
        this.content = content;
        this.timeStamp = timeStamp;
        this.grade = null;
    }

    //Getters and setters
    public int getSubmissionId() { return submissionId; }
    public void setSubmissionId(int submissionId) { this.submissionId = submissionId; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Assignment getAssignment() { return assignment; }
    public void setAssignment(Assignment assignment) { this.assignment = assignment; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }
}
