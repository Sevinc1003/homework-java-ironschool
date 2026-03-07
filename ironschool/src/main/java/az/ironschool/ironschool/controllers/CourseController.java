package az.ironschool.ironschool.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.ironschool.ironschool.entities.Course;
import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.services.CourseService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController("/courses")
public class CourseController {

    private static CourseService courseService;

    @PutMapping("/assign")
    public void assign(@RequestParam String teacherId, @RequestParam String courseId){
        courseService.assign(teacherId, courseId);
    }


    @GetMapping("/get-all")
    public List<Course> showCourses(){
        return courseService.showCourses();
    }



    @GetMapping("/lookup/{id}")
    public Course lookupCourse(@PathVariable String courseId){
        return courseService.lookupCourse(courseId);
    }

    @GetMapping("/show-total-profit")
    public double showSchoolProfit(){
        return courseService.showSchoolProfit();
    }

    @GetMapping("/profit")
    public double courseProfit(@RequestParam String courseId) {
        return courseService.courseProfit(courseId);
    }
    

}
