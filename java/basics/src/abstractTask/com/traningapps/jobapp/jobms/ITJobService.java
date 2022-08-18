package abstractTask.com.traningapps.jobapp.jobms;

public class ITJobService extends BaseJobService{

    public ITJobService(int capacity) {
        super(capacity);
    }
    @Override
    public void addJob(Job job){
        super.addJob(job);
    }
    @Override
    public ITJob findJobById(long id){
        Job job=super.findJobById(id);
        return (ITJob)job;
    }
    @Override
    public ITJob[] findJobsByType(String type){
        ITJob[] itJobs=new ITJob[5];
        int index=0;
        Job[] jobs=super.findJobsByType(type);
        for(Job job:jobs){
            if(index<itJobs.length && job!=null){
                itJobs[index]=(ITJob)job;
                index++;
            }
        }
        return itJobs;
    }
    public ITJob[] findAll(){
        ITJob[] itJobs=new ITJob[5];
        int index=0;
        Job[] jobs=super.findAll();
        for(Job job:jobs){
            if(index<itJobs.length && job!=null){
                itJobs[index]=(ITJob)job;
                index++;
            }
        }
        return itJobs;
    }
}
