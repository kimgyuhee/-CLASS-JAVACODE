package e2018.exam2;

public class Exam01 {

	public static double average(int... a) {
		double sum=0;
		int size=a.length;
		for(int i=0;i<size;i++) {
			sum+=a[i];
		}
		
		return sum/size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 3, 4, 5 };

        System.out.println(average(2, 3));
        System.out.println(average(2, 3, 4));
        System.out.println(average(a));

	}

}
