package com.califfmcbride.classroommanagement;
public class Student {
    private String name;
    private int studentId;

    //Construct the student
    public Student(String name, int studentId){
        this.name = name;
        this.studentId = studentId;
    }

    //Getters
    public String getName(){
        return name;
    }

    public int getStudentId(){
        return studentId;
    }

    public void printInfo(){
        System.out.println("Student name: " + getName());
        System.out.println("Student id: " + getStudentId());
    }
}
