package lambdaAndFunctionalInterfaceTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TicketingOperations ticketingOperations=new TicketingOperations();
        System.out.println("getting all the ticketing data list********************");
        List<TicketingData> ticketingDataList=
                ticketingOperations.readTicketingData("D:/JavaFullStackPractice/java/basics/src/lambdaAndFunctionalInterfaceTask/sample.csv");
        for (TicketingData ticketingData:ticketingDataList){
            System.out.println(ticketingData);
        }
        System.out.println("*****************");

        System.out.println("sorted ticketing data list***********");
        List<TicketingData> sortedList= ticketingOperations.sortByKmsTravelled(ticketingDataList);
        for (TicketingData ticketingData:ticketingDataList){
            System.out.println(ticketingData);
        }
        System.out.println("*****************");

        System.out.println("total amount collected*******************");
        double totalAmount=ticketingOperations.totalAmountCollected(ticketingDataList);
        System.out.println("total amount is "+totalAmount);


    }
}
