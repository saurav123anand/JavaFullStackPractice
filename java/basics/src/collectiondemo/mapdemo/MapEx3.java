package collectiondemo.mapdemo;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapEx3 {
    public static void main(String[] args) {
        MapEx3 mapEx3=new MapEx3();
        IdKeyComparator idKeyComparator=new IdKeyComparator();
        Map<Integer,Student> students=new TreeMap<>(idKeyComparator);
        Student student1=new Student(3,"guchhu",29);
        Student student2=new Student(2,"scooby",28);
        Student student3=new Student(5,"eda",34);
        students.put(student1.getId(),student1);
        students.put(student2.getId(),student2);
        students.put(student3.getId(),student3);

        mapEx3.display(students);


    }

    void display(Map<Integer,Student> map){
        Set<Integer> keys=map.keySet();
        for(Integer key:keys){
            System.out.println("key is "+key+" and value is "+map.get(key));
        }
    }

}
