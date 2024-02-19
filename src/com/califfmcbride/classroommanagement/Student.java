package com.califfmcbride.classroommanagement;
import java.util.List;
import java.util.ArrayList;
public class Student {
    private String name;
    private int studentId;
    private String studentEmail;
    private List<Course> courses; ///Every student will be enrolled in courses

    //Construct the student
    public Student(String name, int studentId, String studentEmail){
        this.name = name;
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        this.courses = new ArrayList<>();
    }

    //Getters and setters
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getStudentId(){ return studentId; }
    public void setStudentId(int studentId){ this.studentId = studentId; }
    public String getStudentEmail(){ return studentEmail; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

    //Methods
    //Add a course
    public void addCourse(Course course){
        this.courses.add(course);
    }
}
