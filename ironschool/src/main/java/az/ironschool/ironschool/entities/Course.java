package main.java.az.ironschool.ironschool.entities;

import java.util.UUID;

public class Course {

    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;
    private int pageCount;

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getCourseId() {
        return courseId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    


}
