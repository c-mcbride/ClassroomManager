package com.califfmcbride.classroommanagement;
import java.util.List;
import java.util.ArrayList;
public class Student {
    private String name;
    private int studentId;
    private List<Course> courses; ///Every student will be enrolled in courses

    //Construct the student
    public Student(String name, int studentId){
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    //Getters and setters
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getStudentId(){ return studentId; }
    public void setStudentId(int studentId){ this.studentId = studentId; }

    //Methods
    //Add a course
    public void addCourse(Course course){
        this.courses.add(course);
    }
}
