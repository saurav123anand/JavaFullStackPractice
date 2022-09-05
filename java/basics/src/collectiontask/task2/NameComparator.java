package collectiontask.task2;

import java.util.Comparator;

public class NameComparator implements Comparator<Resident> {
    public int compare(Resident resident1, Resident resident2) {
        return resident1.getFullName().compareTo(resident2.getFullName());
    }
}
