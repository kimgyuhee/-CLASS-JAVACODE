package exam3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Example8 {

	static int solution(List<Integer> a) {
		/************************************************
    	int max=0;
		int maxKey=0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int key : a) {
        	Integer count = map.get(key);
        	if(count==null) count=0;
        	++count;
        	map.put(key, count);
        	if(max<count) {
        		max=count;
        		maxKey=key;
        	}
        }

		return maxKey;
		 **********************************************/
		Map<Integer, Integer> map = new HashMap<>();
		for (int value : a) {
			Integer count = map.get(value);
			map.put(value, count == null ? 1 : count + 1);
		}
		int maxValue = 0, maxCount = 0;
		for (int value : map.keySet()) {
			if (map.get(value) > maxCount) {
				maxCount = map.get(value);
				maxValue = value;
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> a = new ArrayList<>();
		for (int i = 0; i < 20; ++i)
			a.add(random.nextInt(10) + 1);
		System.out.println(a.toString());
		int maxValue = solution(a);
		System.out.println(maxValue);
	}
}
