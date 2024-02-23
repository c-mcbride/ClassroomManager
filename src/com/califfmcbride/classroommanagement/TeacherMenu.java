package com.califfmcbride.classroommanagement;
import java.util.Scanner;

//Here we have the teacher menu class. All it needs is the teacher object to function
public class TeacherMenu {
    private Teacher teacher;

    public TeacherMenu(Teacher teacher){
        this.teacher = teacher;
    }

    Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        boolean teacherMenuActive = true;
        while(teacherMenuActive){
            System.out.println("Welcome " + teacher.getName() + " what would you like to do? ");
            System.out.println("1 - View Assigned Courses ");
            System.out.println("0 - Exit");

            int teacherMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch(teacherMenuChoice){
                case 1:
                    System.out.print("Assigned Courses");

                    //Print all the courses in the teacher's hashmap
                    this.teacher.listTeachersCourses();
                case 2:
                    System.out.println("------Exit---------");
                    teacherMenuActive = false;
            }
        }
    }
}
