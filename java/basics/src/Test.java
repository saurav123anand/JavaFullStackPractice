import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static String findCode(int input1) {
        String temp=String.valueOf(input1);
        Map<Integer,Character> maps=new HashMap<>();
        maps.put(0,'Z');
        maps.put(1,'O');
        maps.put(2,'T');
        maps.put(3,'T');
        maps.put(4,'F');
        maps.put(5,'F');
        maps.put(6,'S');
        maps.put(7,'S');
        maps.put(8,'E');
        maps.put(9,'N');
        Set<Integer> keys=maps.keySet();
        String result="";
        for(int i=0;i<temp.length();i++){
            result+=maps.get(temp.charAt(i)-'0');
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findCode(0));
    }
}
