/***************************
���ϸ�: SortTest.java
�ۼ���: �����
�ۼ���: 2018. 12. 09
���α׷� ����: ���� ���� �˰���� ���� �˰����� �����Ѵ�.
***************************/
package hw11_1;

import java.util.Scanner;
public class SortTest {
	public static void main(String[] args) {
		System.out.println("hw11_1 : �����");
		
		Scanner scr = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		int n=scr.nextInt();
		
		int[] array = new int[n];
		System.out.print(n+"���� ���� �Է� : ");
		for(int i=0;i<n;i++) {
			array[i]=scr.nextInt();
		}
		
		System.out.print("���� �� �迭 = ");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		
		MyIntegerSort.mergeSort(array);
		System.out.println();
		
		System.out.print("���� �� �迭 = ");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
