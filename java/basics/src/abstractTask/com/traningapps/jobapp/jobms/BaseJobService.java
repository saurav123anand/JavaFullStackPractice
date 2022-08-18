package abstractTask.com.traningapps.jobapp.jobms;

public abstract class BaseJobService {
    Job[] jobs;
    public BaseJobService(int capacity){
        jobs=new Job[capacity];
    }
    private int index=0;
    public void addJob(Job job){
       if(index<jobs.length){
           jobs[index]=job;
           index++;
       }
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
