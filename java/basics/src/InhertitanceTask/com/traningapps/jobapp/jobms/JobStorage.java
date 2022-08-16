package InhertitanceTask.com.traningapps.jobapp.jobms;

import InhertitanceTask.com.traningapps.jobapp.companyms.Company;

public class JobStorage {
    Job jobs[];

    public JobStorage(int capacity){
        jobs=new Job[capacity];
    }

    private int index=0;
    // adding IT Jobs
    public void addITJob(ITJob itJob){
        if(index< jobs.length){
            jobs[index]=itJob;
            index++;
        }
    }

    //add electronics job
    public void addElectronicsJob(long id, String type, Company company, String deviceUsed, int experienceWithDeviceInYrs){
        ElectronicsJob electronicsJob=new ElectronicsJob(id,type,company,deviceUsed,experienceWithDeviceInYrs);
        if(index< jobs.length){
            jobs[index]=electronicsJob;
            index++;
        }
    }

    //finding jobs by id
    public Job findJobById(long id){
        for(Job job:jobs){
            if(job!=null && job.getId()==id){
                return job;
            }
        }
        return null;
    }

    //finding jobs by type
    public Job[] findJobsByType(String type){
        Job foundJobs[]=new Job[23];
        int index=0;
        for(Job job:jobs){
            if(job!=null && job.getType().equalsIgnoreCase(type)){
                foundJobs[index]=job;
                index++;
            }
        }
        return foundJobs;
    }
    //getting all the jobs
    public Job[] findAll(){
        return jobs;
    }
}
