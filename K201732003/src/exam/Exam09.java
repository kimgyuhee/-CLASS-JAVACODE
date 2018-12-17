package exam;

import java.util.Arrays;

public class Exam09 {

    public static String[] insert(String[] a, int index, String s) {
    	String[] a1=Arrays.copyOf(a, a.length+1);
    	a1[a.length]=s;
    	
    	for(int i=a1.length-1; i>index; i--) {
    		a1[i]=a1[i-1];
    	}
    	a1[index]=s;
    
    	
    	return a1;
    	
    }

    public static void main(String[] args) {
        String[] a = {"a", "c", "d", "f", "g", "h"};
        a = insert(a, 1, "b");
        a = insert(a, 4, "e");
        System.out.println(Arrays.toString(a));
    }
}
