package exam;

import java.util.Arrays;

public class Exam14 {

	public static String[] solution(String[] a1, String[] a2) {
		String[] a = new String[a1.length+a2.length];
		int index=0;
		for(int i=0; i<a1.length;i++,index++) {
			a[index]=a1[i];
		}
		
		for(int i=0; i<a2.length;i++,index++) {
			a[index]=a2[i];
		}
		
		return a;
	}

	public static void main(String[] args) {
		String[] a1 = { "d", "a", "b", "c" };
		String[] a2 = { "B", "D", "C", "A" };
		String[] a3 = solution(a1, a2);
		System.out.println(Arrays.toString(a3));
	}
}
