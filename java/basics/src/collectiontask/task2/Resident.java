package collectiontask.task2;

public class Resident {
    private String fullName;
    private int socialSecurityNumber;
    private char gender;

    public Resident(String fullName, int socialSecurityNumber, char gender) {
        this.fullName = fullName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "fullName='" + fullName + '\'' +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", gender=" + gender +
                '}';
    }
}
