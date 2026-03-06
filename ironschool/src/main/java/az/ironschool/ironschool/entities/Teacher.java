package az.ironschool.ironschool.entities;

import java.util.UUID;

public class Teacher {

    private String teacherId;
    private String name;
    private double salary;
    private String subject;
    
    public Teacher(String name, double salary) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }

    public Teacher () {
        this.teacherId = UUID.randomUUID().toString();
    }

    public String getTeacherId() {
        return teacherId;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    




}
