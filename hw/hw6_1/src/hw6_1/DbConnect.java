//***************************
 // ���ϸ�: DbConnect.java
 // �ۼ���: �����
 // �ۼ���: 2018. 12. 05
 // ����: - hw4_1���� ������ ����� emp_user�� ����Ͽ� employees �����ͺ��̽��� �����Ͻÿ�.
 //***************************
package hw6_1;

import java.sql.*;

public class DbConnect {

	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost/employees?characterEncoding=UTF-8&serverTimezone=UTC&&useSSL=false";
		
		Connection conn=null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�����ͺ��̽� ������ ...");
			conn = DriverManager.getConnection(url,"emp_user", "test123");
			System.out.println("�����ͺ��̽� ���� ����");

			
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�.");
		}catch(SQLException e) {
			System.out.println("�����ͺ��̽� ���� ����");
		}

		return conn;

	}
	public static void main(String[] args) throws SQLException { 
		// TODO Auto-generated method stub
		System.out.println("hw6_1 : �����");
		
		Connection conn=makeConnection();
		Statement state = conn.createStatement();

		String sql="SELECT employee_id, first_name, last_name, email FROM employees";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		//(1). ������ id�� �̸�, �̸����� ����϶�
		while(rs.next()) {		
			System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n"); 
		}
		
		System.out.println("-----------------------------------------------------------");
		
		//(2). last name�� Gietz�� ������ �����϶�
		pstmt.execute("delete from employees where last_name='Gietz'");
		
		rs = pstmt.executeQuery();
		//(3). ������ id�� �̸�, �̸����� ����϶�
		while(rs.next()) {		
			System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"\n"); 
		}

		rs.close();
		state.close();
		conn.close();

	}



}
