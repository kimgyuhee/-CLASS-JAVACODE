package exam;

import java.util.Arrays;

public class Exam10 {

    public static void remove(String[] a, int index, String s) {
    	for(int i=index; i<a.length-1;i++) {
    		a[i]=a[i+1];
    	}
    	a[a.length-1]=s;
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "b", "c", "d", "d", "e"};
        remove(a, 1, "f");
        remove(a, 3, "g");
        System.out.println(Arrays.toString(a));
    }
}
