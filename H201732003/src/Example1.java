import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example1 {

	static int solution(List<Integer> list) {
		// 목록 a에서 가장 여러 번 등장하는 정수 값을 리턴하라
		int max=0;
		int maxKey=0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int key : list) {
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
		
		

	}

	public static void main(String[] args) {
		List<Integer> a =
				Arrays.asList(new Integer[] {1, 7, 1, 8, 5, 2, 2, 3, 5, 3, 1, 3, 7});
		System.out.println(a.toString());
		int maxValue = solution(a);
		System.out.println(maxValue);
	}
}
