package exam2;

public class Exam01 {

	public static double average(int... a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum / (double)a.length;
	}
	//round : �ݿø� pow:��� floor:���� ceid:�ø�
	/*****************************
	 sum / (double)a.length	(O)
	 (double)sum / a.length (O)
	 (double)sum / (double)a.length (O)
	 (double) (sum / a.length) (X)

	 (1) ��ü ������	��ü ����	��ü �޼ҵ�
	 (2) �迭 ������	�迭
	 (3) ���׿�����
	 (4) ����,������
	 (5) ����,����
	 (6) �� ������
	 (7) ��Ʈ ������
	 (8) ���� ������

	 Object[] a = getData();
	 String s = (String[])a[0];
	 
	 *****************************/
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5 };

		System.out.println(average(2, 3));
		System.out.println(average(2, 3, 4));
		System.out.println(average(a));
	}
}

