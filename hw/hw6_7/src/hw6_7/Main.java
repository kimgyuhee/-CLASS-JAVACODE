package hw6_7;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost/projects?characterEncoding=UTF-8&serverTimezone=UTC&&useSSL=false";

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결중 ...");
			conn = DriverManager.getConnection(url,"puser", "1234");
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
		System.out.println("hw6_7 : 김규희");

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

		System.out.println("다음 중 하나를 선택하시오.");

		System.out.println("a.학과 관리	 b.학생 관리 c.교수 관리  d.상담 관리  e.종료");
		System.out.println("_________________________________");

		int i=0;
		int no1;
		int no2;
		String phone;
		String name;

		do {
			System.out.print("메뉴를 선택하시오 ->");
			s=scr.nextLine();
			if(s.equals("e"))
				break;
			switch(s) {
			case "a":
				System.out.println("학과 전체 리스트 출력");
				while(rsa.next()) {		
					System.out.print(rsa.getString(1)+" "+rsa.getString(2)+" "+rsa.getString(3)+"\n"); 
				}
				System.out.println(" 1) 학과 정보 입력\r\n" + 
						" 2) 학과 삭제\r\n"+" 입력이나 삭제후 전체 리스트 출력\r\n" +" 3) 메인메뉴 돌아가기");
				System.out.print("메뉴를 입력하시오. ");
				i=scr.nextInt();


				if(i==1) {
					pstmta=conn.prepareStatement("insert into department values(?,?,null)");
					System.out.println("1)학과 정보 입력");
					System.out.print("학과 고유 번호를 입력 : ");
					no1=scr.nextInt();
					pstmta.setInt(1, no1);
					System.out.print("학과 이름 입력 : ");
					name=scr.next();
					pstmta.setString(2, name);

					pstmta.executeUpdate();


				}
				else if(i==2) { 
					System.out.println("2)학과 삭제");
					pstmta=conn.prepareStatement("delete from department where dept_no=?");
					System.out.print("삭제할 학과 고유 번호 입력 : ");
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
				System.out.println("학과 전체 리스트 출력");
				while(rsb.next()) {		
					System.out.print(rsb.getString(1)+" "+rsb.getString(2)+" "+rsb.getString(3)+" "+rsb.getString(4)+"\n"); 
				}

				System.out.println(" 1) 학생 정보 입력\r\n 학과 선택,학생정보입력\r\n" + 
						" 2) 학생 삭제\r\n"+" 입력이나 삭제후 전체 리스트 출력\r\n" +" 3) 메인메뉴 돌아가기");
				System.out.print("메뉴를 입력하시오. ");
				i=scr.nextInt();


				if(i==1) {
					pstmtb=conn.prepareStatement("insert into student values(?,'?',?,)"+"?)");
					System.out.println("1)학생 정보 입력");
					System.out.print("학생 이름 입력 : ");
					name=scr.next();
					pstmtb.setString(2, name);
					System.out.print("학생학번 입력 : ");
					no2=scr.nextInt();
					pstmtb.setInt(1, no2);
					System.out.print("학생 전화번호를 입력 : ");
					phone=scr.next();
					pstmtc.setString(3, phone);
					
					System.out.print("학과 고유 번호를 입력 : ");
					no1=scr.nextInt();
					pstmtb.setInt(4, no1);
					
					pstmtb.executeUpdate();
				}
				else if(i==2) { 
					System.out.println("2)학생 삭제");
					pstmtb=conn.prepareStatement("delete from student where std_id=?");
					System.out.print("삭제할 학생학번 입력 : ");
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
				System.out.println("학과 전체 리스트 출력");
				while(rsc.next()) {		
					System.out.print(rsc.getString(1)+" "+rsc.getString(2)+" "+rsc.getString(3)+" "+rsc.getString(4)+"\n"); 
				}

				System.out.println(" 1) 교수 정보 입력\r\n 학과 선택,교수정보입력\r\n" + 
						" 2) 교수 삭제\r\n"+" 입력이나 삭제후 전체 리스트 출력\r\n" +" 3) 메인메뉴 돌아가기");
				System.out.print("메뉴를 입력하시오. ");
				i=scr.nextInt();


				if(i==1) {
					pstmtc=conn.prepareStatement("insert into professor values(?,'?',?,?)");
					System.out.println("1)교수 정보 입력");
					System.out.print("교수 이름 입력 : ");
					name=scr.next();
					pstmtc.setString(2, name);
					System.out.print("교수 학번 입력 : ");
					no2=scr.nextInt();
					pstmtc.setInt(1, no2);
					System.out.print("교수 전화번호를 입력 : ");
					phone=scr.next();
					pstmtc.setString(3, phone);
					System.out.print("학과 고유 번호를 입력 : ");
					no1=scr.nextInt();
					pstmtc.setInt(4, no1);
					 
					pstmtc.executeUpdate();
				}
				else if(i==2) { 
					System.out.println("2)교수 삭제");
					pstmtc=conn.prepareStatement("delete from professor where pro_dept=?");
					System.out.print("삭제할 교수학번 입력 : ");
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
				System.out.println("d) 상담 관리\r\n" + 
						" 1) 학번 입력\r\n" + 
						"  학번의 학생이 신천한 전체 리스트 출력\r\n" + 
						"  1.1) 상담 신청\r\n" + 
						"   교수선택, 상담 정보 입력\r\n" + 
						"   완료 후 자신이 신청한 상담 정보 표시\r\n" + 
						"  1.2) 상담 취소\r\n" + 
						"   취소할 상담 선택\r\n" + 
						"  1.3) 상담 기록\r\n" + 
						"   상담 선택 후 상삼 기록 작성\r\n" + 
						"  1.4) 상담 상세 정보 표시\r\n" + 
						"   승인된 프로젝트에 대한 정보 표시(상담주제, 교수이름, 상담횟수)\r\n" + 
						"    특정 프로젝트 선택시 날짜, 회의 내용 표시.\r\n" + 
						"   1.5) 메인 메뉴 돌아가기");
				break;
			default:
				System.out.println("다른 메뉴를 선택하시오.");
				break;
			}
		}while(!s.equals("e"));

	}

}
