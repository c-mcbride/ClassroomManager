package com.califfmcbride.classroommanagement;
import java.util.Scanner;

public class AdminMenu {
    private SchoolStaffService staffService;
    private StudentDirectory studentDirectory;
    private CourseService courseService;
    private Admin admin;


    public AdminMenu(SchoolStaffService staffService, StudentDirectory studentDirectory, CourseService courseService, Admin admin) {
        this.staffService = staffService;
        this.studentDirectory = studentDirectory;
        this.courseService = courseService;
        this.admin = admin;
    }

    Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        boolean adminMenuActive = true;
        while(adminMenuActive){
            System.out.println("Welcome " + admin.getName() + " what would you like to do?");
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
                    Boolean validInput = false;
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
                    validInput = false;
                    int courseId = -1;

                    //Input protection for valid input
                    while(!validInput){
                        System.out.println("Please enter course ID");
                        if(scanner.hasNextInt()){
                            courseId = scanner.nextInt();
                            scanner.nextLine();
                            validInput = true;
                        }
                        else{
                            System.out.println("Please enter a non-decimal number for course ID ");
                            scanner.nextLine();
                        }
                    }

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
                    //TO DO: Make sure the student exists before proceeding
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

                    //Input protection for courseId
                    validInput = false;
                    courseId = -1;

                    while(!validInput){
                        System.out.println("Enter course Id: ");
                        if(scanner.hasNextInt()){
                           courseId = scanner.nextInt();

                           if(courseService.courseExists(courseId) == true){
                            validInput = true;
                            scanner.nextLine();
                           }
                           else{
                            System.out.println("That course does not exist. Try again");
                            scanner.nextLine();
                           }
                        }
                        else{
                            System.out.println("Enter a non-decimal number for courseId");
                            scanner.nextLine();
                        }
                    }
                    //Now retrieve the course object and add the student to it
                    //Also adds the course to the students list
                    course = courseService.getCourseById(courseId);
                    course.addStudent(selectedStudent);
                    selectedStudent.addCourse(course); //Add the course to the students roster
                    System.out.println("-------------------------------------");
                    break;
                case 5:
                    System.out.println("View students enrolled in course");
                    courseService.listCourses();

                    validInput = false;
                    courseId = -1;

                    //Input protection for the courseId
                    while(!validInput){
                        System.out.println("Enter the course Id for the course you want to see");
                        if(scanner.hasNextInt()){
                            courseId = scanner.nextInt();
                            scanner.nextLine();
                            validInput = true;
                        }
                        else{
                            System.out.println("Enter a non-decimal number for course Id ");
                            scanner.nextLine();
                        }
                    }

                    course = courseService.getCourseById(courseId);
                    course.listStudentsInCourse();
                    System.out.println("-------------------------------------");
                    break;
                case 0:
                    adminMenuActive = false;
                    break;
            }
        }
    }
}
