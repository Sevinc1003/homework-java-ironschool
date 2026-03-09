package az.ironschool.ironschool.entities;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Course {

    private String courseId;

    @NotBlank(message = "name bos ola bilmez")
    private String name;

    @NotBlank(message = "price bos ola bilmez")
    private double price;

    private double moneyEarned;
    private Teacher teacher;
    private int sold;

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }
    public Course () {
        this.courseId = UUID.randomUUID().toString();
    }

    public String getCourseId() {
        return courseId;
    }



    //getters and setters

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

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public int getSold() {
        return sold;
    }
    public void setSold(int sold) {
        this.sold = sold;
    }



    


}
