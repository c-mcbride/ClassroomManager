package com.califfmcbride.classroommanagement;

public class Grade {
    private int gradeId;
    private Student student;
    private int value;
    private String feedback;

    public Grade(int gradeId, Student student, int value){
        this.gradeId = gradeId;
        this.student = student;
        this.value = value;
        this.feedback = null;
    }

    //Getters and setters
    public int getGradeId() { return gradeId; }
    public void setGradeId(int gradeId) { this.gradeId = gradeId; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

}
