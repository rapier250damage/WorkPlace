package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class MoreCourrsesForStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			
//			int theId = 2;
			int theId = 1;
			
			Student theStudent = session.get(Student.class, theId);
			
			System.out.println(theStudent.getCourses());
			session.delete(theStudent);
			
//			Course theCourse1 = new Course("the first course");
//			Course theCourse2 = new Course("the second course");
//			
//			theCourse1.addStudent(theStudent);
//			theCourse2.addStudent(theStudent);
//			
//			session.save(theCourse1);
//			session.save(theCourse2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
