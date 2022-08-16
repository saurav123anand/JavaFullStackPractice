package ReportGenerationms;

import java.util.*;

public class SurveyTeam{
    School school;
    public SurveyTeam(School school){
        this.school=school;
    }
    public Map<String, String> findingGrade(){
        Map<String,String> foundGradedStudent=new HashMap<>();
        Student[] findAllStudents=school.findAll();
        for (Student student:findAllStudents){
            if(student!=null){
                String grade=calculateGrade(student.getScore(),student.getMaxScore());
                foundGradedStudent.put(student.getName(),grade);
            }
        }
        return foundGradedStudent;
    }
    public List<Student> displayAscending(String standard){
        List<Student> allStudents=new ArrayList<>();
        Student[] findStudentsByStandard=school.findStudentByStandard(standard);
        for(Student student:findStudentsByStandard){
            if(student!=null){
               allStudents.add(student);
            }
        }
        ScoreComparator scoreComparator=new ScoreComparator();
        allStudents.sort(scoreComparator);
        return allStudents;

    }

    public String calculateGrade(int score,int maxScore){
        if(score>=maxScore*0.9){
            return "Excellent";
        }
        if(score>=maxScore*0.7){
            return "outstanding";
        }
        if(score>=maxScore*0.6){
            return "Good";
        }
        return "Average";

    }
}
