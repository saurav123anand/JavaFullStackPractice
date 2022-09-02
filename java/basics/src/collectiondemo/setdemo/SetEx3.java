package collectiondemo.setdemo;

import java.util.*;

public class SetEx3 {
    public static void main(String[] args) {
        //sorting the set
        NameComparator nameComparator=new NameComparator();
        SetEx3 setEx3=new SetEx3();
        Set<Student> students=new TreeSet<>(nameComparator);

        Student student1=new Student(1,"guchhu",29);
        Student student2=new Student(2,"scooby",28);
        Student student3=new Student(3,"eda",34);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        setEx3.display(students);

    }

    void display(Collection<Student> students){
        for(Student student:students){
            System.out.println(student);
        }
    }

}
