package exam2;

import java.util.Arrays;

public class Exam02 {
	static String toString(Person[] a) {
		
		/************************
		 toString �޼ҵ带 ����Ϸ���
		 �� �޼ҵ忡�� toStirng�� ������ ����� �ϰ�
		 equals �޼ҵ� ���� ������ ����� �Ѵ�. 
		 *************************/
		return Arrays.toString(a);
	}

	public static void main(String[] args) {
		Person[] a = new Person[] { new Person("ȫ�浿", 18), new Person("�Ӳ���", 21) };

		System.out.println(toString(a));
	}
}
