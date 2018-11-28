import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Example6 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[20];
        
        for (int i = 0; i < a.length; ++i) 
            a[i] = random.nextInt(5);
        
        // 구현
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int key : a) {
        	Integer count = map.get(key);
        	if(count==null) count=0;
        	++count;
        	map.put(key, count);
        }
        
        for(int key : map.keySet()) {
        	System.out.printf("%d=%d   ", key, map.get(key));
        }
        
        /***************************
        int[] n = new int[5];
        for (int i = 0; i < a.length; ++i) {
            a[i] = random.nextInt(5);
        // 구현
            
            switch(a[i]) {
            case(0):{
            	n[0]++;
            	break;}
            case(1):{
            	n[1]++;
            	break;}
            case(2):{
            	n[2]++;
            	break;}
            case(3):{
            	n[3]++;
            	break;}
            default:{
            	n[4]++;
            	break;}
   
            }
        
        }
        
        for (int i = 0; i < n.length; ++i) {
        	System.out.print(i+"="+n[i]+"   ");
        }
      ***************************************/
    }
}
