package com.califfmcbride.classroommanagement;
import java.util.HashMap;
import java.util.Map;

//Singleton class to hold the school staff...call it with:
//SchoolStaffService staffService = SchoolStaffService.getInstance();
public class SchoolStaffService {
    private static SchoolStaffService instance;
    private Map<Integer, Teacher> teachers;

    //Use hashmap to store teacher ID as key and name as value
    private SchoolStaffService(){
        this.teachers = new HashMap<>();
    }

    public static SchoolStaffService getInstance(){
        if(instance == null){
            instance = new SchoolStaffService();
        }

        return instance;
    }

    public void addTeacher(Teacher teacher){
        if(teacher != null && !teachers.containsKey(teacher.getTeacherId())){
            teachers.put(teacher.getTeacherId(), teacher);
        }
        else{
            System.out.println("Teacher is already in the data base");
        }
    }

    public void removeTeacher(int teacherId){
        if(teachers.containsKey(teacherId)){
            teachers.remove(teacherId);
        }
        else{
            System.out.println("Teacher does not exist in the data base");
        }
    }

    public void listAllTeachers() {
        for (Teacher teacher : teachers.values()) {
            // Display teacher information
            System.out.println("Teacher ID: " + teacher.getTeacherId() + ", Name: " + teacher.getName());
            // Include additional details as required
        }
    }
}