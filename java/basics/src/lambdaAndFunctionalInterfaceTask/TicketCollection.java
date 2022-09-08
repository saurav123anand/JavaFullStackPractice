package lambdaAndFunctionalInterfaceTask;

import java.util.List;

@FunctionalInterface
public interface TicketCollection {
    double calculate(List<TicketingData> ticketingDataList);
}
