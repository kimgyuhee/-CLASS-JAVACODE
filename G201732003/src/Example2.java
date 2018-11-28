import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example2 {

	static void add(List<Integer> list, int count) {
		// list ��Ͽ� 0���� count ���� ������ �߰��Ѵ�.
		for(int i=0; i<count; i++){
			list.add(i);
		}
	}
	// type ������ �ҽ��ڵ忡�� �����ϰ� �� ���� ��ü Ÿ����
	//�˻����� �ʴ´�.
	static void removeEven(List<Integer> list) {
		// list ��Ͽ��� ������ ���� �����Ѵ�.
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int i=iterator.next();
			if(i%2==0)
				iterator.remove();
		}
	}

	static void addEven(List<Integer> list) {
		// list ����� Ȧ�� ���� ���̿� ¦�� ���� �����Ѵ�.
		  
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
