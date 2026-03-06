package az.ironschool.ironschool.controllers;

import az.ironschool.ironschool.services.TeacherService;

import java.util.Scanner;

public class CreateSchool {
    private static Scanner sc = new Scanner(System.in);
    private static TeacherService teacherService;

    public CreateSchool(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public static void createSchool() {
        try {
            System.out.println("Please enter a name for your school: ");
            String schoolName = sc.nextLine();

        } catch (RuntimeException e) {
            System.out.println("Error: ");
        }

        try {
            System.out.println("Enter how many teachers you want to have in your school: ");
            int teacherCount = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i < teacherCount + 1; i++) {
                az.ironschool.ironschool.entities.Teacher teacher = new az.ironschool.ironschool.entities.Teacher();
                System.out.println("Enter the name of the teacher number " + i + " : ");
                String teacherName = sc.nextLine();
                teacher.setName(teacherName);

                while (true) {
                    try {
                        System.out.println("Enter the teacher  " + teacherName + "'s salary: ");
                        double teacherSalary = sc.nextDouble();
                        teacher.setSalary(teacherSalary);
                        sc.nextLine();
                        break;
                    } catch (RuntimeException e) {
                        System.err.println("Error: wrong input type.Please enter a number that is valid");
                        sc.nextLine();
                    }
                }
                if (teacherService != null) {
                    teacherService.put(teacher.getTeacherId(), teacher);
                }

                System.out.println("Enter the subject teacher ' " + teacherName + "' teachs: ");
                String teacherSubject = sc.nextLine();
                //sc.nextLine();
                teacher.setSubject(teacherSubject);
            }
            System.out.println(" HashMap has created for teachers ");
         }catch (RuntimeException e){
        System.err.println("Error: Please enter a number.");
        sc.nextLine();
        }
    }
}
