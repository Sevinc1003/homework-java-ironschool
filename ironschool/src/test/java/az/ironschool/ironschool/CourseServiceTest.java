package az.ironschool.ironschool;

import az.ironschool.ironschool.entities.Course;
import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.services.CourseService;
import az.ironschool.ironschool.services.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {

    private CourseService courseService;
    private TeacherService teacherService;

    
    private String teacherId1;
    private String teacherId2;
    private String courseId1;
    private String courseId2;


    @BeforeEach
    void setUp() {
        teacherService = new TeacherService();
        Map<String, Teacher> teachers = new HashMap<>();
        Teacher t1 = new Teacher("John","Geography",2000);
        Teacher t2 = new Teacher("Anna","Math", 2500);
                teacherId2 = t2.getTeacherId();
        teacherId1 = t1.getTeacherId();

        teachers.put(teacherId1, t1);
        teachers.put(teacherId2, t2);
        teacherService.setTeachers(teachers);

        courseService = new CourseService(teacherService);
        Map<String, Course> courses = new HashMap<>();
        Course c1 = new Course("Java",100);
        courseId1 = c1.getCourseId();        
        courses.put(courseId1, c1);

        Course c2 = new Course("Spring",150);
        courseId2 = c2.getCourseId();
        courses.put(courseId2, c2);
        courseService.setCourses(courses);
    }

    @Test
    void assign_teacherAssignedToCourse() {
        courseService.assign(teacherId1, courseId1);
        assertEquals("John", courseService.getCourses().get(courseId1).getTeacher().getName());
    }

    @Test
    void showCourses_returnsAllCourses() {
        List<Course> courses = courseService.showCourses();
        assertEquals(2, courses.size());
    }

    @Test
    void lookupCourse_returnsCorrectCourse() {
        Course course = courseService.lookupCourse(courseId2);
        assertEquals("Spring", course.getName());
    }

    @Test
    void showSchoolProfit_calculatesCorrectly() {
        courseService.getCourses().get(courseId1).setMoneyEarned(500);
        courseService.getCourses().get(courseId2).setMoneyEarned(700);

        double profit = courseService.showSchoolProfit();
        // courses total = 1200, teachers total = 4500
        assertEquals(1200 - (2000 + 2500), profit);
    }

    @Test
    void courseProfit_returnsCorrectProfit() {
        Course course = courseService.getCourses().get(courseId1);
        course.setMoneyEarned(300);
        double profit = courseService.courseProfit(courseId1);
        assertEquals(300 - 100, profit);
    }

    @Test
    void deleteCourse_removesCourse() {
        courseService.deleteCourse(courseId2);
        assertFalse(courseService.getCourses().containsKey(courseId2));
    }
}