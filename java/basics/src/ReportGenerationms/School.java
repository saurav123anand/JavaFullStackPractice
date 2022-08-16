package ReportGenerationms;

public class School {
    Student[] students;
    public School(){

    }
    public School(int capacity){
        students=new Student[capacity];
    }
    private int index=0;
    // adding students
    public void addStudent(Student student){
        if(index<students.length){
            students[index]=student;
            index++;
        }
    }
    public Student[] findStudentByStandard(String standard){
        Student[] foundStudents =new Student[5];
        int index=0;
        for (Student student:students){
            if(student!=null && student.getStandard().equalsIgnoreCase(standard)){
                foundStudents[index]=student;
                index++;
            }
        }
        return foundStudents;
    }

    // getting all the students
    public Student[] findAll(){
        return students;
    }


}
