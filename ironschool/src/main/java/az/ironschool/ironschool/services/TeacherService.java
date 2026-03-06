package az.ironschool.ironschool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import az.ironschool.ironschool.entities.Student;
import az.ironschool.ironschool.entities.Teacher;

public class TeacherService {
    private static Map<String, Teacher> teachers;



    public List<Teacher> showTeachers() {
        return new ArrayList<>(teachers.values());
    }

    public Teacher lookupTeacher(String teacherId) {
        return teachers.get(teacherId);
    }




    //getter and setter
    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        TeacherService.teachers = teachers;
    }


}
