package com.Mansi.main;

import java.util.Scanner;

import com.Mansi.dao.StudentDaoInterface;
import com.Mansi.model.Student;
import com.Mansi.dao.StudentDao;
public class Client {
	
	public static void main(String[] args) {
		StudentDaoInterface dao=new StudentDao();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("---Welcome to Student Management Application---");
		
		while(true) {
			System.out.println("\n1.Add Student"+"\n2.Show All Students"+"\n3.Get Student Based On Roll No."
		                        +"\n4.Delete Student"+"\n5.Update Student"+"\n6.Exit");
			
			System.out.println("Enter Choice");
			int ch=sc.nextInt();
			switch(ch) {
			
			case 1:
				System.out.println("Add Student");
				System.out.println("Enter Student Name");
				String name=sc.next();
				System.out.println("Enter college name");
				String clgName=sc.next();
				System.out.println("Enter City");
				String city=sc.next();
				System.out.println("Enter Percentage");
				double percentage=sc.nextDouble();
				
				Student st = new Student(name, clgName, city, percentage);
				 boolean ans=dao.insertStudent(st);
				 if(ans) {
					 System.out.print("Record Inserted Sucessfully");
				 }else {
					 System.out.print("Something went wrong"); 
				 }
				
				
				
				break;
			case 2:
				System.out.println("Show All Student");
				dao.showAllStudent();
				break;
			case 3:
				System.out.println("Get Student Based On Roll No.");
				System.out.println("Enter roll number: ");
				int roll=sc.nextInt();
				boolean f=dao.showStudentById(roll);
				if(!f) {
					System.out.println("Student with this id is not available it the system  !!!");
				}
				break;
			case 4:
				System.out.println("Delete Student");
				System.out.println("Enter the roll number of the student to be deleted");
				int rollnum=sc.nextInt();
				boolean ff=dao.delete(rollnum);
				if(ff) {
					System.out.println("Deleted Successfully");
				}else {
					System.out.println("Something went wrong");
				}
				break;
			case 5:
				System.out.println("Update Student");
				System.out.println("\n1.Update name\n2.Update college name");
				System.out.println("Enter the choice");
				int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("Enter roll number: ");
					int rnum=sc.nextInt();					
					System.out.println("Enter new name: ");
					String sname=sc.next();
					Student std=new Student();
					std.setName(sname);
					boolean flag=dao.update(rnum, sname,choice, std);
					if(flag) {
						System.out.println("Updated successfully");
					}else {
						System.out.println("Something went wrong");
					}
					
					
				}else if(choice==2) {
					System.out.println("Enter roll number: ");
					int rnum=sc.nextInt();					
					System.out.println("Enter new College name: ");
					String Cname=sc.next();
					Student std=new Student();
					std.setClgName(Cname);
					boolean flag=dao.update(rnum, Cname,choice, std);
					if(flag) {
						System.out.println("Updated successfully");
					}else {
						System.out.println("Something went wrong");
					}
					
				}
				break;
			case 6:
				System.out.println("Thank You For Using This Application");
				System.exit(0);
			default:
				System.out.println("Please Enter A Valid Choice");
			}
		}
		
	}

}
