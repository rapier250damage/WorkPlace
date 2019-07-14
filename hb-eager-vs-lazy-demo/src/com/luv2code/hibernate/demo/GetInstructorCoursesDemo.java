package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			

			session.beginTransaction();
			
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("Air guitar");
			Course tempCourse2 = new Course("the pinball masterclass");
			
			theInstructor.add(tempCourse1);
			theInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
