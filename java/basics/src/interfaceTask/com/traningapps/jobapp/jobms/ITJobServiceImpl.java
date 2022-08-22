package interfaceTask.com.traningapps.jobapp.jobms;


public class ITJobServiceImpl extends AbstractJobService implements IITJobService {
    public ITJobServiceImpl(int capacity) {
        super(capacity);
    }
    @Override
    public ITJob addJob(ITJob itJob){
        Job job=super.addJob(itJob);
        return (ITJob) job;
       // return (ITJob)foundJob;
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
