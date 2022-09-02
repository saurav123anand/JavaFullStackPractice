package collectiondemo.listdemo;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        //if we need in ascending order then student1.getAge()-student2.getAge();
        //if we want in descending order then student2.getAge()-student1.getAge();
        return student1.getAge()-student2.getAge();
    }
}
