package identityeqalitydemo;

public class StudentMain {
    public static void main(String[] args) {
        Student student1=new Student(1,"scooby1",22);
        Student student2=new Student(1,"scooby1",22);
        System.out.println(student1==student2); //identity
        System.out.println(student1.equals(student2)); //equality


    }

}
