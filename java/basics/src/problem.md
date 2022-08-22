base package com.traningapps.employee
subpackages :
employeems
departmentms
ui

employeems

enum Location{
  BANGALORE,
  PUNE
  KOLKATA
}
class Employee{
   long id;
   String name
   int age;
   String country
   String location,
   double salary;
}
class ITEmployee{
  //use your thinking here what u want to put here 
  // appropriate constructors and other things
}
class ElectronicsEmployee{
//use your thinking here what u want to put here
// appropriate constructors and other things
}
class CAEmployee{
//use your thinking here what u want to put here
// appropriate constructors and other things
}
interface IEmployee{
  // CRUD operation(adding,removing,updating,deleting employee)
// findAllEmployeeByLocation(*);
}
abstract EmployeeStore{
  // use your thinking(you will have to do anyhow )
}
EmployeeImpl{}


departmentms

class Department{
String id;
String name;
}

ui
main(){
}

END...................................


