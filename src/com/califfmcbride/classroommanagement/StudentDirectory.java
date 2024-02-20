package com.califfmcbride.classroommanagement;
import java.util.HashMap;
import java.util.Map;

//Create a singleton to hold the roster of students for the school.
public class StudentDirectory {
    private static StudentDirectory instance;
    private Map<Integer, Student> students; //Holds the list of students

    private StudentDirectory(){
        this.students = new HashMap<>();
    }

    //Returns the instance to the caller
    public static StudentDirectory getInstance(){
        if(instance == null){
            instance = new StudentDirectory();
        }

        return instance;
    }

    public void addStudent(Student student){
        //If there is a student object passed in and the key is not already there we add the student
        if(student != null && !students.containsKey(student.getStudentId())){
            students.put(student.getStudentId(), student);
        }
        else{
            System.out.println("The student is already in the data base! ");
        }
    }

    public void removeStudent(int studentId){
        if(students.containsKey(studentId)){
            students.remove(studentId);
        }
        else{
            System.out.println("The student does not exist in the data base");
        }
    }

    public void listAllStudents(){
        for(Student student : students.values()){
            System.out.println("Student Id: " + student.getStudentId() + ", Name: " + student.getName());
            System.out.println("-------------------------------------");
        }
    }

    //Method to return specific student object if it exists in the directory
    public Student getStudentById(int studentId){
        if(students.containsKey(studentId)){
            Student student = students.get(studentId);
            return student;
        }
        else{
            return null;
        }
    }
}
