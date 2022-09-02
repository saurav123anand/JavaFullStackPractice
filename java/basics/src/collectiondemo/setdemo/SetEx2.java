package collectiondemo.setdemo;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetEx2 {
    public static void main(String[] args) {
        SetEx2 setEx2=new SetEx2();
        Set<String> fruits=new LinkedHashSet<>();

        // adding the element in the LinkedHashSet
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("apple");

        //remove
        fruits.remove("pineapple");
        System.out.println(fruits);

        boolean isContains=fruits.contains("banana");
        System.out.println("banana is present "+isContains);

        //getting the size
        int length=fruits.size();
        System.out.println("size="+length);

        //displaying fruits
        setEx2.display(fruits);

        // check whether the set is empty or not
        boolean isBoolean=fruits.isEmpty();
        System.out.println("fruits is "+isBoolean);

    }

    void display(Collection<String> fruits){
        for(String fruit:fruits){
            System.out.println("fruit name is "+fruit);
        }
    }
}
