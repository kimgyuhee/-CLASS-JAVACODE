package exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1 {

	static List<String> solution(String[] a1, String[] a2, String[] a3) {
		/***********************************************
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		
		for(int i=0;i<a1.length;i++)
			list1.add(a1[i]);
		
		for(int i=0;i<a2.length;i++)
			list2.add(a2[i]);
		
		for(int i=0;i<a3.length;i++)
			list3.add(a3[i]);
		
		list1.retainAll(list2);
		list1.retainAll(list3);
		
		return list1;
		**********************************************/
		List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(a1));
        list.retainAll(Arrays.asList(a2));
        list.retainAll(Arrays.asList(a3));
        return list;

	}

	public static void main(String[] args) {
		String[] a1 = { "A", "B", "D", "F", "G" };
		String[] a2 = { "B", "C", "F", "H", "I" };
		String[] a3 = { "B", "F", "G", "H", "I" };

		System.out.println(solution(a1, a2, a3));
	}
}
