import java.util.ArrayList;


public class Example3 {
	 public static void main(String[] args) {  
	 String[] a = { "d", "a", "b", "a", "c", "d", "e", "f", "e" };
	 ArrayList<String> list= new ArrayList<String>();
	 for(int i=0; i<a.length;i++) {
		 if(list.contains(a[i])==true)
			 continue;
		 list.add(a[i]);
	 }
	 System.out.println(list.toString());
	 
	 }
}
