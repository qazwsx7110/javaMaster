package co.yedam;

import java.sql.*;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
    //DB 접속 후 connection
	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			  conn = DriverManager.getConnection(url,"jsp","jsp");
			 }
			 catch (Exception e) {
				 e.printStackTrace();
				 return;
				 
			 }
	}
	
	//사원목록 기능

	void empList() {
		
		getConn();
		String sql = "select * from emp order by emp_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			System.out.println("사원번호 사원명 연락처      급여");
			System.out.println("----------------------------");
			while(rs.next()) {
			System.out.println(rs.getInt("emp_no")+" " + rs.getString("emp_name")
			+rs.getString("emp_phone")+" "+ rs.getInt("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//사원등록 기능
	boolean insertEmp(Employee emp) {
		getConn();
		String sql= "insert into emp(emp_no,emp_name,emp_phone,email,salary,hire_date)";
		 sql+="values(emp_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmpName());
			 psmt.setString(2, emp.getPhone());
			 psmt.setString(3, emp.getEmail());
			 psmt.setInt(4, emp.getSalary());
			 psmt.setDate(5,emp.getHireDate());
			 int r= psmt.executeUpdate();
			 if(r>0) {
				 return true;
			 }else {
				 return false;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return true;
	}
	
	//수정기능
	boolean updateEmp(Employee emp) {
		getConn();
		String sql = "update emp ";
		sql += "set salary = ?";
		sql+=",email=?";
		sql+= "where emp_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getSalary());
			psmt.setString(2, emp.getEmail());
			psmt.setInt(3, emp.getEmpNo());
			
			int r = psmt.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	boolean deleteEmp(int emp) {
		getConn();
		String sql = "delete emp ";
		sql+= "where emp_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, emp);
			
			int r = psmt.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	
	}
	
}
