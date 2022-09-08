package lambdaAndFunctionalInterfaceTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketingOperations {
    private List<TicketingData> ticketingDataList = new ArrayList<>();

    //This method reads the sample.csv file provided and returns a List
    public List<TicketingData> readTicketingData(String fileName) {
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try{
            reader = new FileReader(fileName);
            bufferedReader = new BufferedReader(reader);
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values=line.split(",");
                TicketingData ticketingData=new TicketingData();
                ticketingData.setSchedule_no(values[0]);
                ticketingData.setRoute_no(values[1]);
                ticketingData.setTicket_from_stop_id(Integer.parseInt(values[2]));
                ticketingData.setTicket_from_stop_seq_no(Integer.parseInt(values[3]));
                ticketingData.setTicket_till_stop_id(Integer.parseInt(values[4]));
                ticketingData.setTicket_till_stop_seq_no(Integer.parseInt(values[5]));
                ticketingData.setTicket_date(values[6]);
                ticketingData.setTicket_time(values[7]);
                ticketingData.setTotal_ticket_amount(Integer.parseInt(values[8]));
                ticketingData.setTravelled_KM(Float.parseFloat(values[9]));
                ticketingDataList.add(ticketingData);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ticketingDataList;
    }

    //This method sorts the data based on the kms travelled by a bus (route)
    public List<TicketingData> sortByKmsTravelled(List<TicketingData> ticketingDataList) {
        KMCompaarator kmCompaarator=new KMCompaarator();
        ticketingDataList.sort(kmCompaarator);
        //second way
        //Collections.sort(ticketingDataList,kmCompaarator);
        return ticketingDataList;
    }

    //This method calculates the total revenue from ticket collection amount
    public double totalAmountCollected(List<TicketingData> ticketingDataList)
    {
       TicketCollection ticketCollection=new TicketCollection() {
           double totalRevenue=0;
           @Override
           public double calculate(List<TicketingData> ticketingDataList1) {
               for (TicketingData ticketingData:ticketingDataList1){
                   totalRevenue+=ticketingData.getTotal_ticket_amount();
               }
               return totalRevenue;
           }
       };
       return ticketCollection.calculate(ticketingDataList);


    }





}
