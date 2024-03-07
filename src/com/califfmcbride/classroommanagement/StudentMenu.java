package com.califfmcbride.classroommanagement;
import java.util.Scanner;

public class StudentMenu {
    private Student student;

    public StudentMenu(Student student){
        this.student = student;
    }

    Scanner scanner = new Scanner(System.in);
    CourseService courseService = CourseService.getInstance();

    //Menu for the student to interact with their courses
    public void displayMenu(){
        boolean studentMenuActive = true;
        while(studentMenuActive){
            System.out.println("Welcome " + student.getName() + " what would you like to do?");
            System.out.println("1 - View Assigned Courses ");
            System.out.println("2 - Course Menu");
            System.out.println("0 - Exit");

            int studentMenuChoice = scanner.nextInt();
            scanner.nextLine();

            //Print the array list of courses
            switch(studentMenuChoice){
                case 1:
                    System.out.println("Assigned Courses");
                    student.viewCourses();
                    break;
                case 2:
                    System.out.println("Course Menu");
                    System.out.println("Please select a course ");

                    //Loop throught the courses that the student has
                    int selectedCourseID = student.returnCourseId();

                    //Grab the course from the course selection service
                    Course currentCourse = courseService.getCourseById(selectedCourseID);

                    //Print to make sure it works
                    System.out.println("You have selected " + currentCourse.getCourseId() + " "+ currentCourse.getName());
                    break;
                case 0:
                    System.out.print("Exit");
                    studentMenuActive = false;
                    break;
            }
        }
    }

}
