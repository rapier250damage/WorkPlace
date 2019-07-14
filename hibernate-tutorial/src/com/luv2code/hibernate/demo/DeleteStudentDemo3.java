package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class DeleteStudentDemo3 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
	
		try {			
			session.beginTransaction();
//			int studentID = 1;
			
//			Student theStudent = session.get(Student.class, studentID);
//			session.delete(theStudent);
			
			session.createQuery("delete Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
