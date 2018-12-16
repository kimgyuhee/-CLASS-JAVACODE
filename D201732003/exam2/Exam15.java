package exam2;

import java.util.Arrays;

public class Exam15 {

	static void sort(int[] a) {
		Arrays.sort(a);
	}

	static int[] insert(int[] a, int value) {
		//배열 a에서 value를 찾아 위치를 반환
		int index = Arrays.binarySearch(a, value);
		//배열에서 value값을 찾으면
		//원상태의 배열을 반환
		if (index >= 0) return a;
		//value값을 찾지 못했다면 value값을 넣을 위치 선택
		index = -(index + 1);
		//배열의 값 하나 늘려줌
		int[] a2 = Arrays.copyOf(a, a.length + 1);
		//value값을 넣지 전까지 뒤에서 부터 원래 값을 대입
		for (int i = a2.length - 1; i > index; --i)
			a2[i] = a2[i - 1];
		//index자리에 value값 대입
		a2[index] = value;
		return a2;
	}

	public static void main(String[] args) {
		int[] a = { 3, 8, 1, 2, 4, 5, 7 };

		sort(a);
		System.out.println(Arrays.toString(a));

		a = insert(a, 2);
		a = insert(a, 6);
		System.out.println(Arrays.toString(a));
	}
}
