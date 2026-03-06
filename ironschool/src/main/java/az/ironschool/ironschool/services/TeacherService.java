package az.ironschool.ironschool.services;

import az.ironschool.ironschool.entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public void put(String teacherId, Teacher teacher) {
    }
}
