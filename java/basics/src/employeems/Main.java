package employeems;

public class Main {
    public static void main(String[] args) {
        EmployeeStore employeeStore=new EmployeeStore(100);
        Department department1=new Department("23fgh","Analyst");
        employeeStore.addEmployee(1,"sania",22,department1);
        Department department2=new Department("56ghth","Software");
        employeeStore.addEmployee(2,"Saurav",19,department2);
        Department department3=new Department("69nbol","HR");
        employeeStore.addEmployee(3,"Muskan",20,department3);

        //find all employees

        System.out.println("find all employees*****************************");
        Employee[] foundAll=employeeStore.findAll();
        for(Employee employee:foundAll){
            if(employee!=null){
                System.out.println("id is "+employee.getEmpId()+ " name is "+employee.getName()+" age is "+employee.getAge()+
                        " and department name is "+employee.getDepartment().getDepartmentName());
            }
        }
        System.out.println("find by id*****************************");
        Employee foundEmployee=employeeStore.findById(2);
        if(foundEmployee!=null){
            System.out.println("id is "+foundEmployee.getEmpId()+ " name is "+foundEmployee.getName()+" age is "+foundEmployee.getAge());
        }

    }


}
