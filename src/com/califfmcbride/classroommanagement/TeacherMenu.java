package com.califfmcbride.classroommanagement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Here we have the teacher menu class. All it needs is the teacher object to function
public class TeacherMenu {
    private Teacher teacher;

    public TeacherMenu(Teacher teacher){
        this.teacher = teacher;
    }

    Scanner scanner = new Scanner(System.in);
    CourseService courseService = CourseService.getInstance();

    public void displayMenu(){
        boolean teacherMenuActive = true;
        while(teacherMenuActive){
            System.out.println("Welcome " + teacher.getName() + " what would you like to do? ");
            System.out.println("1 - View Assigned Courses ");
            System.out.println("2 - Course Menu");
            System.out.println("0 - Exit");

            int teacherMenuChoice = scanner.nextInt();
            scanner.nextLine();

            switch(teacherMenuChoice){
                case 1:
                    System.out.print("Assigned Courses");

                    //Print all the courses in the teacher's hashmap
                    this.teacher.listTeachersCourses();
                    break;
                //Here the teacher will be able to view assignments, add assignments etc for courses
                case 2:
                    boolean courseMenuActive = true;
                    System.out.println("Course Menu ");
                    System.out.println("Which course would you like to view? Enter course ID ");
                    int selectedCourse = scanner.nextInt();
                    scanner.nextLine();

                    //Once we find the course we need to assign it to an object
                    Course currentCourse = courseService.getCourseById(selectedCourse);

                    //menu runs for the course operation screen
                    while(courseMenuActive){
                        System.out.println(currentCourse.getName());
                        System.out.println("1 - View Student Roster");
                        System.out.println("2 - Add Assignment");
                        System.out.println("0 - Exit");

                        int courseMenuChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch(courseMenuChoice){
                            case 1:
                                currentCourse.listStudentsInCourse();
                                break;
                            case 2:
                                System.out.println("Add Assignment to Course");

                                //Get all of the relevant information for the assignment
                                System.out.println("Assignment title: ");
                                String assignmentTitle = scanner.nextLine();

                                System.out.println("Enter description for assignment");
                                String description = scanner.nextLine();

                                System.out.println("Enter the due date (yyyy-MM-dd): ");
                                String dateString = scanner.nextLine();

                                //Get date and make sure it is a date time object
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = null;
                                try{
                                     date = formatter.parse(dateString);
                                }catch(ParseException e){
                                    System.out.println("Invalid date format.")
                                }

                                System.out.println("Enter Assignment Id: ");
                                int assignmentId = scanner.nextInt();
                                scanner.nextLine();

                                Assignment assignment = new Assignment(assignmentTitle, description,  date, assignmentId);

                            case 0:
                                courseMenuActive = false;
                        }
                    }
                case 0:
                    System.out.println("------Exit---------");
                    teacherMenuActive = false;
            }
        }
    }
}
