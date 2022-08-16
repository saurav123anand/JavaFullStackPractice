package employeems;

public class Employee {
    private int empId;
    private String name;
    private int age;
    private Department department;

    public Employee() {
    }

    public Employee(int empId, String name, int age, Department department) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
