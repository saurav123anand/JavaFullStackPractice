package interfaceTask.com.traningapps.jobapp.jobms;

import interfaceTask.com.traningapps.jobapp.jobms.Job;

public abstract class AbstractJobService {
    Job[] jobs;
    public AbstractJobService(int capacity){
        jobs=new Job[capacity];
    }
    private int index=0;
    public Job addJob(Job job){
       if(index<jobs.length){
           jobs[index]=job;
           index++;
           return job;
       }
       return null;
    }
    public Job findJobById(long id){
        for(Job job:jobs){
            if(job!=null && job.getId()==id){
                return job;
            }
        }
        return null;
    }
    public Job[] findJobsByType(String type){
        Job[] foundJobs=new Job[5];
        int index=0;
        for(Job job:jobs){
            if(index<foundJobs.length && job!=null && job.getType().equalsIgnoreCase(type)){
                foundJobs[index]=job;
                index++;
            }
        }
        return foundJobs;
    }
    public Job[] findAll(){
        return jobs;
    }
}
