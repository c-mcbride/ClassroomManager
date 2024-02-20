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

              boolean adminMenuActive = true;
              System.out.println("-------------------------------------");

              while(adminMenuActive){
                System.out.println("Welcome " + adminName + " what would you like to do?");
                System.out.println("1 - Add a teacher");
                System.out.println("2 - Add a course");
                System.out.println("3 - Add a student");
                System.out.println("4 - Add a student to a course");
                System.out.println("5 - View Students Enrolled in Course");
                System.out.println("0 - Exit");

                int adminMenuChoice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("-------------------------------------");

                switch(adminMenuChoice){
                    case 1:
                        System.out.println("Add a teacher");
                        validInput = false;
                        int teacherId = -1;

                        //We need to make sure the user enters a number for teacher id
                        while(!validInput){
                            System.out.print("Enter teacher Id: ");
                            if(scanner.hasNextInt()){
                                teacherId = scanner.nextInt();
                                scanner.nextLine();
                                validInput = true;
                            }
                            else{
                                System.out.println("Please enter a non-demical number for teacher input");
                                scanner.nextLine();
                            }
                        }

                        System.out.print("Enter the teachers name: ");
                        String teacherName = scanner.nextLine();

                        System.out.print("Enter the teachers email: ");
                        String teacherEmail = scanner.nextLine();

                        //We create a teacher object and add the teacher to the staffService instance
                        Teacher teacher = new Teacher(teacherId, teacherName, teacherEmail);
                        staffService.addTeacher(teacher);
                        System.out.println("-------------------------------------");
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
                        System.out.println("-------------------------------------");

                        staffService.listAllTeachers();
                        System.out.println("Select a teacher to assign (enter teacher ID): ");
                        int selectedTeacherId = scanner.nextInt();
                        scanner.nextLine();

                        //Find the selected teacher
                        Teacher selectedTeacher = staffService.findTeacherById(selectedTeacherId);

                        //Create course object and add the teacher to it
                        Course course = new Course(courseId, courseName, courseDescription, selectedTeacher);
                        //Add course to CourseService
                        courseService.addCourse(course);

                        if(selectedTeacher != null){
                            admin.addCourseToTeacher(selectedTeacher, course);
                        }
                        else{
                            System.out.println("Teacher not found");
                        }
                        System.out.println("-------------------------------------");
                        break;
                    case 3:
                        System.out.println("Add a student");
                        validInput = false;
                        int studentId = -1;

                        while(!validInput){
                            System.out.print("Enter student Id");
                            if(scanner.hasNextInt()){
                                studentId = scanner.nextInt();
                                scanner.nextLine();
                                validInput = true;
                            }
                            else{
                                System.out.println("Please enter a non-decimal number for student Id");
                                scanner.nextLine();
                            }
                        }

                        System.out.print("Enter the students name: ");
                        String studentName = scanner.nextLine();

                        System.out.print("Enter the students email: ");
                        String studentEmail = scanner.nextLine();

                        Student student = new Student(studentName, studentId, studentEmail);
                        studentDirectory.addStudent(student);
                        System.out.println("-------------------------------------");
                        break;

                    case 4:
                        System.out.println("Add a student to course");
                        studentDirectory.listAllStudents();
                        System.out.println("Select a student to assign (enter student ID): ");
                        studentId = scanner.nextInt();
                        scanner.nextLine();

                        //Find the selected student
                        Student selectedStudent = studentDirectory.getStudentById(studentId);

                        //Select course that you would like to add student to
                        System.out.println("Please select a course to add the student to");
                        courseService.listCourses();
                        System.out.println("-------------------------------------");
                        System.out.println("Enter course Id");
                        courseId = scanner.nextInt();
                        scanner.nextLine();

                        //Now retrieve the course object and add the student to it
                        course = courseService.getCourseById(courseId);
                        course.addStudent(selectedStudent);
                        System.out.println("-------------------------------------");
                        break;
                    case 5:
                        System.out.println("View students enrolled in course");
                        courseService.listCourses();

                        //Locate the course object and print the students
                        System.out.println("Enter the course Id for the course you want to see");
                        courseId = scanner.nextInt();
                        scanner.nextLine();

                        course = courseService.getCourseById(courseId);
                        course.listStudents();
                        System.out.println("-------------------------------------");
                        break;
                    case 0:
                        adminMenuActive = false;
                        break;
                }
            }
        }
    }
}
