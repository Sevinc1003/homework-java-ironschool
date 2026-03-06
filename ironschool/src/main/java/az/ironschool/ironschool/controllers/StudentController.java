package az.ironschool.ironschool.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import az.ironschool.ironschool.entities.Student;
import az.ironschool.ironschool.services.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController("/students")
public class StudentController {

    private static StudentService studentService;


    @PostMapping("/enroll")
    public void enroll(@RequestParam String studentId, @RequestParam String courseId) {
        studentService.enroll(studentId, courseId);
        
    
    }
    

    @GetMapping("/show-all")
    public List<Student> showAll(){
        return studentService.showStudents();
    }

    // public Student lookupCourse(String studentId) {
    //     return students.get(studentId);
    // }


    



}
