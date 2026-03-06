package az.ironschool.ironschool.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.services.TeacherService;

@RestController("/teachers")
public class TeacherController {
    private static TeacherService service;



    @GetMapping("/all-teachers")
    public List<Teacher> showTeachers(){
        return service.showTeachers();
    }


    @GetMapping("/teacher/{id}")
    public Teacher lookupTeacher(@PathVariable String teacherId){

        return service.lookupTeacher(teacherId);

    }


}
