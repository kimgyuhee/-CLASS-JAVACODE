/********************************
 * 파일명 : MyLinkedQueueTest.java
 * 작성일: 2018년 11월 4일
 * 작성자: 김규희
 * 내용: 연결자료구조를 이용한 큐 구현을 연습한다.
 *********************************/
package hw8_2;

import java.util.Scanner;

public class MyLinkedQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2 : 김규희");

		MyLinkedQueue queue = new MyLinkedQueue();
		Scanner scr = new Scanner(System.in);

		while(true) {
			System.out.print("1:삽입 2:삭제 3:조회 4:크기 5:전체삭제 6:종료 -> ");
			int i=scr.nextInt();
			if(i==6)
				break;
			switch(i) {
			case 1: 
				System.out.print("삽입할 숫자를 입력하시오 -> ");
				int n=scr.nextInt();
				queue.enQueue(n);
				break;
			case 2:
				System.out.println("삭제된 원소 값 -> "+queue.deQueue());
				break;
			case 3:
				System.out.println("맨 앞 원소 값 조회-> "+queue.peek());
				break;
			case 4:
				System.out.println("저장된 원소 수-> "+queue.size());
				break;
			case 5:
				while(!queue.isEmpty()) {
					System.out.print(queue.deQueue()+" ");
				}
				System.out.println();
				break;
			default:
				System.out.println("1~6사이의 숫자를 입력하시오.");
			}
		}

	}

}
