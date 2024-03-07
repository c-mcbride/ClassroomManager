package com.califfmcbride.classroommanagement;
import java.util.HashMap;
import java.util.Map;


//This class holds all of the courses for the school. Is a singleton so that all callers share the same state
public class CourseService {
    private static CourseService instance;
    private Map<Integer, Course> courses; //Hash map to hold the courses at the school

    private CourseService(){
        this.courses = new HashMap<>();
    }

    public static CourseService getInstance(){
        if(instance == null){
            instance = new CourseService();
        }

        return instance;
    }

    public void addCourse(Course course){
       //check for the existince of course in the list
       if(course != null && !courses.containsKey(course.getCourseId())){
        courses.put(course.getCourseId(), course);
       }
       else{
        System.out.println("This course has already been created!");
       }
    }

    public void removeCourse(int courseId){
        if(courses.containsKey(courseId)){
            courses.remove(courseId);
        }
        else{
            System.out.println("The course does not exist")
        }
    }

    public void listCourses(){
        for(Course course : courses.values()){
            System.out.println("Couse ID: " + course.getCourseId());
            System.out.println("Course Name: " + course.getName());
            System.out.println("-------------------------------------");
        }
    }

    //Return course object
    public Course getCourseById(int courseId){
        if(courses.containsKey(courseId)){
            Course course = courses.get(courseId);
            return course;
        }
        else{
            return null;
        }
    }

    //Used for input protection to make sure the course exists
    public Boolean courseExists(int courseId){
        if(courses.containsKey(courseId)){
            return true;
        }

        return false;
    }
}
