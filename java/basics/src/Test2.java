import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static int[] findTopper(int input1,int input2,List<Integer> input3) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=input2;i++){
            int value=Collections.max(input3,null);
            result.add(value);
            int index=input3.indexOf(value);
            input3.remove(index);
        }
        int[] arr=new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;

    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        System.out.println(Arrays.toString(findTopper(5, 3, list)));

    }
}
