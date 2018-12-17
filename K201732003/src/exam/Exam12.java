package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam12 {

	public static String solution(List<String> list) {
		 Map<String, Integer> map = new HashMap<>();
	        String maxValue=null;
	        int maxCount = 0;
	        for (String value : list) {
	            Integer count = map.get(value);
	            map.put(value, count == null ? 1 : count + 1);
	            if (map.get(value) > maxCount) {
	                maxCount = map.get(value);
	                maxValue = value;
	            }
	        }
	        return maxValue;
	}

	public static void main(String[] args) {
		List<String> a1 = Arrays.asList("a", "a", "b", "a", "c", "d", "e", "b", "e");
		List<String> a2 = Arrays.asList("b", "a", "d", "a", "a", "b", "i", "b", "b");
		System.out.println(solution(a1));
		System.out.println(solution(a2));
	}
}
