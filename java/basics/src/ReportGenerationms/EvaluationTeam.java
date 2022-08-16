package ReportGenerationms;

import java.util.HashMap;
import java.util.Map;

public class EvaluationTeam {
    School school;
    public EvaluationTeam(School school) {
        this.school = school;
    }
    public Map<String, Integer> TotalScoreOfEachStudent(){
        Student[] findAllStudents= school.findAll();
        Map<String,Integer> marksOfEach=new HashMap<>();
            for (Student student:findAllStudents){
                if(student!=null){
                    marksOfEach.put(student.getName(),student.getScore());
                }

            }
        return marksOfEach;

    }
    public double averageMarksOfStandard(String standard){
        Student[] students= school.findStudentByStandard(standard);
        double totalMarks=0;
        int count=0;
        for(Student student:students){
            if(student!=null){
                totalMarks+=student.getScore();
                count++;
            }
        }
        double avgMarks=totalMarks/count;
        return avgMarks;
    }

}
