package az.ironschool.ironschool;

import az.ironschool.ironschool.entities.Teacher;
import az.ironschool.ironschool.services.TeacherService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherServiceTests {

    private TeacherService teacherService;

    private String teacherId1;
    private String teacherId2;

    @BeforeEach
    void setUp() {
        teacherService = new TeacherService();

        Map<String, Teacher> teachers = new HashMap<>();

        Teacher t1 = new Teacher("John", 2000.0);
        teacherId1 = t1.getTeacherId();

        Teacher t2 = new Teacher("Anna", 2500.0);
        teacherId2 = t2.getTeacherId();


        teachers.put(teacherId1, t1);
        teachers.put( teacherId2, t2);

        teacherService.setTeachers(teachers);
    }

    @Test
    void showTeachers_returnsAllTeachers() {

        List<Teacher> result = teacherService.showTeachers();

        assertEquals(2, result.size());
    }

    @Test
    void showTeachers_listIsNotEmpty() {

        List<Teacher> result = teacherService.showTeachers();

        assertFalse(result.isEmpty());
    }

    @Test
    void lookupTeacher_returnsCorrectTeacher() {

        Teacher teacher = teacherService.lookupTeacher(teacherId1);

        assertEquals("John", teacher.getName());
    }

    @Test
    void changeSalary_updatesSalary() {

        teacherService.changeSalary(teacherId1, 3000);

        Teacher teacher = teacherService.lookupTeacher(teacherId1);

        assertEquals(3000, teacher.getSalary());
    }

    @Test
    void changeSalary_salaryIsDifferentFromOld() {

        Teacher teacher = teacherService.lookupTeacher(teacherId1);

        double oldSalary = teacher.getSalary();

        teacherService.changeSalary(teacherId1, 4000);

        assertNotEquals(oldSalary, teacher.getSalary());
    }

}
