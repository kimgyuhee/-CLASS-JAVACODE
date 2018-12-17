package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam02 {

	public static void solution(List<String> list) {
		// 구현하라.
		List<String> result=new ArrayList<String>();
		result.addAll(list);
		list.clear();
		
		for(int i=0; i<result.size(); i++) {
			if(!list.contains(result.get(i)))
				list.add(result.get(i));
		}
		

	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("d", "a", "b", "a", "c", "d", "e", "f", "e"));
		solution(list);
		System.out.println(list);
	}
}
