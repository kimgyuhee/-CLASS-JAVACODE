//***************************
 // 파일명: DbConnect.java
 // 작성자: 김규희
 // 작성일: 2018. 12. 05
 // 내용: - hw4_1에서 생성한 사용자 emp_user를 사용하여 employees 데이터베이스에 접속하시오.
 //***************************
package hw6_1;

import java.sql.*;

public class DbConnect {

	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost/employees?characterEncoding=UTF-8&serverTimezone=UTC&&useSSL=false";
		
		Connection conn=null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결중 ...");
			conn = DriverManager.getConnection(url,"emp_user", "test123");
			System.out.println("데이터베이스 연결 성공");

			
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾기 못했습니다.");
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}

		return conn;

	}
	public static void main(String[] args) throws SQLException { 
		// TODO Auto-generated method stub
		System.out.println("hw6_1 : 김규희");
		
		Connection conn=makeConnection();
		Statement state = conn.createStatement();

		String sql="SELECT employee_id, first_name, last_name, email FROM employees";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		//(1). 직원의 id와 이름, 이메일을 출력하라
		while(rs.next()) {		
			System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n"); 
		}
		
		System.out.println("-----------------------------------------------------------");
		
		//(2). last name이 Gietz인 직원을 삭제하라
		pstmt.execute("delete from employees where last_name='Gietz'");
		
		rs = pstmt.executeQuery();
		//(3). 직원의 id와 이름, 이메일을 출력하라
		while(rs.next()) {		
			System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n"); 
		}

		rs.close();
		state.close();
		conn.close();

	}



}
