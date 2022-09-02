package collectiondemo.mapdemo;

import java.util.*;

public class MapEx2 {
    public static void main(String[] args) {
        MapEx2 mapEx1=new MapEx2();
        Map<Integer,String> map=new LinkedHashMap<>();
        //adding elements
        map.put(2,"two");
        map.put(1,"one");
        map.put(3,"three");
        map.put(1,"ONE");
        System.out.println(map);

        // getting all the keys of map
        Set<Integer> keys=map.keySet();
        for(Integer key:keys){
            System.out.println("key is "+key);
        }

        // getting all the values of map
        Collection<String> values=map.values();
        for(String value:values){
            System.out.println("value is "+value);
        }

        // finding element by key
        String valueOfKey=map.get(2);
        System.out.println("value of key 2 is "+valueOfKey);

        System.out.println("getting key value pair of map");
        //looping on map
        mapEx1.display(map);

        //deleting element by key
        map.remove(2);
        System.out.println("key 2 has been removed");
        mapEx1.display(map);

        boolean isKey=map.containsKey(3);
        System.out.println("key is present "+isKey);

        boolean isValue=map.containsValue("three");
        System.out.println("value is present "+isValue);

    }

    void display(Map<Integer,String> map){
        Set<Integer> keys=map.keySet();
        for(Integer key:keys){
            System.out.println("key is "+key+" and value is "+map.get(key));
        }
    }

}
