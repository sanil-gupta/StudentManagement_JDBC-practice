package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
	  System.out.println("Welcome to Student Mangement App");
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  while(true)
	  {
		  System.out.println("PRESS 1 to ADD student");
		  System.out.println("PRESS 2 to DELETE student");
		  System.out.println("PRESS 3 to DISPLAY student");
		  System.out.println("PRESS 4 to UPDATE student");
		  System.out.println("PRESS 5 to EXIT App");
		  int c = Integer.parseInt(br.readLine());
		  if(c == 1)
		  {
			  //add student..
			  System.out.println("Enter username :");
			  String name = br.readLine();
			  
			  System.out.println("Enter user phone :");
			  String phone = br.readLine();
			  
			  System.out.println("Enter user city :");
			  String city = br.readLine();
			  
			  //create student obj..
			  Student st = new Student(name,phone,city);
			  boolean ans =  studentDao.insertStudentToDB(st);
			  if(ans)
				  System.out.println("Data insert Successfully ");
			  else
				 System.out.println("Oops..something went wrong ");
		  }
		  else if(c == 2)
		  {
			  //delete student..
			  System.out.println("Enter Student ID :");
			  int userId = Integer.parseInt(br.readLine());
			  boolean ans = studentDao.deleteStudent(userId);
			  if(ans)
				  System.out.println("Data Deleted Successfully ");
			  else
				 System.out.println("Oops..something went wrong ");
			  
		  }
		  else if(c == 3)
		  {
			  //display student...
			  studentDao.showStudent();
		  }
		  else if(c == 4)
		  {
			  //update student...
			  System.out.println("Enter the ID of Student");
			  int sid = Integer.parseInt(br.readLine());
			  System.out.println("Enter the new name of student");
			  String name = br.readLine();
			  System.out.println("Enter the new phone number");
			  String phone = br.readLine();
			  System.out.println("Enter the new city");
			  String city = br.readLine();
			  
			  Student st = new Student(sid,name,phone,city);
			
			  
			  boolean ans = studentDao.updateStudent(st,sid);
			   
			  if(ans)
			  {
				  System.out.println("Data Update Successfully.......!");
			  }
			  else
			  {
				  System.out.println("Oops..something went wrong");
			  }	  
		  }
		  else if(c == 5)
		  {
			  break;
		  }
	  }
	  System.out.println("Thank you for using the App");
	}

}
