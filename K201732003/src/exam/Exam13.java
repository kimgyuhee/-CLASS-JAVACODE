package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Exam13 {

	static class Data {
		private int i;
		private String s;
		public Data(int i, String s) {
			this.i = i;
			this.s = s;
		}

		@Override
		public boolean equals(Object obj) {
			if(this==obj) return true;
			if(obj instanceof Data == false) return false;
			Data d=(Data)obj;
			return Objects.equals(this.s, d.s) && this.i==d.i;
		}

		@Override
		public String toString() {
			return "Data("+i+", "+s+")";
		}
		
		@Override 
		public int hashCode() { 
			return Objects.hash(s, i);   
		}


	}

	public static void solution(Data[] a) {
		Map<Data, Integer> map = new HashMap<>();
		for(Data d : a) {
			Integer count = map.get(d);
			map.put(d, count == null ? 1 : count + 1);
		}
		
		for(Data key : map.keySet())
			System.out.println(key+" ="+map.get(key)+"ȸ");

	}


	public static void main(String[] args) {
		Data[] a = new Data[] {
				new Data(1, "a"), new Data(2, "b"), new Data(1, "a"), new Data(1, "a"),
				new Data(2, "b"), new Data(1, "c"), new Data(2, "b"), new Data(2, "a"),
				new Data(1, "c"), new Data(2, "a"), new Data(1, "a"), new Data(1, "b")
		};
		solution(a);
	}
}
