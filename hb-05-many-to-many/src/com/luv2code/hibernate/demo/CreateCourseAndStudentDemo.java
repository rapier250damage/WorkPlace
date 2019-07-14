package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course tempCourse = new Course("One more course");

			session.save(tempCourse);
			
			Student theStudent1 = new Student("John", "Doe", "mail@mail.ru");
			Student theStudent2 = new Student("Mark", "Fin", "mail@gmail.com");
//			Student theStudent3 = new Student("Rob", "List", "mail@hh.ru");
			
			tempCourse.addStudent(theStudent1);
			tempCourse.addStudent(theStudent2);
			session.save(theStudent1);
			session.save(theStudent2);
			
			System.out.println(tempCourse.getStudents());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
