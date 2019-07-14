package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Review;
import com.luv2code.hibernate.demo.entiry.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {
			
			session.beginTransaction();
			
//			Course tempCourse = new Course("One more course");
//			
//			tempCourse.add(new Review("Great course"));
//			tempCourse.add(new Review("Awesome"));
//			tempCourse.add(new Review("Bad"));
			int theId = 15;
			
			Course theCourse = session.get(Course.class, theId);
			
			System.out.println(theCourse.getReviews());
			
			session.delete(theCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
