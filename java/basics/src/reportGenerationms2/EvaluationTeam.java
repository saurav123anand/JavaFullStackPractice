package reportGenerationms2;

import java.util.HashMap;
import java.util.Map;

public class EvaluationTeam {
    School school;
    public EvaluationTeam(School school) {
        this.school = school;
    }
    public Map<String, Double> TotalScoreOfEachStudent(){
        Student[] findAllStudents= school.findAll();
        Map<String,Double> marksOfEach=new HashMap<>();
            for (Student student:findAllStudents){
                if(student!=null){
                    double totalScore=0;
                    for(String key:student.getSubjectByScore().keySet()){
                        totalScore+=student.getSubjectByScore().get(key);
                    }
                    totalScore=totalScore/student.getSubjectByScore().size();
                    marksOfEach.put(student.getName(),totalScore);
                }

            }
        return marksOfEach;

    }
    public double averageMarksOfStandard(String standard){
        Student[] students= school.findStudentByStandard(standard);
        double avgMarks=0;
        for(Student student:students){
            double marksOfEach=0;
            if(student!=null){
                for(String key:student.getSubjectByScore().keySet()){
                    marksOfEach+=student.getSubjectByScore().get(key);
                    avgMarks+=marksOfEach/student.getSubjectByScore().size();
                }
            }
        }
        return avgMarks;
    }

}
