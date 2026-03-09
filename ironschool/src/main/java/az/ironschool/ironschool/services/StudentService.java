package az.ironschool.ironschool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import az.ironschool.ironschool.dtos.NewStudentDTO;
import az.ironschool.ironschool.entities.Student;
import az.ironschool.ironschool.utils.Logging;

@Service
public class StudentService {

    private static Map<String, Student> students;

    private static CourseService courseService;

    public void registerNewStudent(NewStudentDTO dto) {
        new Student(dto.getName(), dto.getAddress(), dto.getEmail());

        Logging.log("new student registered");
    }

    public void enroll(String studentId, String courseId) {

        students.get(studentId).setCourse(courseService.getCourses().get(courseId));

        double coursePrice = courseService.getCourses().get(courseId).getPrice();
        double courseProfit = courseService.getCourses().get(courseId).getMoneyEarned();

        courseService.getCourses().get(courseId).setMoneyEarned(coursePrice + courseProfit);

        Logging.log("Student named "+  students.get(studentId).getName()+ " enrolled to "+ courseService.getCourses().get(courseId)+ " course");
    }

    public List<Student> showStudents() {

        Logging.log("list of students showed");
        return new ArrayList<>(students.values());
    }

    public Student lookupStudent(String studentId) {

        Logging.log("student named "+ students.get(studentId).getName() +" looked up");

        return students.get(studentId);
    }

    public List<Student> getByCourse(String courseId) {

        Logging.log("returned list of students who have "+ courseService.getCourses().get(courseId).getName()+" course");
        return students.values()
                .stream()
                .filter(student -> student.getCourse().getCourseId().equals(courseId))
                .toList();
    }

}
