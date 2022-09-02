package collectiondemo.listdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListEx1 {
    public static void main(String[] args) {
        ListEx1 listEx1=new ListEx1();
        List<String> fruits=new ArrayList<>();
        // adding the element in the ArrayList
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("apple");

        //remove
        //removing element by name
        fruits.remove("apple");
        //removing element by index
        fruits.remove(1);

        // finding element
        String element=fruits.get(2);
        System.out.println("fruit at index 2 is "+element);

        //displaying fruits
        listEx1.display(fruits);

        //getting the size
        int length=fruits.size();
        System.out.println("size="+length);

    }
    void display(Collection<String> fruits){
        for(String fruit:fruits){
            System.out.println("fruit name is "+fruit);
        }
    }
    
}
