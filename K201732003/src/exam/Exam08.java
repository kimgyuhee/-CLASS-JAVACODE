package exam;

import java.util.Arrays;

public class Exam08 {

	public static void insert(String[] a, int index, String s) {
		String[] a1=Arrays.copyOf(a, a.length+1);
    	a1[a.length]=s;
    	
    	for(int i=a1.length-1; i>index; i--) {
    		a1[i]=a1[i-1];
    	}
    	a1[index]=s;
    
    	String[] a2=Arrays.copyOf(a1,a.length);
    	
    	for(int j=0 ;j<a2.length;j++) {
    		a[j]=a2[j];
    	}
    	
	}

	public static void main(String[] args) {
		String[] a = {"a", "c", "d", "f", "g", "h"};
		insert(a, 1, "b");
		insert(a, 4, "e");
		System.out.println(Arrays.toString(a));
	}
}
