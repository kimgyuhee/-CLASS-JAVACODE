package exam2;

import java.util.Arrays;

public class Exam15 {

	static void sort(int[] a) {
		Arrays.sort(a);
	}

	static int[] insert(int[] a, int value) {
		//�迭 a���� value�� ã�� ��ġ�� ��ȯ
		int index = Arrays.binarySearch(a, value);
		//�迭���� value���� ã����
		//�������� �迭�� ��ȯ
		if (index >= 0) return a;
		//value���� ã�� ���ߴٸ� value���� ���� ��ġ ����
		index = -(index + 1);
		//�迭�� �� �ϳ� �÷���
		int[] a2 = Arrays.copyOf(a, a.length + 1);
		//value���� ���� ������ �ڿ��� ���� ���� ���� ����
		for (int i = a2.length - 1; i > index; --i)
			a2[i] = a2[i - 1];
		//index�ڸ��� value�� ����
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
