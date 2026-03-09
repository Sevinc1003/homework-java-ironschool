package az.ironschool.ironschool.services;

import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.utils.Logging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherService {
    private static Map<String, Teacher> teachers;



    public List<Teacher> showTeachers() {

        Logging.log("list of teachers returned");

        return new ArrayList<>(teachers.values());
    }

    public Teacher lookupTeacher(String teacherId) {

        Logging.log("teacher named "+ teachers.get(teacherId).getName() +" looked up");

        return teachers.get(teacherId);
    }


    //getter and setter
    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public TeacherService() {
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        TeacherService.teachers = teachers;
    }

    public void changeSalary(String id, double newSalary){
        teachers.get(id).setSalary(newSalary);
    }

}
