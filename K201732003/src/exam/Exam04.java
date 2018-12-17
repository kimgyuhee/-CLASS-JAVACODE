package exam;

import java.util.Arrays;

public class Exam04 {

    public static String[] solution(String s) {
        // 구현하라.
    	s=s.replaceAll("[^-?0-9]+", " ");
    	s=s.trim();	
    	return s.split(" ");
    }

    public static void main(String[] args) {
        String s = "a1223 (235) 157, 7814; asd_32as";
        String[] a = solution(s);
        System.out.println(Arrays.toString(a));
    }
}
