package co.yedam;

import java.sql.*;

//1.ojdbc 라이브러리
//2.connection 객체접속
//3.preparedstatenemt 객체 쿼리실행
//4.결과 = > 화면출력 , 기능수행.
public class AppTest {

 public static void main(String[] args) {

	 try {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 }
	 catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 return;
		 
	 }
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 try {
	 Connection conn = DriverManager.getConnection(url,"jsp","jsp");
	 String sqll1= "insert into emp(emp_no,emp_name,emp_phone,email,salary)";
	 sqll1+="values(emp_seq.nextval,?,?,?,?)";
	 PreparedStatement psmt = conn.prepareStatement(sqll1);
	 psmt.setString(1, "홍길동");
	 psmt.setString(2, "03-1111-2222");
	 psmt.setString(3, "fdsf@emil");
	 psmt.setInt(4, 3000);
	 
	 int r = psmt.executeUpdate();
	 System.out.print(r);
	 
	 
	 String sqll = "select * from emp";
	 psmt = conn.prepareStatement(sqll);
	 ResultSet rs = psmt.executeQuery();
	 
	 while(rs.next()) {
		 System.out.print(rs.getInt("emp_no"));
		 System.out.print(rs.getString("emp_name"));
	 }
	 }catch(SQLException e) {
		 e.printStackTrace();
		 }
	 
	 
	 
	 
	 
	 
 }
 
}
