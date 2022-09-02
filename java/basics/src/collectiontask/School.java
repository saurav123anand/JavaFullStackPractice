package collectiontask;

import java.util.*;

public class School {
    Map<Integer,Student> students=new LinkedHashMap<>();
    private int studentId;
    private int generateStudentId(){
        return ++studentId;
    }

    private int departmentId;
    private int generateDepartmentId(){
        return ++departmentId;
    }

    public void addStudent(Student student){
        int studId=generateStudentId();
        int deptId=generateDepartmentId();
        student.getDepartment().setId(deptId);
        student.setId(studId);
        students.put(studId,student);
    }

    public Student findById(int id){
        Set<Integer> keys=students.keySet();
        for(Integer key:keys){
            if(key==id){
                return students.get(key);
            }
        }
        return null;
    }

    public List<Student> findByName(String name){
        List<Student> foundstudents=new ArrayList<>();
        Set<Integer> keys=students.keySet();
        for(Integer key:keys){
            if(students.get(key).getName().equalsIgnoreCase(name)){
                foundstudents.add(students.get(key));
            }
        }
        return foundstudents;
    }



}
