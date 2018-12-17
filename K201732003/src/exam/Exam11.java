package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exam11 {

    public static void solution(int[] a, int distance) {
    	ArrayList<Integer> list = new ArrayList<>();
  
    	
    	for(int i=a.length-distance-1; i>=0;i--) {
    		a[i+distance]=a[i];
    	}
    	
    	for(int i=0; i<distance;i++) {
    		a[i]=-1;
    	}
    }

    public static void main(String[] args) {
        int[] a1 = { 3, 5, 6, 7, 9, 10, 12 };
        int[] a2 = { 9, 8, 10, 12, 14, 15 };
        solution(a1, 2);
        solution(a2, 3);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}
