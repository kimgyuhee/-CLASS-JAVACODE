/***************************
파일명: MyDoublyLinkedListTest.java
작성자: 김규희
작성일: 2018. 10. 10
설명: 이중 연결리스트 연산을 구현한다.
***************************/
package hw6_2;

import java.util.Scanner;
public class MyDoublyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw6_2 : 김규희");
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		Scanner scr = new Scanner(System.in);
		int i,n;
		
		while(true) {
			System.out.println("1:전체조회 2:길이조회 3:맨앞삽입 4:맨뒤삽입 5:맨앞삭제 6:맨뒤삭제 7:삭제 8:왕복출력 9:종료");
			System.out.print("menu를 클릭하세요 -> ");
			i=scr.nextInt();
			if(i==9) {
				break;
			}
			switch(i) {
			case 1:
				System.out.println(list.toString());
				break;
			case 2:
				System.out.println(list.size());
				break;
			case 3:
				System.out.print("정수를 입력하세요 -> ");
				n=scr.nextInt();
				list.addFirst(n);
				break;
			case 4:
				System.out.print("정수를 입력하세요 -> ");
				n=scr.nextInt();
				list.addLast(n);
				break;
			case 5:
				System.out.print("삭제된 정수 값 -> ");
				System.out.println(list.removeFirst());
				break;
			case 6:
				System.out.print("삭제된 정수 값 -> ");
				System.out.println(list.removeLast());
				break;
			case 7:
				System.out.print("정수를 입력하세요 -> ");
				n=scr.nextInt();
				System.out.println("삭제 성공 여부 -> "+list.remove(n));
				break;
			case 8:
				list.printList();
				break;
			default:
				System.out.println("1~9 사이의 숫자를 입력하시오 -> ");
				
			}
				
		}
	}

}
