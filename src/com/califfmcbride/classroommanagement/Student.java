package com.califfmcbride.classroommanagement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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

    Scanner scanner = new Scanner(System.in);

    //Getters and setters
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getStudentId(){ return studentId; }
    public void setStudentId(int studentId){ this.studentId = studentId; }
    public String getStudentEmail(){ return studentEmail; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }
    public List<Course> getCourses() { return courses; }

    //Methods
    //Add a course
    public void addCourse(Course course){
        this.courses.add(course);
    }

    //View courses
    public void viewCourses(){
        System.out.println("Length of courses: " + courses.size());
        if(courses.isEmpty()){
            System.out.println("Courses enrolled. ");
            return;
        }

        for(Course course : courses){
            System.out.println("Course Id: " + course.getCourseId());
            System.out.println("Course Name: " + course.getName());
        }
    }

    //Make a prinitable selection for the menu. Returns the courseId;
    public int returnCourseId(){
        System.out.println("Select course: ");
        int counter = 0;

        //Print all of the courses
        for(Course course: courses){
            System.out.println(counter + course.getName());
            counter++;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        //Return the ID of the selected course
        return courses.get(index - 1).getCourseId();
    }
}
