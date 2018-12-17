package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam06 {

	public static List<String> intersection(String[] a1, String[] a2) {
		List<String> a = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		a.addAll(Arrays.asList(a1));
		a.retainAll(Arrays.asList(a2));
		
		for(int i=0 ;i<a.size();i++) {
			if(!result.contains(a.get(i)))
				result.add(a.get(i));
		}
		
		return result;
	}

	public static void main(String[] args) {
		String[] a1 = { "a", "d", "a", "b", "b", "c" };
		String[] a2 = { "c", "a", "e", "f", "b", "g" };
		List<String> list = intersection(a1, a2);
		System.out.println(list.toString());
	}
}
