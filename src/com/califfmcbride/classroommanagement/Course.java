package com.califfmcbride.classroommanagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Course {
    private int courseId;
    private String name;
    private String description;
    private Teacher teacher;
    private Map<Integer, Student> students; //A list to hold all enrolled Students
    private List<Assignment> assignments; //A list to hold all assignments for the course

    public Course(int courseId, String name, String description, Teacher teacher){
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new HashMap<>();
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
    public List<Assignment> getAssignments(){ return assignments; }

    //Methods
    //Maintains a hashmap off all students who are enrolled in the course
    public void addStudent(Student student){
        if(student != null & !students.containsKey(student.getStudentId())){
            students.put(student.getStudentId(), student);
        }
        else{
            System.out.println("This student is already enrolled in the course!");
        }
    }

    public void removeStudent(int studentId){
        if(students.containsKey(studentId)){
            students.remove(studentId);
        }
        else{
            System.out.println("The student is not in the course");
        }
    }

    public void listStudentsInCourse(){
        for(Student student : students.values()){
            System.out.println("Student Id: " + student.getStudentId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("-------------------------------------");
        }
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
