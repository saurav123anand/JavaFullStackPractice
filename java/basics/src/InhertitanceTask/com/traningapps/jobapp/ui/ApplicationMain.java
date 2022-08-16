package InhertitanceTask.com.traningapps.jobapp.ui;

import InhertitanceTask.com.traningapps.jobapp.companyms.Company;
import InhertitanceTask.com.traningapps.jobapp.jobms.ElectronicsJob;
import InhertitanceTask.com.traningapps.jobapp.jobms.ITJob;
import InhertitanceTask.com.traningapps.jobapp.jobms.Job;
import InhertitanceTask.com.traningapps.jobapp.jobms.JobStorage;

public class ApplicationMain {
    public static void main(String[] args) {
        JobStorage jobStorage=new JobStorage(100);
        //creating ITJob objects
        ITJob itJob1=new ITJob(1,"Software Engineer",new Company("2fgh","Wipro"),"java",
                2);
        ITJob itJob2=new ITJob(2,"ASE",new Company("yui67","Accenture"),"C++",
                3);
        ITJob itJob3=new ITJob(3,"Analyst",new Company("2fokgh","Capgemini"),"Python",
                1);
        ITJob itJob4=new ITJob(4,"Software Engineer",new Company("sfd78f","Persistent System"),"C#",
                4);
        jobStorage.addITJob(itJob1);
        jobStorage.addITJob(itJob2);
        jobStorage.addITJob(itJob3);
        jobStorage.addITJob(itJob4);

        //creating ElectronicsJob objects
        jobStorage.addElectronicsJob(5,"Operator",new Company("4yreh","Mahindra ltd"),"Multimeter",
                2);
        jobStorage.addElectronicsJob(6,"VLSI Engineer",new Company("dhfdy56","Bosch Group"),"Semiconductor",
                3);
        jobStorage.addElectronicsJob(7,"Multimeter Engineer",new Company("9dbsdh","NTPC"),"Voltmer",
                1);
        jobStorage.addElectronicsJob(8,"Software Engineer",new Company("df79sb","Mahindra ltd"),"C++",
                4);

        // displaying all the jobs
        System.out.println("displaying all the jobs");
        Job[] foundAllJobs=jobStorage.findAll();
        for (Job job:foundAllJobs){
            if(job!=null){
                System.out.println("id is "+job.getId()+" type is "+job.getType()+" company is "+job.getCompany());
                boolean isType=job instanceof ITJob;
                if(isType){
                    ITJob itJob=(ITJob)job;
                    System.out.println("language is "+itJob.getLanguage());
                    System.out.println("codingExperienceInYrs is "+itJob.getCodingExperienceInYrs());
                }
                else{
                    ElectronicsJob electronicsJob=(ElectronicsJob) job;
                    System.out.println("deviceUsed is "+electronicsJob.getDeviceUsed());
                    System.out.println("experienceWithDeviceInYrs is "+electronicsJob.getExperienceWithDeviceInYrs());
                }
            }
        }

        //finding job by id
        long id=6;
        System.out.println("finding job by id " + id+"******************");
        Job foundJob=jobStorage.findJobById(id);
        if(foundJob==null){
            System.out.println("there is no job associated with id "+id);
        }
        else{
            System.out.println("id is "+foundJob.getId()+" type is "+foundJob.getType()+" company is "+foundJob.getCompany());
            boolean isType=foundJob instanceof ITJob;
            if(isType){
                ITJob itJob=(ITJob)foundJob;
                System.out.println("language is "+itJob.getLanguage());
                System.out.println("codingExperienceInYrs is "+itJob.getCodingExperienceInYrs());
            }
            else{
                ElectronicsJob electronicsJob=(ElectronicsJob)foundJob;
                System.out.println("deviceUsed is "+electronicsJob.getDeviceUsed());
                System.out.println("experienceWithDeviceInYrs is "+electronicsJob.getExperienceWithDeviceInYrs());
            }
        }

        //finding jobs by type
        String type="Software Engineer";
        System.out.println("found jobs by type "+type);
        Job[] foundJobsByType=jobStorage.findJobsByType(type);
        for (Job job:foundJobsByType){
            if(job!=null){
                System.out.println("id is "+job.getId()+" type is "+job.getType()+" company is "+job.getCompany());
                boolean isType=job instanceof ITJob;
                if(isType){
                    ITJob itJob=(ITJob)job;
                    System.out.println("language is "+itJob.getLanguage());
                    System.out.println("codingExperienceInYrs is "+itJob.getCodingExperienceInYrs());
                }
                else{
                    ElectronicsJob electronicsJob=(ElectronicsJob) job;
                    System.out.println("deviceUsed is "+electronicsJob.getDeviceUsed());
                    System.out.println("experienceWithDeviceInYrs is "+electronicsJob.getExperienceWithDeviceInYrs());
                }
            }
        }





    }



}
