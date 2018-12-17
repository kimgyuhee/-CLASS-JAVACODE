package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam07 {

    public static List<Integer> toList(int... a) {
    	List<Integer> list=new ArrayList<>();
    	
    	for(int n : a) {
    		list.add(n);
    	}
    	
    	return list;
    	
    }

    public static void main(String[] args) {
        System.out.println(toList(7));
        System.out.println(toList(2, 3, 5));
        System.out.println(toList(7, 3, 4, 5, 6));
    }
}
