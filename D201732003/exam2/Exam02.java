package exam2;

import java.util.Arrays;

public class Exam02 {
	static String toString(Person[] a) {
		
		/************************
		 toString 메소드를 사용하려면
		 그 메소드에서 toStirng을 재정의 해줘야 하고
		 equals 메소드 또한 재정의 해줘야 한다. 
		 *************************/
		return Arrays.toString(a);
	}

	public static void main(String[] args) {
		Person[] a = new Person[] { new Person("홍길동", 18), new Person("임꺽정", 21) };

		System.out.println(toString(a));
	}
}
