package com.califfmcbride.classroommanagement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean mainMenuActive = true;

        while(mainMenuActive){
            System.out.println("Welcome to ClassroomManager - Please Select and Option");
            System.out.println("1 - Create an admin ");
            System.out.println("2 - Teacher Log In");
            System.out.println("0 - Exit");

            Scanner scanner = new Scanner(System.in);
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); //Consume the remaining newline

            //Get the instance of all the singletons
            SchoolStaffService staffService = SchoolStaffService.getInstance();
            StudentDirectory studentDirectory = StudentDirectory.getInstance();
            CourseService courseService = CourseService.getInstance();

            System.out.println("-------------------------------------");
            switch(mainChoice){
                //Admin case
                case 1:
                System.out.println("Please enter admin name: ");
                String adminName = scanner.nextLine();

                boolean validInput = false;
                int adminId = -1;

                //Input validation to make sure they enter a number
                while(!validInput){
                    System.out.print("Enter admin Id: ");
                    if(scanner.hasNextInt()){
                        adminId = scanner.nextInt();
                        scanner.nextLine();
                        validInput = true;
                    }
                    else{
                        System.out.println("Please enter a non-demical number for adminId input");
                        scanner.nextLine();
                    }
                }

                //Construct admin object
                Admin admin = new Admin(adminName, adminId);

                //Add the admin to the hashmap
                staffService.addAdmin(admin);
                System.out.println("-------------------------------------");

                //Call the admin menu and pass in the staffService, studentDirectory, courseService, admin
                AdminMenu adminMenu = new AdminMenu(staffService, studentDirectory, courseService, admin);
                adminMenu.displayMenu();
                break;
                //Teacher menu
                case 2:
                System.out.println("Teacher Menu");

                //We need to retrive the teacher object from Staffservice and pass that object to the teacher menu class
                System.out.println("Which teacher are you? ");
                staffService.listAllTeachers();

                System.out.print("Please enter the teacher ID");
                int teacherId = scanner.nextInt();
                scanner.nextLine();

                Teacher currentTeacher = staffService.findTeacherById(teacherId);
                //Once we have teacher object we can pass it to the TeacherMenu class
                TeacherMenu teacherMenu = new TeacherMenu(currentTeacher);
                teacherMenu.displayMenu();
                break;

                case 0:
                System.out.println("-----Exit------");
                mainMenuActive = false;
                break;
            }
        }
    }
}
