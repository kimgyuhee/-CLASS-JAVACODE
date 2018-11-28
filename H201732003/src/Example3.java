import java.util.ArrayList;
import java.util.Arrays;

public class Example3 {

    static void solution(int[] a) {
        // 배열 a에서 2의 배수와 3의 배수를 모두 제거하고
        // 제거된 항목의 뒷 항목들을 앞으로 당겨야 한다.
        // 제거된 항목 때문에 생간 배열 뒤의 공간에 -1을 채워라
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
        int[] a = new int[] {1, 6, 1, 8, 9, 2, 2, 3, 5, 3, 1, 3, 7};
        System.out.println(Arrays.toString(a));
        solution(a);
        System.out.println(Arrays.toString(a));
    }
}