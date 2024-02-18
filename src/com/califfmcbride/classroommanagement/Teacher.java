package com.califfmcbride.classroommanagement;
import java.util.List;
import java.util.ArrayList;

public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private List<Course> courses;

    public Teacher(int teacherId, String name, String email){
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>(); //Holds all of the teachers courses
    }

    //Getters and Setters
    public int getTeacherId(){ return this.teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public void setEmail(String email){ this.email = email; }

    //Methods
    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    //Add assignment to a course by courseID
    public void addAssignment(int courseId, Assignment assignment){
        for (Course course: this.courses){
            if(course.getCourseId() == courseId){
                course.addAssignment(assignment);
                return;
            }
        }
        System.out.println("Course with ID " + courseId + " not found.");
    }
}
