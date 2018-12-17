package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Exam15 {

    public static void solution(List<Integer> list) {
    	ListIterator<Integer> i = list.listIterator();
    	while(i.hasNext()) {
    		int n=i.next();
    		if(n<10)
    			i.add(n+10);
    	}
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.addAll(Arrays.asList(2, 3, 1, 22, 5, 8));
        list2.addAll(Arrays.asList(7, 33, 9, 4, 2, 6));
        solution(list1);
        solution(list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }
}
