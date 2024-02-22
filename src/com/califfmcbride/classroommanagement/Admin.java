package com.califfmcbride.classroommanagement;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String name;
    private int adminId;
    private List<Teacher> teachers;

    public Admin(String name, int adminId){
        this.name = name;
        this.adminId = adminId;
        this.teachers = new ArrayList<>();
    }

    //Getters and Setters;
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
    public int getAdminId(){ return this.adminId; }
    public void setAdminId(int adminId){ this.adminId = adminId;}
    public List<Teacher> getTeachers(){ return this.teachers; }

    //Methods
    //Add teacher to school. Will need to gather this info in the main method
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //Assign course to teacher. Construct course in main method
    public void addCourseToTeacher(Teacher teacher, Course course){
        teacher.addCourse(course);
    }

    //Add students to course
    public void addStudentToCourse(Student student, Course course){
        course.addStudent(student); //Enroll student in course
        student.addCourse(course); //Add to students schedule
    }

    public void printTeacherList(){
        for(Teacher teacher : teachers){
            System.out.println("Teacher ID: " + teacher.getTeacherId());
            System.out.println("Name: " + teacher.getName());
            System.out.println("Email: " + teacher.getEmail());
        }
    }

    public Teacher findTeacherById(int teacherId){
        for(Teacher teacher : teachers){
            if(teacher.getTeacherId() == teacherId){
                return teacher;
            }
        }

        return null;
    }
}
