package exam3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example4 {

    public static void main(String[] args) {
        String s = "<tr><td>È«±æµ¿</td><td>18</td></tr><tr><td>ÀÓ²©Á¤</td><td>19</td></tr>" +
                   "<span>false</span><div><span>true</span></div>";
       
        /******************************
        String regex="<(td|span)>((.+?))<";
        ********************************/
        
        String regex = "<([a-z]+)>([^<]+)</[a-z]+>";
        Pattern pattern=Pattern.compile(regex);
   
        Matcher matcher=pattern.matcher(s);
        while(matcher.find())
        	System.out.printf("TAG:%s  TEXT:%s \n",matcher.group(1),matcher.group(2));
    }
}
