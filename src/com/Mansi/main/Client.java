package com.Mansi.main;

import java.util.Scanner;

import com.Mansi.dao.StudentDao;
import com.Mansi.dao.StudentDaoInterface;
import com.Mansi.model.Student;

public class Client {

    public static void main(String[] args) {
        StudentDaoInterface dao = new StudentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome to Student Management Application---");

        while (true) {
            System.out.println("\n1.Add Student\n2.Show All Students\n3.Get Student\n4.Delete\n5.Update\n6.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter Roll Number:");
                    int roll = sc.nextInt();

                    System.out.println("Enter Name:");
                    String name = sc.next();

                    System.out.println("Enter College:");
                    String clg = sc.next();

                    System.out.println("Enter City:");
                    String city = sc.next();

                    System.out.println("Enter Percentage:");
                    double per = sc.nextDouble();

                    Student st = new Student(roll, name, clg, city, per);

                    if (dao.insertStudent(st))
                        System.out.println("Inserted Successfully");
                    else
                        System.out.println("Error");

                    break;

                case 2:
                    dao.showAllStudent();
                    break;

                case 3:
                    System.out.println("Enter Roll:");
                    int r = sc.nextInt();
                    if (!dao.showStudentById(r))
                        System.out.println("Not Found");
                    break;

                case 4:
                    System.out.println("Enter Roll to delete:");
                    int d = sc.nextInt();
                    dao.delete(d);
                    break;

                case 5:
                    System.out.println("1.Update Name\n2.Update College");
                    int choice = sc.nextInt();

                    System.out.println("Enter Roll:");
                    int ur = sc.nextInt();

                    System.out.println("Enter New Value:");
                    String val = sc.next();

                    dao.update(ur, val, choice, new Student());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
