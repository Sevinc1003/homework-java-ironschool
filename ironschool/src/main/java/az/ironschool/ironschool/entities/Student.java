package az.ironschool.ironschool.entities;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Student {


    private String studentId;

    @NotBlank(message = "name bos ola bilmez")
    private String name;

    @NotBlank(message = "address bos ola bilmez")
    private String address;

    @NotBlank(message = "email bos ola bilmez")
    private String email;

    private Course course;

    public Student(String name, String address, String email) {
        this.studentId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.email = email;
    }
    public Student () {
        this.studentId = UUID.randomUUID().toString();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    
    

}
