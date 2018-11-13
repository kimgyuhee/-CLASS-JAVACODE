package e2018.exam2;

import java.util.Arrays;

public class Exam14 {

	static void sort(int[] a) {
		/***
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
		**/
		Arrays.sort(a);
	}

	static boolean contains(int[] a, int value) {
		Arrays.asList(a);
		for(int i=0 ;i<a.length;i++) {
			if(a[i]==value)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 3, 8, 1, 2, 4, 5, 7 };

		sort(a);
		System.out.println(Arrays.toString(a));

		System.out.println(contains(a, 2));
		System.out.println(contains(a, 6));
	}
}
