package com.califfmcbride.classroommanagement;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String name;
    private String description;
    private Teacher teacher;
    private List<Student> students; //A list to hold all enrolled Students
    private List<Assignment> assignments; //A list to hold all assignments for the course

    public Course(int courseId, String name, String description, Teacher teacher){
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    //Getters and setters
    public int getCourseId(){return courseId;}
    public void setCourseId(int courseId){ this.courseId = courseId; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }
    public Teacher getTeacher(){ return teacher; }
    public void setTeacher(Teacher  teacher) { this.teacher = teacher; }
    public List<Student> getStudents(){ return students; }
    public List<Assignment> getAssignments(){ return assignments; }

    //Methods
    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void addAssignment(Assignment assignment){
        this.assignments.add(assignment);
    }

    //Print all students enrolled in the course
    public void listStudents(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }
}
