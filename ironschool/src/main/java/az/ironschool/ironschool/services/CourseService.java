package az.ironschool.ironschool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import az.ironschool.ironschool.entities.Course;
import az.ironschool.ironschool.entities.Teacher;

public class CourseService {

    private static Map<String, Course> courses;

    private static TeacherService teacherService;



    public void assign(String teacherId, String courseId){

        for(Course course : courses.values()){
            if(course.getCourseId().equals(courseId)){
                course.setTeacher(teacherService.getTeachers().get(teacherId));
            }
        }
    }


    public List<Course> showCourses(){
        return new ArrayList<>(courses.values());
    }

    public Course lookupCourse(String courseId){
        return courses.get(courseId);
    }

    public double showSchoolProfit(){
       
        double coursesTotal = 0;
        double teachersTotal = 0;


        for(Teacher teacher : teacherService.getTeachers().values()){

            teachersTotal += teacher.getSalary();
        }

        for (Course course : courses.values()) {

            coursesTotal += course.getMoneyEarned();
            
        }

        
        return coursesTotal - teachersTotal;
    }


    public double courseProfit(String courseId){

        Course course = courses.get(courseId);
        return course.getMoneyEarned() - course.getPrice();
    }



// getter and setter
    public Map<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Course> courses) {
        CourseService.courses = courses;
    }

    

}
