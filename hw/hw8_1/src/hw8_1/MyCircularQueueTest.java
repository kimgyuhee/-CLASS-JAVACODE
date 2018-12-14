/********************************
 * ���ϸ� : MyCircularQueueTest.java
 * �ۼ���: 2018�� 11�� 1��
 * �ۼ���: �����
 * ����: �迭�� �̿��� ���� ť ������ �����Ѵ�.
 *********************************/
package hw8_1;

import java.util.Scanner;

public class MyCircularQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_1 : �����");
		
		MyCircularQueue queue = new MyCircularQueue(5);
		Scanner scr = new Scanner(System.in);
		
		while(true) {
			System.out.print("1:���� 2:���� 3:��ȸ 4:ũ�� 5:��ü���� 6:���� -> ");
			int i=scr.nextInt();
			if(i==6)
				break;
			switch(i) {
			case 1: 
				System.out.print("������ ���ڸ� �Է��Ͻÿ� -> ");
				int n=scr.nextInt();
				queue.enQueue(n);
				break;
			case 2:
				System.out.println("������ ���� �� -> "+queue.deQueue());
				break;
			case 3:
				System.out.println("�� �� ���� �� ��ȸ-> "+queue.peek());
				break;
			case 4:
				System.out.println("����� ���� ��-> "+queue.size());
				break;
			case 5:
				while(!queue.isEmpty()) {
					System.out.print(queue.deQueue()+" ");
				}
				System.out.println();
				break;
			default:
				System.out.println("1~6������ ���ڸ� �Է��Ͻÿ�.");
			}
		}
		
	}

}
