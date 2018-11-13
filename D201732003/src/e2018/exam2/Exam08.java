package e2018.exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Exam08 {

	static Collection<String> intersection(Collection<String> c1, Collection<String> c2) {
		Collection<String> c3 = new ArrayList();
		Collection<String> c4 = new ArrayList();
		
		//c3에 c1 문자들 집어넣기
		for(String s : c1) {
			c3.add(s);
		}
		
		for(String a : c2) {
			if(c3.contains(a))
				c4.add(a);
		}
		
		return c4;
		
	}

	public static void main(String[] args) {
		Collection<String> c1 = Arrays.asList("a", "b", "c", "d");
		Collection<String> c2 = Arrays.asList("b", "d", "e", "f");
		Collection<String> c3 = intersection(c1, c2);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
	}
}
