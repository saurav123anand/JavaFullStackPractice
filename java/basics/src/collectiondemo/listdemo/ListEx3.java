package collectiondemo.listdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListEx3 {
    public static void main(String[] args) {
        ListEx3 listEx3=new ListEx3();
        List<Student> students=new ArrayList<>();
        Student student1=new Student(1,"guchhu",29);
        Student student2=new Student(2,"scooby",28);
        Student student3=new Student(3,"eda",34);

        students.add(student3);
        students.add(student1);
        students.add(student2);

        listEx3.display(students);
        //sorting the list
        AgeComparator ageComparator=new AgeComparator();
        students.sort(ageComparator);
        System.out.println("sorted list");
        listEx3.display(students);

    }
    void display(Collection<Student> students){
        for(Student student:students){
            System.out.println(student);
        }
    }
    
}
