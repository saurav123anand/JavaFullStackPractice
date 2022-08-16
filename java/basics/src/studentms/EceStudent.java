package studentms;

public class EceStudent extends Student{
    private String deviceUsed;

    public EceStudent() {

    }
    public EceStudent(String name, int age, int rollNo, String subject, String department, String deviceUsed) {
        super(name, age, rollNo, subject, department);
        this.deviceUsed = deviceUsed;
    }

    public String getDeviceUsed() {
        return deviceUsed;
    }

    public void setDeviceUsed(String deviceUsed) {
        this.deviceUsed = deviceUsed;
    }
}
