package exam3;

import java.util.Arrays;
import java.util.Random;

public class Example6 {

	static void solution(int[] a) {
		int count=0;
		int n=0;
    	for(int i : a) {
    		if(i%2==0||i%3==0)
    			continue;
    		else {
    			a[n]=i;
    			n++;
    		}
    	}
    	
    	for(int index=n; index<a.length;index++) {
    		a[index]=-1;
    	}

	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[30];
		for (int i = 0; i < 30; ++i)
			a[i] = random.nextInt(8) + 1;
		System.out.println(Arrays.toString(a));
		solution(a);
		System.out.println(Arrays.toString(a));
	}
}
