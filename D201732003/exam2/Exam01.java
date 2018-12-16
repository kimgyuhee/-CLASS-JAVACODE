package exam2;

public class Exam01 {

	public static double average(int... a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum / (double)a.length;
	}
	//round : 반올림 pow:몇승 floor:내림 ceid:올림
	/*****************************
	 sum / (double)a.length	(O)
	 (double)sum / a.length (O)
	 (double)sum / (double)a.length (O)
	 (double) (sum / a.length) (X)

	 (1) 객체 연산자	객체 변수	객체 메소드
	 (2) 배열 연산자	배열
	 (3) 단항연산자
	 (4) 곱셈,나눗셈
	 (5) 덧셈,뺄셈
	 (6) 비교 연산자
	 (7) 비트 연산자
	 (8) 대입 연산자

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

