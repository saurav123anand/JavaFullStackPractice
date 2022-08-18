package abstractTask.com.traningapps.jobapp.ui;

import abstractTask.com.traningapps.jobapp.companyms.Company;
import abstractTask.com.traningapps.jobapp.jobms.*;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        ITJobService itJobService = new ITJobService(20);
        ITJob itJob1 = new ITJob(1, "software", new Company("234fg", "Accenture"),
                "Java", 2);
        ITJob itJob2 = new ITJob(2, "Analyst", new Company("7ddb6", "Capgemini"),
                "C++", 4);
        ITJob itJob3 = new ITJob(3, "Testing", new Company("9gfh6", "CTS"),
                "Junit,Selenium,Kafka", 1);
        ITJob itJob4 = new ITJob(4, "Analyst", new Company("57fyg", "Atlassian"),
                "JavaScript", 6);
        itJobService.addJob(itJob1);
        itJobService.addJob(itJob2);
        itJobService.addJob(itJob3);
        itJobService.addJob(itJob4);

        // finding all IT Jobs
        System.out.println("finding all IT Jobs*************************");
        ITJob[] foundAllItJobs = itJobService.findAll();
        obj.display(foundAllItJobs);
        System.out.println("********************************");

        // finding IT Job by id
        long id = 2;
        System.out.println("finding IT Job by id " + id);
        ITJob foundItJobById = itJobService.findJobById(id);
        obj.display(foundItJobById);
        System.out.println("******************************************");

        // finding all IT Jobs by type
        String type="Analyst";
        System.out.println("finding all IT Jobs by type*************************");
        ITJob[] foundAllItJobsByType = itJobService.findJobsByType(type);
        obj.display(foundAllItJobsByType);

        // Electronics jobs********************************
        ElectronicJobService electronicJobService = new ElectronicJobService(30);
        ElectronicsJob electronicsJob1 = new ElectronicsJob(1, "semiconductor", new Company("3ref", "Mahindra Ltd"),
                "diode", 5);
        ElectronicsJob electronicsJob2 = new ElectronicsJob(2, "BJT Transistor", new Company("77ff7", "l&T"),
                "Transistor", 3);
        ElectronicsJob electronicsJob3 = new ElectronicsJob(3, "Semiconductor", new Company("8u6f7", "HCL"),
                "Resistor", 1);

        electronicJobService.addJob(electronicsJob1);
        electronicJobService.addJob(electronicsJob2);
        electronicJobService.addJob(electronicsJob3);

        // finding all IT Jobs
        System.out.println("finding all Electronics Jobs*************************");
        ElectronicsJob[] foundAllElectronicsJobs = electronicJobService.findAll();
        obj.display(foundAllElectronicsJobs);
        System.out.println("********************************");

        // finding IT Job by id
        long id2 = 2;
        System.out.println("finding Electronics Job by id " + id2);
        ElectronicsJob foundElectronicsJobById = electronicJobService.findJobById(id2);
        obj.display(foundElectronicsJobById);
        System.out.println("******************************************");

        // finding all IT Jobs by type
        String type2="Semiconductor";
        System.out.println("finding all Electronics Jobs by type*************************"+ type2);
        ElectronicsJob[] foundAllElectronicsJobsByType = electronicJobService.findJobsByType(type2);
        obj.display(foundAllElectronicsJobsByType);

    }

    public void display(ITJob[] jobs) {
        for (ITJob itJob : jobs) {
            display(itJob);

        }
    }
    public void display(ITJob itJob) {
        if (itJob != null) {
            System.out.println("id is " + itJob.getId() + " Type is " + itJob.getType() + " Company name is " +
                    itJob.getCompany().getName() + " language is " + itJob.getLanguage());
        }
    }
    public void display(ElectronicsJob[] jobs) {
        for (ElectronicsJob electronicsJob : jobs) {
            display(electronicsJob);

        }
    }

    public void display(ElectronicsJob electronicsJob) {
        if (electronicsJob != null) {
            System.out.println("id is " + electronicsJob.getId() + " Type is " + electronicsJob.getType() +
                    " Company name is " +electronicsJob.getCompany().getName() + " language is " + electronicsJob.getDeviceUsed());
        }
    }

}
