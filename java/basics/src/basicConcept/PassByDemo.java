package basicConcept;

public class PassByDemo {
    public static void main(String[] args) {
        PassByDemo passByDemo=new PassByDemo();
        Student student=new Student("sania",22);
        passByDemo.meth1(student);
        System.out.println("name is "+student.getName()+" age is "+student.getAge());

    }
    public void meth1(Student student){
        student=new Student("sohan",25);
        System.out.println("name is "+student.getName()+" age is "+student.getAge());
    }
}
