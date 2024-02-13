package com.califfmcbride.classroommanagement;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private String description;
    private Teacher teacher;
    private List<Student> students; //A list to hold all enrolled Students
    private List<Assignment> assignments; //A list to hold all assignments for the course

    public Course(String courseId, String name, String description, Teacher teacher){
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    //Getters and setters
    public String getCourseId(){return courseId;}
    public void setCourseId(String courseId){ this.courseId = courseId; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }
    public Teacher getTeacher(){ return teacher; }

}
