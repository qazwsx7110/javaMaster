package co.yedam;

import java.sql.Date;

public class Employee {

	private String empName;
	private String phone;
	private String email;
	private int salary;
	private Date hireDate;
	private int empNo;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public java.sql.Date getHireDate() {
		java.sql.Date Data= this.hireDate;
		return Data;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String toString() {
		return "Employee [";
	}
	public void setHireDate(java.util.Date date) {
		// TODO Auto-generated method stub
		
	}
	
}
