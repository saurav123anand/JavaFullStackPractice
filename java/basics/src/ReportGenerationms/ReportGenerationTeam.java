package ReportGenerationms;

public class ReportGenerationTeam {
    School school;
    public ReportGenerationTeam(School school){
        this.school=school;
    }
    public Student findTopScorer(String standard){
        Student[] foundStudentByStandard=school.findStudentByStandard(standard);
        int topScorer=foundStudentByStandard[0].getScore();
        Student topScorerStudent=foundStudentByStandard[0];
        for(Student student:foundStudentByStandard){
            if(student!=null && student.getScore()>topScorer){
                topScorer=student.getScore();
                topScorerStudent=student;
            }
        }
        return topScorerStudent;
    }
    public Student[] passedStudents(){
        Student[] passed=new Student[5];
        Student[] foundStudents=school.findAll();
        int index=0;
        for (Student student:foundStudents){
            if(student!=null && student.getScore()>=student.getMaxScore()*0.6){
                passed[index]=student;
                index++;
            }
        }
        return passed;
    }
    public Student[] failedStudents(){
        Student[] failed=new Student[5];
        Student[] foundStudents=school.findAll();
        int index=0;
        for (Student student:foundStudents){
            if(student!=null && student.getScore()<student.getMaxScore()*0.6){
                failed[index]=student;
                index++;
            }
        }
        return failed;
    }
}
