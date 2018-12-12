package hw6_5;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost/projects?characterEncoding=UTF-8&serverTimezone=UTC&&useSSL=false";

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�����ͺ��̽� ������ ...");
			conn = DriverManager.getConnection(url,"puser", "1234");
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
		System.out.println("hw6_5 : �����");

		Connection conn=makeConnection();
		Statement state = conn.createStatement();

		String sql="SELECT * FROM department";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		Scanner scr = new Scanner(System.in);
		String s = " ";

		System.out.println("���� �� �ϳ��� �����Ͻÿ�.");
		/**********************************************
		System.out.println("a) �а� ����\r\n" + 
				" ��ü ����Ʈ ���\r\n" + 
				" 1) �а� ���� �Է�\r\n" + 
				" 2) �а� ����\r\n" + 
				" �Է��̳� ������ ��ü ����Ʈ ���\r\n" + 
				" 3) ���� �޴� ���ư���\r\n" + 
				"b) �л� ����\r\n" + 
				" ��ü ����Ʈ ���\r\n" + 
				" 1) �л� ���� �Է�\r\n" + 
				"  �а� ����, �л������Է�\r\n" + 
				" 2) �л� ����\r\n" + 
				" �Է��̳� ������ ��ü ����Ʈ ���\r\n" + 
				" 3) ���� �޴� ���ư���\r\n" + 
				"c) ���� ����\r\n" + 
				" ��ü ����Ʈ ���\r\n" + 
				" 1) ���� ���� �Է�\r\n" + 
				"  �а� ����, ���������Է�\r\n" + 
				" 2) ���� ����\r\n" + 
				" �Է��̳� ������ ��ü ����Ʈ ���\r\n" + 
				" 3) ���� �޴� ���ư���\r\n" + 
				"d) ��� ����\r\n" + 
				" 1) �й� �Է�\r\n" + 
				"  ��û�̳� ��� �� ��ü ����Ʈ ���\r\n" + 
				"  1.1) ��� ��û\r\n" + 
				"   ��������, ��� ���� �Է�\r\n" + 
				"   �Ϸ� �� �ڽ��� ��û�� ��� ���� ǥ��\r\n" + 
				"  1.2) ��� ���\r\n" + 
				"   ����� ��� ����\r\n" + 
				"  1.3) ��� ���\r\n" + 
				"   ��� ���� �� ��� ��� �ۼ�\r\n" + 
				"  1.4) ��� �� ���� ǥ��\r\n" + 
				"   ���ε� ������Ʈ�� ���� ���� ǥ��(�������, �����̸�, ���Ƚ��)\r\n" + 
				"    Ư�� ������Ʈ ���ý� ��¥, ȸ�� ���� ǥ��.\r\n" + 
				"   1.5) ���� �޴� ���ư���\r\n" + 
				" 2) ���� ������ȣ : ��û�� ������Ʈ�� ���� ����\r\n" + 
				"  ��û�� ������Ʈ ����Ʈ ���\r\n" + 
				"  2.1) ������ ������Ʈ ����\r\n" + 
				"  2.2) ��� �� ���� ǥ��\r\n" + 
				"   ������ ����� ��㿡 ���� ���� ǥ��(�������, �л��̸�, ȸ�� Ƚ��)\r\n" + 
				"    Ư�� ������Ʈ ���ý� ��¥, ȸ�� ���� ǥ��.\r\n" + 
				"   2.3) ���� �޴� ���ư���\r\n" + 
				"e) ����");
		 *********************************************/
		System.out.println("a.�а� ����	 b.�л� ���� c.���� ����  d.��� ����  e.����");
		System.out.println("_________________________________");

		int i=0;
		int dept_no;
		String dept_name;

		do {
			System.out.print("�޴��� �����Ͻÿ� ->");
			s=scr.nextLine();
			if(s.equals("e"))
				break;
			switch(s) {
			case "a":
				System.out.println("�а� ��ü ����Ʈ ���");
				while(rs.next()) {		
					System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"\n"); 
				}
				System.out.println(" 1) �а� ���� �Է�\r\n" + 
						" 2) �а� ����");
				System.out.print("�޴��� �Է��Ͻÿ�. ");
				i=scr.nextInt();

				
				if(i==1) {
					pstmt=conn.prepareStatement("insert into department values(?,?,null)");
					System.out.println("1)�а� ���� �Է�");
					System.out.print("�а� ���� ��ȣ�� �Է� : ");
					dept_no=scr.nextInt();
					pstmt.setInt(1, dept_no);
					System.out.print("�а� �̸� �Է� : ");
					dept_name=scr.next();
					pstmt.setString(2, dept_name);
					
					pstmt.executeUpdate();

					
				}
				else if(i==2) { 
					System.out.println("2)�а� ����");
					pstmt=conn.prepareStatement("delete from department where dept_no=?");
					System.out.print("������ �а� ���� ��ȣ �Է� : ");
					dept_no=scr.nextInt();
					pstmt.setInt(1, dept_no);
					
					pstmt.executeUpdate();
				}

				pstmt=conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {		
					System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"\n"); 
				}
				
				break;
				
			case "b":
				System.out.println("b) �л� ����");
				break;
			case "c":
				System.out.println("c) ���� ����");
				break;
			case "d":
				System.out.println("d) ��� ����");
				break;
			default:
				System.out.println("�ٸ� �޴��� �����Ͻÿ�.");
				break;
			}
		}while(!s.equals("e"));

	}

}
