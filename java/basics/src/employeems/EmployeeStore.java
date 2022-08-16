package employeems;

import ReportGenerationms.Student;

public class EmployeeStore {
    Employee[] employees;
    public EmployeeStore(int capacity){
        employees=new Employee[capacity];
    }
    private int index=0;
    public void addEmployee(int empId, String name, int age, Department department){
        Employee employee=new Employee(empId,name,age,department);
        if(index<employees.length){
            employees[index]=employee;
            index++;
        }
    }
    public Employee findById(int empId){
        for(Employee employee:employees){
            if(employee!=null && employee.getEmpId()==empId){
                return employee;
            }
        }
        return null;
    }
    public Employee[] findAll(){
        return employees;
    }
}
