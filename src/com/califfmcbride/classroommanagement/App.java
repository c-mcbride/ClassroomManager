package com.califfmcbride.classroommanagement;
import java.time.LocalDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        //Create a teacher
       Teacher teacher = new Teacher(1, "Mr. Smith","Smith@utc.edu");

       //Create a course and assign it to a teacher
       Course course = new Course("CS50", "Intro to computer science", "A beginner class on cs", teacher);

       //Add the course to the teachers list
       course.addClassToTeacher(course);

       //Create a student and add them to the course
       Student student = new Student("Alice", 1234);

       //Add student to course
       course.addStudent(student);

       //Create and assignment and add it to the course
       Assignment assignment = new Assignment("Homework 1", "Solve problems 1 to 5", new Date(), course, 101);
       teacher.addAssignment("CS50", assignment);

        Submission submission = new Submission(1, student, assignment, "My answers", LocalDateTime.now());

        // Test outputs
        System.out.println("Course: " + course.getName());
        System.out.println("Teacher: " + course.getTeacher().getName());
        System.out.println("Number of students in course: " + course.getStudents().size());
        System.out.println("Number of assignments in course: " + course.getAssignments().size());
        System.out.println("Submission content: " +submission.getContent());
    }
}
