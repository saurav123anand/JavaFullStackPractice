package collectiondemo.setdemo;

import collectiondemo.listdemo.ListEx1;

import java.util.*;

public class SetEx1 {
    public static void main(String[] args) {
        SetEx1 setEx1=new SetEx1();
        Set<String> fruits=new HashSet<>();

        // adding the element in the HashSet
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
        setEx1.display(fruits);

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
