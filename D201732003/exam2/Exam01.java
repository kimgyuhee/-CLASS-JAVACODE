package exam2;

public class Exam01 {

	public static double average(int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; ++i)
			sum += a[i];
		return sum / (double)a.length;
	}
	//round : ¹Ý¿Ã¸² pow:¸î½Â floor:³»¸² ceid:¿Ã¸²
	/*****************************
	 sum / (double)a.length	(O)
	 (double)sum / a.length (O)
	 (double)sum / (double)a.length (O)
	 (double) (sum / a.length) (X)

	 (1) °´Ã¼ ¿¬»êÀÚ	°´Ã¼ º¯¼ö	°´Ã¼ ¸Þ¼Òµå
	 (2) ¹è¿­ ¿¬»êÀÚ	¹è¿­
	 (3) ´ÜÇ×¿¬»êÀÚ
	 (4) °ö¼À,³ª´°¼À
	 (5) µ¡¼À,»¬¼À
	 (6) ºñ±³ ¿¬»êÀÚ
	 (7) ºñÆ® ¿¬»êÀÚ
	 (8) ´ëÀÔ ¿¬»êÀÚ

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

