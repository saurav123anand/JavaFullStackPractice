package collectiontask.task2;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class ResidentService {
    List<Resident> residentList=new ArrayList<>();

    /**
     * create list of all the residents.
     */
    public boolean addResident(Resident resident){
        residentList.add(resident);
        return true;
    }

    //Search for people with their social security number.
    public Resident searchResident(int socialSecurityNumber){
        for(Resident resident:residentList){
            if(resident!=null && resident.getSocialSecurityNumber()==socialSecurityNumber){
                return resident;
            }
        }
        return null;
    }
    public List<Resident> findAll(){
        return residentList;
    }

    // Sort the name of the residents in alphabetical order.

    public List<Resident> getAllNamesSorted(List<Resident> residentsRepository){
        NameComparator nameComparator=new NameComparator();
        residentsRepository.sort(nameComparator);
        return residentsRepository;
    }

    // Fetch the list of residents based on their gender.
    public List<Resident> getAllResidentsByGender(char gender){
        List<Resident> foundResident=new ArrayList<>();
        for(Resident resident:residentList){
            if(resident!=null && resident.getGender()==gender){
                foundResident.add(resident);
            }
        }
        return foundResident;
    }

}
