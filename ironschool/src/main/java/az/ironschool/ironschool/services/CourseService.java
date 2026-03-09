package az.ironschool.ironschool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import az.ironschool.ironschool.entities.Course;
import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.utils.Logging;

public class CourseService {

    private static Map<String, Course> courses;

    private static TeacherService teacherService;



    public void assign(String teacherId, String courseId){

        for(Course course : courses.values()){
            if(course.getCourseId().equals(courseId)){
                course.setTeacher(teacherService.getTeachers().get(teacherId));
                Logging.log("Teacher "+ teacherService.getTeachers().get(teacherId).getName()+ " assingned to "+ courses.get(courseId).getCourseId()+ " course");

            }
        }


    }


    public List<Course> showCourses(){

        Logging.log("courses showed");
        return new ArrayList<>(courses.values());

    }

    public Course lookupCourse(String courseId){

        Logging.log("course name "+ courses.get(courseId).getName() +" looked up");
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

        Logging.log("school's profit is: "+ (coursesTotal - teachersTotal));        
        return coursesTotal - teachersTotal;
    }


    public double courseProfit(String courseId){

        Course course = courses.get(courseId);
        Logging.log("course "+ courses.get(courseId).getName()+ "'s profit is: "+ (course.getMoneyEarned() - course.getPrice()));
        return course.getMoneyEarned() - course.getPrice();
    }

    public void deleteCourse(String id){
        Logging.log("course "+ courses.get(id).getName()+ " deleted");
        courses.remove(id);
    }


// getter and setter
    public Map<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Course> courses) {
        CourseService.courses = courses;
    }

    

}
