package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class ReadStudentDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			System.out.println("Create new student object");
			
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
			
			
			System.out.println("id: " + tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n getting student");
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("get complete: " + myStudent);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
