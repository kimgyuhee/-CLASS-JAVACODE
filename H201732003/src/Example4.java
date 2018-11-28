import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example4 {

    static String[] convertToArray(String s) {
        // ���ڿ� s���� �ܾ �����Ͽ� �ܾ� ��� �迭�� �����϶�.
        // �ܾ�� ���ĺ���θ� �����Ǿ�� �Ѵ�.
        // ���ϵǴ� �迭�� �ܾ�� ���� �ҹ��ڷ� ��ȯ�Ǿ�� �Ѵ�.
    	ArrayList list = new ArrayList();
    	String[] a=new String[5];
    	int n=0;
    	String regex="[a-zA-z]+";
    	
    	Pattern pattern=Pattern.compile(regex);
    	Matcher matcher=pattern.matcher(s);
    	
    	while(matcher.find())
    		list.add(matcher.group(0).toLowerCase());
    	
    	
    	list.toArray(a);
    	System.out.println(list.toString());
    	return a;
    	
    	
 
    }

    public static void main(String[] args) {
        String[] a = { "one 2 two, - Three,\t four; @ \t\nfive..,SIX)",
                       "1 one 2 two, - Three,\t four; @ \t\nfive..,SIX)" };
        for (String s : a) {
            String[] t = convertToArray(s);
            System.out.println(Arrays.toString(t));
        }
    }
}
