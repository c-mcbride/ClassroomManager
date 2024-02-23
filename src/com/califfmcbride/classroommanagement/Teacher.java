package com.califfmcbride.classroommanagement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private Map<Integer, Course> courses;

    public Teacher(int teacherId, String name, String email){
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.courses = new HashMap<>();
    }

    //Getters and Setters
    public int getTeacherId(){ return this.teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getName(){ return this.name; }
    public String getEmail(){ return this.email; }
    public void setEmail(String email){ this.email = email; }

    //Methods
    //Add the course to the teachers hashmap
    public void addCourse(Course course){
        if(course != null && !courses.containsKey(course.getCourseId())){
            courses.put(course.getCourseId(), course);
        }
        else{
            System.out.println("The teacher has already been assigned this course ");
        }
    }

    public void removeCourse(int courseId){
        if(courses.containsKey(courseId)){
            courses.remove(courseId);
        }
        else{
            System.out.println("The Teacher does not have this course")
        }
    }

    //Retrieve the course object from the HashMap by the courseId and add the assignment
    public void addAssignment(int courseId, Assignment assignment){
        if(courses.containsKey(courseId)){
            Course courseToAddAssignmentTo = courses.get(courseId);
            courseToAddAssignmentTo.addAssignment(assignment);
            return;
        }
        System.out.println("Course with ID " + courseId + " not found.");
    }

    public void listTeachersCourses(){
        for(Course course : courses.values()){
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Title: " + course.getName());
            System.out.println("Description: " + course.getDescription());
        }
    }
}
