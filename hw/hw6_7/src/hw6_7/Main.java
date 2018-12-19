package hw6_7;

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
		System.out.println("hw6_7 : �����");

		Connection conn=makeConnection();
		Statement state = conn.createStatement();

		String sqla="SELECT * FROM department";
		PreparedStatement pstmta = conn.prepareStatement(sqla);
		ResultSet rsa = pstmta.executeQuery();

		String sqlb="SELECT * FROM student";
		PreparedStatement pstmtb = conn.prepareStatement(sqlb);
		ResultSet rsb = pstmtb.executeQuery();

		String sqlc="SELECT * FROM professor";
		PreparedStatement pstmtc = conn.prepareStatement(sqlc);
		ResultSet rsc = pstmtc.executeQuery();

		Scanner scr = new Scanner(System.in);
		String s = " ";

		System.out.println("���� �� �ϳ��� �����Ͻÿ�.");

		System.out.println("a.�а� ����	 b.�л� ���� c.���� ����  d.��� ����  e.����");
		System.out.println("_________________________________");

		int i=0;
		int no1;
		int no2;
		String phone;
		String name;

		do {
			System.out.print("�޴��� �����Ͻÿ� ->");
			s=scr.nextLine();
			if(s.equals("e"))
				break;
			switch(s) {
			case "a":
				System.out.println("�а� ��ü ����Ʈ ���");
				while(rsa.next()) {		
					System.out.print(rsa.getString(1)+" "+rsa.getString(2)+" "+rsa.getString(3)+"\n"); 
				}
				System.out.println(" 1) �а� ���� �Է�\r\n" + 
						" 2) �а� ����\r\n"+" �Է��̳� ������ ��ü ����Ʈ ���\r\n" +" 3) ���θ޴� ���ư���");
				System.out.print("�޴��� �Է��Ͻÿ�. ");
				i=scr.nextInt();


				if(i==1) {
					pstmta=conn.prepareStatement("insert into department values(?,?,null)");
					System.out.println("1)�а� ���� �Է�");
					System.out.print("�а� ���� ��ȣ�� �Է� : ");
					no1=scr.nextInt();
					pstmta.setInt(1, no1);
					System.out.print("�а� �̸� �Է� : ");
					name=scr.next();
					pstmta.setString(2, name);

					pstmta.executeUpdate();


				}
				else if(i==2) { 
					System.out.println("2)�а� ����");
					pstmta=conn.prepareStatement("delete from department where dept_no=?");
					System.out.print("������ �а� ���� ��ȣ �Է� : ");
					no1=scr.nextInt();
					pstmta.setInt(1, no1);

					pstmta.executeUpdate();
				}
				else if(i==3) {
					continue;
				}

				pstmta=conn.prepareStatement(sqla);

				rsa = pstmta.executeQuery();
				while(rsa.next()) {		
					System.out.print(rsa.getString(1)+" "+rsa.getString(2)+" "+rsa.getString(3)+"\n"); 
				}


				break;

			case "b":
				System.out.println("�а� ��ü ����Ʈ ���");
				while(rsb.next()) {		
					System.out.print(rsb.getString(1)+" "+rsb.getString(2)+" "+rsb.getString(3)+" "+rsb.getString(4)+"\n"); 
				}

				System.out.println(" 1) �л� ���� �Է�\r\n �а� ����,�л������Է�\r\n" + 
						" 2) �л� ����\r\n"+" �Է��̳� ������ ��ü ����Ʈ ���\r\n" +" 3) ���θ޴� ���ư���");
				System.out.print("�޴��� �Է��Ͻÿ�. ");
				i=scr.nextInt();


				if(i==1) {
					pstmtb=conn.prepareStatement("insert into student values(?,'?',?,)"+"?)");
					System.out.println("1)�л� ���� �Է�");
					System.out.print("�л� �̸� �Է� : ");
					name=scr.next();
					pstmtb.setString(2, name);
					System.out.print("�л��й� �Է� : ");
					no2=scr.nextInt();
					pstmtb.setInt(1, no2);
					System.out.print("�л� ��ȭ��ȣ�� �Է� : ");
					phone=scr.next();
					pstmtc.setString(3, phone);
					
					System.out.print("�а� ���� ��ȣ�� �Է� : ");
					no1=scr.nextInt();
					pstmtb.setInt(4, no1);
					
					pstmtb.executeUpdate();
				}
				else if(i==2) { 
					System.out.println("2)�л� ����");
					pstmtb=conn.prepareStatement("delete from student where std_id=?");
					System.out.print("������ �л��й� �Է� : ");
					no2=scr.nextInt();
					pstmtb.setInt(1, no2);

					pstmtb.executeUpdate();
				}
				else if(i==3)
					continue;

				pstmtb=conn.prepareStatement(sqlb);

				rsb = pstmtb.executeQuery();
				while(rsb.next()) {		
					System.out.print(rsb.getString(1)+" "+rsb.getString(2)+" "+rsb.getString(3)+" "+rsb.getString(4)+"\n"); 
				}

				break;
			case "c":
				System.out.println("�а� ��ü ����Ʈ ���");
				while(rsc.next()) {		
					System.out.print(rsc.getString(1)+" "+rsc.getString(2)+" "+rsc.getString(3)+" "+rsc.getString(4)+"\n"); 
				}

				System.out.println(" 1) ���� ���� �Է�\r\n �а� ����,���������Է�\r\n" + 
						" 2) ���� ����\r\n"+" �Է��̳� ������ ��ü ����Ʈ ���\r\n" +" 3) ���θ޴� ���ư���");
				System.out.print("�޴��� �Է��Ͻÿ�. ");
				i=scr.nextInt();


				if(i==1) {
					pstmtc=conn.prepareStatement("insert into professor values(?,'?',?,?)");
					System.out.println("1)���� ���� �Է�");
					System.out.print("���� �̸� �Է� : ");
					name=scr.next();
					pstmtc.setString(2, name);
					System.out.print("���� �й� �Է� : ");
					no2=scr.nextInt();
					pstmtc.setInt(1, no2);
					System.out.print("���� ��ȭ��ȣ�� �Է� : ");
					phone=scr.next();
					pstmtc.setString(3, phone);
					System.out.print("�а� ���� ��ȣ�� �Է� : ");
					no1=scr.nextInt();
					pstmtc.setInt(4, no1);
					 
					pstmtc.executeUpdate();
				}
				else if(i==2) { 
					System.out.println("2)���� ����");
					pstmtc=conn.prepareStatement("delete from professor where pro_dept=?");
					System.out.print("������ �����й� �Է� : ");
					no2=scr.nextInt();
					pstmtc.setInt(1, no2);

					pstmtc.executeUpdate();
				}
				else if(i==3)
					continue;

				pstmtc=conn.prepareStatement(sqlc);

				rsc = pstmtc.executeQuery();
				while(rsc.next()) {		
					System.out.print(rsc.getString(1)+" "+rsc.getString(2)+" "+rsc.getString(3)+" "+rsc.getString(4)+"\n"); 
				}

				break;
			case "d":
				System.out.println("d) ��� ����\r\n" + 
						" 1) �й� �Է�\r\n" + 
						"  �й��� �л��� ��õ�� ��ü ����Ʈ ���\r\n" + 
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
						"   1.5) ���� �޴� ���ư���");
				break;
			default:
				System.out.println("�ٸ� �޴��� �����Ͻÿ�.");
				break;
			}
		}while(!s.equals("e"));

	}

}
