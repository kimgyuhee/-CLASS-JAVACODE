package exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example5 {

	static String[] convertToArray(String s) {
		/*******************************************
		ArrayList<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find())
			list.add(matcher.group(0));
		return list.toArray(new String[list.size()]);
		 **********************************************/
		s = s.replaceAll("^[^a-zA-Z]+", "");
		s = s.trim();

		return s.split("[^a-zA-Z]+");
	}

	public static void main(String[] args) {
		String[] a = { "  one 2 two, - Three,\t four; @ \t\nfive..,SIX)",
		"1 one 2 two, - Three,\t four; @ \t\nfive..,SIX)" };
		for (String s : a) {
			String[] t = convertToArray(s);
			System.out.println(Arrays.toString(t));
		}
	}
}
