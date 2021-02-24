package com.spring.jdbc.tutorial.SpringJDBCSimpleExample;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringJdbcSimpleExampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCConfig.class);
		StudentDAO studentDAO = (StudentDAO) ctx.getBean("studentDAO");
		Student s = new Student(2300,"khush",58);

		studentDAO.insert(s);
		Student s1 = new Student(287,"manish",85);
		studentDAO.update(s1);

		
		Student s2 = new Student(287,"manish",85);
		//studentDAO.delete(s2);
		s2  = studentDAO.getStudent(287);
			
		
		System.out.println(s2.toString());
		
		List<Student> ssList = studentDAO.getAllStudents();
		for(Student s12:ssList) {
			System.out.println(s12);
		}
		SpringApplication.run(SpringJdbcSimpleExampleApplication.class, args);
	}

}
