package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

	
	private static List<Student> studentObjectsList;
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		sc = new Scanner(System.in);
		studentObjectsList=new ArrayList<Student>();
		System.out.println("!!Student Management System!!");
		
		while (true) {
			System.out.println("!!Welcome!!");
			System.out.println("Select an Option ");
			System.out.println("1. Enroll a student ");
			System.out.println("2. Find student with Sudent ID ");
			System.out.println("3. List all student Information ");
			System.out.println("4. List  student Information in sorted Order ");
			System.out.println("5. Exit ");

			
			System.out.println("Enter an option");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				enrollStudent(sc);
				break;
			case 2:
				findStudentById(sc);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Please Enter a valid option");

			}
		}
		
//		System.out.println("Enter the student name ");
//		String name=sc.next();
//		
//		Student st=new Student(name, 27, "S-1001");
//		st.enrollCourse("Java");
//		st.enrollCourse("DAS");
////		System.out.println(st);
//		
//		
//		Student st01=new Student(name, 22, "S-1002");
//		st01.enrollCourse("Devops");
//		
////		System.out.println(st01);
////		st01.printStudentInfo();
//		
//		Student st02=new Student(name, 24, "S-1003");
//		st02.enrollCourse("Python");
//		
////		System.out.println(st02);
////		st02.printStudentInfo();
//
//	
//		studentObjectsList=new ArrayList<Student>();
//		
//		studentObjectsList.add(st);
//		studentObjectsList.add(st01);
//		studentObjectsList.add(st02);
//		
//		System.out.println(findStudentById("S-1006"));
//		
//		sortByName();
		
		
	}
	
	private static void exit() {

        System.out.println("GoodBye!!! Ending session");
		System.exit(0);
		
	}

	private static void printAllStudentData() {
		
		
		
		if(studentObjectsList.size()>0)
		{
			System.out.println(">>>>>Print all student data");
			for(Student st:studentObjectsList)
			{
				st.printStudentInfo();
			}
		}
		else
		{
			System.err.println("Student list is empty");
		}
		
		
	}

	private static void findStudentById(Scanner sc2) {
		System.out.println("Enter a student id");
		String studentId=sc2.next();
		
		Student foundStudentId=findStudentById(studentId);
		
		foundStudentId.printStudentInfo();
		
	}

	private static void enrollStudent(Scanner sc2) {
		System.out.println("Enter a student name");
		String studentName=sc2.next();
		
		System.out.println("Enter a student age");
		int studentAge=sc2.nextInt();
		
		System.out.println("Enter a student id");
		String studentId=sc2.next();
		
		Student st=new Student(studentName,studentAge,studentId);
		studentObjectsList.add(st);
		
		
		while (true) {
			System.out.println("Enter a course to be enrolled!!...Type done to exit");
			String courseName = sc2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;
			}
			st.enrollCourse(courseName);
		}
		
		
		st.printStudentInfo();
//		System.out.println("Student added Into LMS");
	}

	public static void sortByName() {

		
		
		
		//Using lambda expression- Helps to make your code concise and reduce the Boilder plate Code
		
		Comparator<Student> comp=(o1,o2)->o1.getName().compareTo(o2.getName());
		/*Comparator<Student> comp=new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());//Lexgraphic Comparision
			}
		};
		*/
		
		Collections.sort(studentObjectsList,comp);
		
//		System.out.println(studentObjectsList);Instead of Printing it like a list, we will call a method
		printAllStudentData();
		
	}

	public static Student findStudentById(String studentId)
	{
		
		//stObject is an Local variable , so we are intializing it Explicitly
		//Non primitive data type has default value as null
		Student stObject = null ;
		try {
			stObject= studentObjectsList.stream().filter(e -> e.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("!!No student Id found"));
		} catch (RuntimeException e2) {
			System.err.println("Student with ID "+ studentId +" not found.");
		}
		
		
		
		return stObject;
	}

}
