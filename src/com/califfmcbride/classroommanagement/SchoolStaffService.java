package com.califfmcbride.classroommanagement;
import java.util.HashMap;
import java.util.Map;
//Singleton class to hold the school staff...call it with:
//SchoolStaffService staffService = SchoolStaffService.getInstance();
public class SchoolStaffService {
    private static SchoolStaffService instance;
    private Map<Integer, Teacher> teachers;
    private Map<Integer, Admin> admins;

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
            System.out.println("-------------------------------------");
        }
    }

    //We need a method to return teacher objects using the id as key
    public Teacher findTeacherById(int teacherId){
        if(teachers.containsKey(teacherId)){
            //Get the specific teacher object that matches the key if it exisists and return it
            Teacher teacher = teachers.get(teacherId);
            return teacher;
        }
        else{
            return null;
        }
    }

    //Method to add admin to the admin hashmap
    public void addAdmin(Admin admin){
        if(admin != null && !admins.containsKey(admin.getAdminId())){
            admins.put(admin.getAdminId(), admin);
        }
        else{
            System.out.println("Admin is already in the data base");
        }
    }

    public void removeAdmin(int adminId){
        if(admins.containsKey(adminId)){
            admins.remove(adminId);
        }
        else{
            System.out.println("Admin not in database");
        }
    }

    public void listAllAdmin() {
        for (Admin admin : admins.values()) {
            // Display teacher information
            System.out.println("Admin ID: " + admin.getAdminId() + ", Name: " + admin.getName());
            System.out.println("-------------------------------------");
        }
    }
}
