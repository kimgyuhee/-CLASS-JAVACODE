/***************************
���ϸ�: MyDoublyLinkedListTest.java
�ۼ���: �����
�ۼ���: 2018. 10. 10
����: ���� ���Ḯ��Ʈ ������ �����Ѵ�.
***************************/
package hw6_2;

import java.util.Scanner;
public class MyDoublyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw6_2 : �����");
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		Scanner scr = new Scanner(System.in);
		int i,n;
		
		while(true) {
			System.out.println("1:��ü��ȸ 2:������ȸ 3:�Ǿջ��� 4:�ǵڻ��� 5:�Ǿջ��� 6:�ǵڻ��� 7:���� 8:�պ���� 9:����");
			System.out.print("menu�� Ŭ���ϼ��� -> ");
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
				System.out.print("������ �Է��ϼ��� -> ");
				n=scr.nextInt();
				list.addFirst(n);
				break;
			case 4:
				System.out.print("������ �Է��ϼ��� -> ");
				n=scr.nextInt();
				list.addLast(n);
				break;
			case 5:
				System.out.print("������ ���� �� -> ");
				System.out.println(list.removeFirst());
				break;
			case 6:
				System.out.print("������ ���� �� -> ");
				System.out.println(list.removeLast());
				break;
			case 7:
				System.out.print("������ �Է��ϼ��� -> ");
				n=scr.nextInt();
				System.out.println("���� ���� ���� -> "+list.remove(n));
				break;
			case 8:
				list.printList();
				break;
			default:
				System.out.println("1~9 ������ ���ڸ� �Է��Ͻÿ� -> ");
				
			}
				
		}
	}

}
