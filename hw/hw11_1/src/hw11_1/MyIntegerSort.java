/***************************
파일명: MyIntegerSort.java
작성자: 김규희
작성일: 2018. 12. 09
프로그램 설명: 병합 정렬 알고리즘과 병합 알고리즘을 이해한다.
***************************/
package hw11_1;

public class MyIntegerSort {
	public static void mergeSort(int[] a) {
		mergeSort(a,0,a.length-1);
	}
	
	public static void mergeSort(int[] a, int lb, int ub) {
		int middle;
		if(lb<ub) {
			middle=(lb+ub)/2;
			mergeSort(a,lb,middle);
			mergeSort(a,middle+1, ub);
			merge(a, lb, middle, ub);
		}
	}
	
	public static void merge(int[] a, int lb, int middle, int ub) {
		int i=lb;
		int j =middle+1;
		int k=lb;
		
		int[] temp=new int[a.length];
		
		while(i<=middle && j<=ub) {
			if(a[i]<=a[j]) {
				temp[k]=a[i++];
			}
			else
				temp[k]=a[j++];
			k++;
		}
		
		if(i>middle){
            for(int t = j; t <= ub; t++, k++)
                temp[k] = a[t];
        }
		else {
            for(int t = i; t <= middle; t++, k++)
                temp[k] =a[t];
        }
		
		for(int x=lb ; x<=ub;x++) {
			a[x]=temp[x];
		}
	}
}
