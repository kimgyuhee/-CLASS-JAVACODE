package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam01 {

	public static List<String> solution(List<String> list) {
		// 구현하라.
		List<String> result=new ArrayList<String>();
		
		for(int i=0; i<list.size(); i++) {
			if(!result.contains(list.get(i)))
				result.add(list.get(i));
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.addAll(Arrays.asList("d", "a", "b", "a", "c", "d", "e", "f", "e"));
		List<String> list2 = solution(list1);
		System.out.println(list1);
		System.out.println(list2);
	}
}
