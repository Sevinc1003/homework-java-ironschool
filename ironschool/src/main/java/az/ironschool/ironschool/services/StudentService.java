package az.ironschool.ironschool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import az.ironschool.ironschool.entities.Student;

@Service
public class StudentService {

    private static Map<String, Student> students;

    private static CourseService courseService;



    public void enroll(String studentId, String courseId) {

        for (Student student : students.values()) {

            if (student.getStudentId().equals(studentId)) {
                student.setCourse(courseService.getCourses().get(courseId));

                double coursePrice = courseService.getCourses().get(courseId).getPrice();
                double courseProfit = courseService.getCourses().get(courseId).getMoneyEarned();
                

                courseService.getCourses().get(courseId).setMoney_earned(coursePrice+ courseProfit);
            }
        }
    }

    public List<Student> showStudents() {
        return new ArrayList<>(students.values());
    }

    public Student lookupStudent(String studentId) {
        return students.get(studentId);
    }

}
