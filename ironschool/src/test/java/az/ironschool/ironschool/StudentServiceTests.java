package az.ironschool.ironschool;

import az.ironschool.ironschool.dtos.NewStudentDTO;
import az.ironschool.ironschool.entities.Course;
import az.ironschool.ironschool.entities.Student;
import az.ironschool.ironschool.services.CourseService;
import az.ironschool.ironschool.services.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTests {

    private StudentService studentService;
    private CourseService courseService;

    private String courseId1;
    private String studentId1;
    private String courseId2;
    private String studentId2;

    @BeforeEach
    void setUp() throws Exception {

        studentService = new StudentService();
        courseService = new CourseService();

        Map<String, Student> students = new HashMap<>();
        Map<String, Course> courses = new HashMap<>();

        Course c1 = new Course("Java", 100);
        courseId1 = c1.getCourseId();
        Course c2 = new Course("Spring", 150);
        courseId2 = c2.getCourseId();


        Student s1 = new Student("Ali", "Baku", "ali@mail.com");
        s1.setCourse(c1);
        studentId1 = s1.getStudentId(); 
        

        Student s2 = new Student("Leyla", "Baku", "leyla@mail.com");
        s2.setCourse(c2);
        studentId2 = s2.getStudentId(); 


        students.put(studentId1, s1);
        students.put(studentId2, s2);

        courses.put(courseId1, c1);
        courses.put(courseId2, c2);

        courseService.setCourses(courses);

        // idk v
        Field studentsField = StudentService.class.getDeclaredField("students");
        studentsField.setAccessible(true);
        studentsField.set(null, students);

        Field courseServiceField = StudentService.class.getDeclaredField("courseService");
        courseServiceField.setAccessible(true);
        courseServiceField.set(null, courseService);
    }


     @Test
    void registerNewStudent_createsStudent() {
        NewStudentDTO dto = new NewStudentDTO("Murad", "Baku", "murad@mail.com");
        studentService.registerNewStudent(dto);

        List<Student> studentsNew = studentService.showStudents();
        assertEquals(3, studentsNew.size()); // əvvəl 2 idi, indi 3 olmalıdır
    }

    @Test
    void enroll_assignsCourseToStudent() {
        studentService.enroll(studentId2, courseId2);
        Student student = studentService.lookupStudent(studentId2);
        assertEquals(courseId2, student.getCourse().getCourseId());
    }

    @Test
    void enroll_increasesCourseMoneyEarned() {
        Course course = courseService.getCourses().get(courseId1);
        double oldMoney = course.getMoneyEarned();
        studentService.enroll(studentId1, courseId1);
        assertTrue(course.getMoneyEarned() > oldMoney);
    }

     @Test
    void showStudents_returnsAllStudents() {
        List<Student> students = studentService.showStudents();
        assertEquals(2, students.size());
    }

    @Test
    void showStudents_listIsNotEmpty() {
        List<Student> students = studentService.showStudents();
        assertFalse(students.isEmpty());
    }

    @Test
    void lookupStudent_returnsCorrectStudent() {
        Student student = studentService.lookupStudent(studentId1);
        assertEquals("Ali", student.getName());
    }

    @Test
    void lookupStudent_studentIsNotNull() {
        Student student = studentService.lookupStudent(studentId2);
        assertNotNull(student);
    }

    @Test
    void getByCourse_returnsCorrectStudents() {
        List<Student> javaStudents = studentService.getByCourse(courseId1);
        assertEquals(1, javaStudents.size());
        assertEquals(courseId1, javaStudents.get(0).getCourse().getCourseId());
    }
}
