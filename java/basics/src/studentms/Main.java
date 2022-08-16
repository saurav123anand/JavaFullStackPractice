package studentms;

public class Main {
    public static void main(String[] args) {
        Student students[]=new Student[2];
        Student cseStudent=new CseStudent("mayank",21,2,"drawing","cse","c");
        Student EceStudent=new EceStudent("guchhu",22,3,"drawing","Ece","diode");
        students[0]=cseStudent;
        students[1]=EceStudent;
        for(Student student:students){
            System.out.println("name is "+student.getName());
            System.out.println("age is "+student.getAge());
            System.out.println("rollNo is "+student.getRollNo());
            System.out.println("subject is "+student.getSubject());
            System.out.println("department is "+student.getDepartment());
            boolean isCse=student instanceof CseStudent;
            if(isCse){
                CseStudent csestud=(CseStudent) student;
                System.out.println(csestud.getProgrammingLang());
            }
            boolean isEce=student instanceof EceStudent;
            if(isEce){
                EceStudent ecestud=(EceStudent) student;
                System.out.println(ecestud.getDeviceUsed());
            }
        }
    }
}
