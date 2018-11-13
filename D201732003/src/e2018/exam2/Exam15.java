package e2018.exam2;

import java.util.Arrays;

public class Exam15 {

	static void sort(int[] a) {
		for (int i = a.length- 1; i >= 1; --i) {
			boolean r = true;
			for (int j = 0; j < i; ++j) {
				if (a[j]-a[j+1] > 0) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					r=false;
				}
			}
			if (r) break;
		}
	}

	static int[] insert(int[] a, int value) {
		int[] result=a;
		for(int i=0; i<a.length;i++) {
			if(a[i]==value) {
				break;
			}
			else {
				result= new int[a.length+1];
				result[a.length]=value;
			}
			result[i]=a[i];
			}
		
		return result;
		
	}

	public static void main(String[] args) {
		int[] a = { 3, 8, 1, 2, 4, 5, 7 };

		sort(a);
		System.out.println(Arrays.toString(a));

		a = insert(a, 2);
		a = insert(a, 6);
		System.out.println(Arrays.toString(a));
	}
}
