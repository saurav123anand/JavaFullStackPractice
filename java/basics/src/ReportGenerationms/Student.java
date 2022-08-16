package ReportGenerationms;

import java.util.Comparator;

public class Student{
    private String name;
    private int age;
    private int rollNo;
    private String standard;
    private int score;
    private int maxScore;
    private String grade;

    public Student() {
    }

    public Student(String name, int age, int rollNo, String standard, int score,int maxScore) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.standard = standard;
        this.score = score;
        this.maxScore=maxScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollNo=" + rollNo +
                ", standard='" + standard + '\'' +
                ", score=" + score +
                ", maxScore=" + maxScore +
                ", grade='" + grade + '\'' +
                '}';
    }
}
