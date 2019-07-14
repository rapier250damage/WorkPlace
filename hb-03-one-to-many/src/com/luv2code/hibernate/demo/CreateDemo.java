package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code.com", "luv 2 code");
			Instructor tempInstructor = new Instructor("Mary", "Girl", "mary@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "guitar");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			session.save(tempInstructor); 
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
