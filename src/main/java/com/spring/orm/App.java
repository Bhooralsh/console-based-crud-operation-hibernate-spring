package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
       StudentDaoImpl studentDao= context.getBean("studentDaoImpl",StudentDaoImpl.class);
    	
		/*
		 * Student student = new Student(2325,"Salman","Pakistan"); int
		 * r=studentDao.insert(student); System.out.println(r);
		 */
       boolean go = true;
       	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	while(go) {
       	System.out.println("Press 1 for add new student");
       	System.out.println("Press 2 for display all student");
       	System.out.println("Press 3 for get detail of single  student");
       	System.out.println("Press 4 for delete  student");
       	System.out.println("Press 5 for update student");
       	System.out.println("Press 6 for exist");
       	
       	try {
       	
       		int input=Integer.parseInt(br.readLine());
       		switch (input) {
       		
       		case 1:
       				
       			System.out.println("Enter user id");
       			int uId=Integer.parseInt(br.readLine());
       			System.out.println("enter username");
       			String uName=br.readLine();
       			System.out.println("Enter your city");
       			String uCity=br.readLine();
       			
       			Student s=new Student();
       			s.setStudentId(uId);
       			s.setStudentName(uName);
       			s.setStudentCity(uCity);
       			
       			int r=studentDao.insert(s);
       			System.out.println(r+" student added");
       			System.out.println("************************************");
       			//add new student
       		 break;
       		 
       		case 2:
       			//display all student
       			List<Student>student=studentDao.getAllStudent();
       			for(Student s1:student) {
       				
       			System.out.println("ID :"+s1.getStudentId());	
       			System.out.println("Name :"+s1.getStudentName());
       			System.out.println("City :"+s1.getStudentCity());


       			
       			}
       			System.out.println("************************************");

       		break;
       		case 3:
       			
       			System.out.println("Enter user id:");
       			int userId=Integer.parseInt(br.readLine());
       			Student student1=studentDao.getStudent(userId);
       			System.out.println(student1.getStudentId());
       			System.out.println(student1.getStudentName());
       			System.out.println(student1.getStudentCity());
       			//get single student data
       		break;	
       		
       		case 4:
       			//delete student
       			System.out.println("Enter the student ID");
       			int student2 = Integer.parseInt(br.readLine());
       			studentDao.deleteStudent(student2);
       			System.out.println("student deleted successfull");
       			
       		break;
       		case 5:
       			//update the student
       			System.out.println("Enter the student ID");
       			int id3 =Integer.parseInt(br.readLine());
       			System.out.println("Enter the student Name");
       			String name =br.readLine();
       			System.out.println("enter the city");
       			String city=br.readLine();
       			Student obj = new Student();
       			obj.setStudentId(id3);
       			obj.setStudentName(name);
       			obj.setStudentCity(city);
       			studentDao.updateStudent(obj);
       			
       			
       		break;
       	
       		case 6:
       			go=false;
       		break;
       		
       		}
       	}
       	catch(Exception e)
       	{
       		System.out.println("Invalid input Try with another one!");
       		System.out.println(e.getMessage());
       	
       	}
       	
     	}
     	
     	System.out.println("Thankyou using my application");
       	
       		
       	
       	
    
    
    }
}
