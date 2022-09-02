package identityeqalitydemo;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    /**
     * if two objects are equal then they should have same hashcode
     * if two objects are not equal then they shouldn't have same hashcode
     * if two objects have same hashcode then they may or may not be equal
     * @return
     */
    @Override
    public int hashCode() {
        return id;
    }
}
