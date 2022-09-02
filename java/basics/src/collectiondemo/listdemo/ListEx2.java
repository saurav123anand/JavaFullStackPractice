package collectiondemo.listdemo;

import java.util.*;

public class ListEx2 {
    public static void main(String[] args) {
        ListEx2 listEx2=new ListEx2();
        List<String> fruits=new LinkedList<>();
        // adding the element in the LinkedList
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("apple");

        Collections.sort(fruits);

        //remove
        //removing element by name
        fruits.remove("apple");
        //removing element by index
        fruits.remove(1);

        // finding element
        String element=fruits.get(2);
        System.out.println("fruit at index 2 is "+element);

        //displaying fruits
        listEx2.display(fruits);

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
