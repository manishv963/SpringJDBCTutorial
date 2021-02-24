package com.spring.jdbc.tutorial.SpringJDBCSimpleExample;

public class Student {
	
	
	private Integer rollNumber;

	private String name;
	private Integer marks;
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public Student(Integer rollNumber, String name, Integer marks) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marks = marks;
	}
	
	public Student() {
		
	}
}
