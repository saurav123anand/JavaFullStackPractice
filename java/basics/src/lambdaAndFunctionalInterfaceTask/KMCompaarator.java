package lambdaAndFunctionalInterfaceTask;

import java.util.Comparator;

public class KMCompaarator implements Comparator<TicketingData> {

    @Override
    public int compare(TicketingData o1, TicketingData o2) {
        return (int)(o2.getTravelled_KM()-o1.getTravelled_KM());
    }
}
