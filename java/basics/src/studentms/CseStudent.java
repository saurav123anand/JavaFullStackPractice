package studentms;

public class CseStudent extends Student{
    private String programmingLang;

    public CseStudent() {
    }

    public CseStudent(String name, int age, int rollNo, String subject, String department,String programmingLang) {
        super(name, age, rollNo, subject, department);
        this.programmingLang = programmingLang;
    }

    public String getProgrammingLang() {
        return programmingLang;
    }

    public void setProgrammingLang(String programmingLang) {
        this.programmingLang = programmingLang;
    }
}
