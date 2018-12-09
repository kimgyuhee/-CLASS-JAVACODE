/***************************
파일명: SortTest.java
작성자: 김규희
작성일: 2018. 12. 09
프로그램 설명: 병합 정렬 알고리즘과 병합 알고리즘을 이해한다.
***************************/
package hw11_1;

import java.util.Scanner;
public class SortTest {
	public static void main(String[] args) {
		System.out.println("hw11_1 : 김규희");
		
		Scanner scr = new Scanner(System.in);
		System.out.print("정수 갯수 입력 : ");
		int n=scr.nextInt();
		
		int[] array = new int[n];
		System.out.print(n+"개의 정수 입력 : ");
		for(int i=0;i<n;i++) {
			array[i]=scr.nextInt();
		}
		
		System.out.print("정렬 전 배열 = ");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		
		MyIntegerSort.mergeSort(array);
		System.out.println();
		
		System.out.print("정렬 후 배열 = ");
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
