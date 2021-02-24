package com.spring.jdbc.tutorial.SpringJDBCSimpleExample;

import java.util.List;

public interface StudentDAO {
	public int insert(Student s);
	public int update(Student s);
	public int delete(Student s);
	public Student getStudent(int rollNumber);
	public List<Student> getAllStudents();

}
