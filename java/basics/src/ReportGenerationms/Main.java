package ReportGenerationms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        School school = new School(100);
        Student student1 = new Student("sania fatima", 22, 3, "10th", 299,500);
        Student student2 = new Student("saurav", 37, 6, "12th", 456,500);
        Student student3 = new Student("Eda Yildiz", 14, 9, "10th", 375,500);
        Student student4 = new Student("Hebah", 19, 11, "10th", 172,500);
        // adding all the students
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);

        //getting all the students
        Student[] findAllStudents = school.findAll();
        System.out.println("find all students***********");
        obj.display(findAllStudents);

        // finding all students by standard
        String standard = "10th";
        Student[] findAllByStandard = school.findStudentByStandard(standard);
        System.out.println("find all students by standard " + standard + "**********");
        obj.display(findAllByStandard);


        // now evaluation team working
        EvaluationTeam evaluationTeam = new EvaluationTeam(school);
        Map<String, Integer> totalScore = evaluationTeam.TotalScoreOfEachStudent();
        System.out.println("total score of each student by evaluation team ******************");
        Set<String> keys = totalScore.keySet();
        for (String key : keys) {
            System.out.println("name is " + key + " score is " + totalScore.get(key));
            System.out.println("****");
        }
        System.out.println("average marks of standard************************");
        double avgMarksOfStandard = evaluationTeam.averageMarksOfStandard("10th");
        System.out.println("avg marks= " + avgMarksOfStandard);


        // now report generation team working
        ReportGenerationTeam reportGenerationTeam = new ReportGenerationTeam(school);
        System.out.println("top scorer is *************");
        Student topScorerOfTheStandard = reportGenerationTeam.findTopScorer("10th");
        obj.display(topScorerOfTheStandard);

        System.out.println("passed Students *************");
        Student[] getPassedStudents=reportGenerationTeam.passedStudents();
        obj.display(getPassedStudents);

        System.out.println("failed Students *************");
        Student[] getFailedStudents=reportGenerationTeam.failedStudents();
        obj.display(getFailedStudents);
        System.out.println("koi baat nhi seh lena thoda meri sania baby jiiiiii hum apke saath hai iss dukh ki ghadi mein");

        // now survey team working
        System.out.println("finding grade of each student *************");
        SurveyTeam surveyTeam=new SurveyTeam(school);
        Map<String,String> foundGradedStudents=surveyTeam.findingGrade();
        Set<String> nameKeys = foundGradedStudents.keySet();
        for (String key : nameKeys) {
            System.out.println("name is " + key + " grade is " + foundGradedStudents.get(key));
            System.out.println("****");
        }

        //score in ascending order
        System.out.println("finding student on the basis of ascending order of score *************");
        List<Student> foundInAscendingOrder=surveyTeam.displayAscending("10th");
        for(Student student:foundInAscendingOrder){
            if(student!=null){
                System.out.println("name is "+student.getName()+" roll no is "+student.getRollNo()+" score is "+student.getScore());
            }
        }


    }

    public void display(Student[] students) {
        for (Student student : students) {
          display(student);
        }
    }

    public void display(Student student) {
        if (student !=null) {
            System.out.println("Name is " + student.getName());
            System.out.println("Age is " + student.getAge());
            System.out.println("Roll no is " + student.getRollNo());
            System.out.println("Standard is " + student.getStandard());
            System.out.println("Score is " + student.getScore());
            System.out.println("****");
        }
    }
}
