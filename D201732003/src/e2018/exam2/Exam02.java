package e2018.exam2;

import java.util.Arrays;

public class Exam02 {

	static String toString(Person[] a) {
		return Arrays.toString(a);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] a = new Person[] { new Person("È«±æµ¿", 18), new Person("ÀÓ²©Á¤", 21) };

        System.out.println(toString(a));

	}

}
