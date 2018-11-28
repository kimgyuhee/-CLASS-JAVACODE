import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example2 {

	static void add(List<Integer> list, int count) {
		// list 목록에 0부터 count 개의 정수를 추가한다.
		for(int i=0; i<count; i++){
			list.add(i);
		}
	}
	// type 정보는 소스코드에만 의존하고 그 실제 객체 타입을
	//검사하지 않는다.
	static void removeEven(List<Integer> list) {
		// list 목록에서 정수를 전부 제거한다.
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int i=iterator.next();
			if(i%2==0)
				iterator.remove();
		}
	}

	static void addEven(List<Integer> list) {
		// list 목록의 홀수 값들 사이에 짝수 값을 삽입한다.
		  
			int count = list.size();     
			if (count % 2 == 1) 
				list.add(count - 1);

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		add(list, 10);
		System.out.println(list.toString());

		removeEven(list);
		System.out.println(list.toString());

		addEven(list);
		System.out.println(list.toString());
	}
}
