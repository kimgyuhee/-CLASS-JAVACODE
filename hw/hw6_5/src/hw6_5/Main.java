package hw6_5;

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
		System.out.println("hw6_5 : 김규희");

		Connection conn=makeConnection();
		Statement state = conn.createStatement();

		String sql="SELECT * FROM department";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		Scanner scr = new Scanner(System.in);
		String s = " ";

		System.out.println("다음 중 하나를 선택하시오.");
		/**********************************************
		System.out.println("a) 학과 관리\r\n" + 
				" 전체 리스트 출력\r\n" + 
				" 1) 학과 정보 입력\r\n" + 
				" 2) 학과 삭제\r\n" + 
				" 입력이나 삭제후 전체 리스트 출력\r\n" + 
				" 3) 메인 메뉴 돌아가기\r\n" + 
				"b) 학생 관리\r\n" + 
				" 전체 리스트 출력\r\n" + 
				" 1) 학생 정보 입력\r\n" + 
				"  학과 선택, 학생정보입력\r\n" + 
				" 2) 학생 삭제\r\n" + 
				" 입력이나 삭제후 전체 리스트 출력\r\n" + 
				" 3) 메인 메뉴 돌아가기\r\n" + 
				"c) 교수 관리\r\n" + 
				" 전체 리스트 출력\r\n" + 
				" 1) 교수 정보 입력\r\n" + 
				"  학과 선택, 교보정보입력\r\n" + 
				" 2) 교수 삭제\r\n" + 
				" 입력이나 삭제후 전체 리스트 출력\r\n" + 
				" 3) 메인 메뉴 돌아가기\r\n" + 
				"d) 상담 관리\r\n" + 
				" 1) 학번 입력\r\n" + 
				"  신청이나 취소 후 전체 리스트 출력\r\n" + 
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
				"   1.5) 메인 메뉴 돌아가기\r\n" + 
				" 2) 교수 고유번호 : 신청된 프로젝트에 대한 승인\r\n" + 
				"  신청된 프로젝트 리스트 출력\r\n" + 
				"  2.1) 승인할 프로젝트 선택\r\n" + 
				"  2.2) 상담 상세 정보 표시\r\n" + 
				"   교수가 담당한 상담에 대한 정보 표시(상담주제, 학생이름, 회의 횟수)\r\n" + 
				"    특정 프로젝트 선택시 날짜, 회의 내용 표시.\r\n" + 
				"   2.3) 메인 메뉴 돌아가기\r\n" + 
				"e) 종료");
		 *********************************************/
		System.out.println("a.학과 관리	 b.학생 관리 c.교수 관리  d.상담 관리  e.종료");
		System.out.println("_________________________________");

		int i=0;
		int dept_no;
		String dept_name;

		do {
			System.out.print("메뉴를 선택하시오 ->");
			s=scr.nextLine();
			if(s.equals("e"))
				break;
			switch(s) {
			case "a":
				System.out.println("학과 전체 리스트 출력");
				while(rs.next()) {		
					System.out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"\n"); 
				}
				System.out.println(" 1) 학과 정보 입력\r\n" + 
						" 2) 학과 삭제");
				System.out.print("메뉴를 입력하시오. ");
				i=scr.nextInt();

				
				if(i==1) {
					pstmt=conn.prepareStatement("insert into department values(?,?,null)");
					System.out.println("1)학과 정보 입력");
					System.out.print("학과 고유 번호를 입력 : ");
					dept_no=scr.nextInt();
					pstmt.setInt(1, dept_no);
					System.out.print("학과 이름 입력 : ");
					dept_name=scr.next();
					pstmt.setString(2, dept_name);
					
					pstmt.executeUpdate();

					
				}
				else if(i==2) { 
					System.out.println("2)학과 삭제");
					pstmt=conn.prepareStatement("delete from department where dept_no=?");
					System.out.print("삭제할 학과 고유 번호 입력 : ");
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
				System.out.println("b) 학생 관리");
				break;
			case "c":
				System.out.println("c) 교수 관리");
				break;
			case "d":
				System.out.println("d) 상담 관리");
				break;
			default:
				System.out.println("다른 메뉴를 선택하시오.");
				break;
			}
		}while(!s.equals("e"));

	}

}
