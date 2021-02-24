package com.spring.jdbc.tutorial.SpringJDBCSimpleExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(Student s) {
		// TODO Auto-generated method stub
		String query="insert into student(rollno,name,marks) values (?,?,?)";
		int i = this.jdbcTemplate.update(query,s.getRollNumber(),s.getName(),s.getMarks());
		return i;
	}
	public int update(Student s) {
		// TODO Auto-generated method stub
		String query="update student set name = ?,marks = ? where rollno = ?";
		System.out.println(s.getRollNumber());
		int i = this.jdbcTemplate.update(query,s.getName(),s.getMarks(),s.getRollNumber());
		return i;
	}
	
	public int delete(Student s) {
		// TODO Auto-generated method stub
		String query="delete from student  where rollno = ?";
		int i = this.jdbcTemplate.update(query,s.getRollNumber());
		return i;
	}
	
	public Student getStudent(int rollNumber) {
		String sql= "select rollno,name,marks from student where rollno = ?";
		Student s = this.jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student s = new Student();
				s.setMarks(rs.getInt(3));
				s.setName(rs.getString(2));
				s.setRollNumber(rs.getInt(1));
				return s;
			}
		},rollNumber);
				
				return s;
	}

	public List<Student> getAllStudents(){
		
		String sql= "select rollno,name,marks from student";
		@SuppressWarnings("unchecked")
		List<Student> studList = (List<Student>) this.jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student s = new Student();
				s.setMarks(rs.getInt(3));
				s.setName(rs.getString(2));
				s.setRollNumber(rs.getInt(1));
				return s;
			}
		});
				
		return studList;
	}
}
