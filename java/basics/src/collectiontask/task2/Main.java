package collectiontask.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main obj=new Main();
        ResidentService residentService=new ResidentService();
        // adding the Resident
        residentService.addResident(new Resident("Neelam",3203,'F'));
        residentService.addResident(new Resident("Azimul",4389,'M'));
        residentService.addResident(new Resident("Guchhu",256,'F'));

        System.out.println("Search for people with their social security number.*******");
        Resident foundResidentBySecurityNumber=residentService.searchResident(4389);
        System.out.println(foundResidentBySecurityNumber);

        //// Fetch the list of residents based on their gender.
        System.out.println("Fetch the list of residents based on their gender.************");
        List<Resident> foundResidentByGender=residentService.getAllResidentsByGender('F');
        obj.display(foundResidentByGender);

        // Sort the name of the residents in alphabetical order.
        System.out.println("Sort the name of the residents in alphabetical order.");
        List<Resident> residents=residentService.findAll();
        List<Resident> sortedList=residentService.getAllNamesSorted(residents);
        obj.display(sortedList);


    }
    public void display(List<Resident> residents){
        for(Resident resident:residents){
            System.out.println(resident);
        }
    }
}
