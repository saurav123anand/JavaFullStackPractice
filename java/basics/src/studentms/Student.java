package studentms;

public class Student {
    private String name;
    private int age;
    private int rollNo;
    private String subject;
    private String department;

    public Student() {
    }

    public Student(String name, int age, int rollNo, String subject, String department) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.subject = subject;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
