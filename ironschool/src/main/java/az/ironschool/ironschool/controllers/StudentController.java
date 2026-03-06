package az.ironschool.ironschool.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import az.ironschool.ironschool.entities.Student;

@RestController
public class StudentController {


    // public void enroll(String studentId, String courseId) {

    //     for (Student student : students.values()) {

    //         if (student.getStudentId().equals(studentId)) {
    //             student.setCourse(courseService.getCourses().get(courseId));

    //             double coursePrice = courseService.getCourses().get(courseId).getPrice();
    //             double courseProfit = courseService.getCourses().get(courseId).getMoney_earned();
                

    //             courseService.getCourses().get(courseId).setMoney_earned(coursePrice+ courseProfit);
    //         }
    //     }
    // }


 

    // public List<Student> showStudents() {
    //     return new ArrayList<>(students.values());
    // }

    // public Student lookupCourse(String studentId) {
    //     return students.get(studentId);
    // }



}
