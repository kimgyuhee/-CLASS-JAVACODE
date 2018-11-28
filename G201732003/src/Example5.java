import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example5 {

    public static void main(String[] args) {
        String[] a1 = { "d", "a", "b", "a", "c", "a" };
        String[] a2 = { "b", "a", "f", "e", "b", "b" };
        // ±¸Çö
        
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        
        
        for(int i=0 ; i<a1.length;i++) {
        	if(list1.contains(a1[i])==true)
        		continue;
        	list1.add(a1[i]);
        }
        for(int i=0 ; i<a2.length;i++) {
        	if(list2.contains(a2[i])==true)
        		continue;
        	list2.add(a2[i]);
        }
       
        
        list1.removeAll(list2);
        
        System.out.println(list1.toString());
    }
}
