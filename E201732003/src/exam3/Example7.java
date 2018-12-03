package exam3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Example7 {

    static void solution(List<Integer> a) {
    	Iterator<Integer> i =a.iterator();
    	while(i.hasNext()) {
    		int n = i.next();
    		if(n%2==0||n%3==0)
    			i.remove();
    	}

    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 30; ++i)
            a.add(random.nextInt(8) + 1);
        System.out.println(a.toString());
        solution(a);
        System.out.println(a.toString());
    }
}

