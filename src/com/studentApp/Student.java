
package com.studentApp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Student {
	
	/* instance variable are stored in heap memory and initialized with default values*/
	private String name;//Non-Primitive data Type- default value -Null
	private int age;//Primitive data Type- default value -0
	private String studentId;//Non-Primitive data Type- default value -Null
	private List<String> courses;//Non-Primitive data Type- default value -Null


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getStudentId() {
		return studentId;
	}


	public List<String> getCourses() {
		return courses;
	}
	
	public Student(String name, int age, String studentId )
	{
		super();
		
		if(validateAge(age) && validateName(name) && validateStudentId(studentId))
		{
			this.name=name;
			this.age=age;
			this.studentId=studentId;
			courses=new ArrayList<String>();
		}
		
	}

	
	public void enrollCourse(String course)
	{
		
//		courses=new ArrayList<String>();
		
		//Array List can have duplicate value - Hence its non-idempotent
		
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to the course " + course + " successfully ");

			} else {
				System.err.println("Student has already enrolled to Course "+course);
			}
		}
		
		
		
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	
	public void printStudentInfo()
	{
		System.out.println("Student name is "+name);
		System.out.println("Student age is "+age);
		System.out.println("Student ID is "+studentId);
		System.out.println("Student courses is "+courses);
	}
	
	
	public boolean validateAge(int age)
	{
		if(age>=19 && age<=35)
		{
			return true;
		}
		else
		{
			
			System.err.println("Invalid age ");
			return false;
		}
	}
	
	public boolean validateName(String Name)
	{
		
		String pattern="^[a-zA-Z\\s]+$";
		
		Pattern namePattern=Pattern.compile(pattern);
		Matcher nameMatcher=namePattern.matcher(Name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			
			System.err.println("Please Enter Alphabets Only");
			return false;
		}
			
		
	}
	
	public boolean validateStudentId(String studentId)
	{
		
//		String pattern="S-[0-9]+$";
		String pattern="S-\\d+$";
		
		Pattern studentIdPattern=Pattern.compile(pattern);
		Matcher studentIdMatcher=studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			
			System.err.println("Invalid Student ID");
			return false;
		}
			
		
	}
	
	
	public boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Python") || course.equalsIgnoreCase("Devops") )
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Couse name!! Try to select course name from list [Java, Python, Devops]");
			return false;
		}
	}
	
	


}
