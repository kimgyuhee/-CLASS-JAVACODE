import java.util.ArrayList;
import java.util.Arrays;

public class Example3 {

    static void solution(int[] a) {
        // �迭 a���� 2�� ����� 3�� ����� ��� �����ϰ�
        // ���ŵ� �׸��� �� �׸���� ������ ��ܾ� �Ѵ�.
        // ���ŵ� �׸� ������ ���� �迭 ���� ������ -1�� ä����
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