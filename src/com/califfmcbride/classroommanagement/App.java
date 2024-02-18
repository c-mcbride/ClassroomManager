package com.califfmcbride.classroommanagement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to ClassroomManager - Please Select and Option");
        System.out.println("1 - Create an admin ");
        System.out.println("2 - Teacher Log In");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int mainChoice = scanner.nextInt();
        scanner.nextLine(); //Consume the remaining newline

        switch(mainChoice){
            //Admin case
            case 1:
              System.out.println("Please enter admin name: ");
              String adminName = scanner.nextLine();

              System.out.println("Enter adminId: ");
              int adminId = scanner.nextInt();
              scanner.nextLine();

              //Construct admin object
              Admin admin = new Admin(adminName, adminId);
              boolean adminMenuActive = true;
              System.out.println("-------------------------------------");
              System.out.println("\n");

              while(adminMenuActive){
                System.out.println("Welcome " + adminName + " what would you like to do?");
                System.out.println("1 - Add a teacher");
                System.out.println("2 - Add a course");
                System.out.println("0 - Exit");

                int adminMenuChoice = scanner.nextInt();
                scanner.nextLine();

                switch(adminMenuChoice){
                    case 1:
                        System.out.println("Add a teacher");

                        System.out.print("Enter teacher Id: ");
                        int teacherId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the teachers name: ");
                        String teacherName = scanner.nextLine();

                        System.out.print("Enter the teachers email: ");
                        String teacherEmail = scanner.nextLine();

                        Teacher teacher = new Teacher(teacherId, teacherName, teacherEmail);
                        admin.addTeacher(teacher);
                        break;
                    case 2:
                        System.out.println("Create a course");
                        System.out.println("Please enter course ID");
                        int courseId= scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter the course name");
                        String courseName = scanner.nextLine();

                        System.out.println("Enter course description");
                        String courseDescription = scanner.nextLine();

                        //Find the teacher from the list and enter it
                        Course course = new Course(courseId, courseName, courseDescription, null);
                        admin.printTeacherList();
                        System.out.println("Select a teacher to assign (enter teacher ID): ");
                        int selectedTeacherId = scanner.nextInt();
                        scanner.nextLine();

                        //Find the selected teacher
                        Teacher selectedTeacher = admin.findTeacherById(selectedTeacherId);
                        if(selectedTeacher != null){
                            admin.addCourseToTeacher(selectedTeacher, course);
                        }
                        else{
                            System.out.println("Teacher not found");
                        }

                    case 0:
                        adminMenuActive = false;
                        break;
                }
            }
        }
    }
}
