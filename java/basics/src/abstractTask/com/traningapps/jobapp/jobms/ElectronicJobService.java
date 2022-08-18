package abstractTask.com.traningapps.jobapp.jobms;
public class ElectronicJobService extends BaseJobService{

    public ElectronicJobService(int capacity) {
        super(capacity);
    }
    @Override
    public void addJob(Job job){
        super.addJob(job);
    }
    @Override
    public ElectronicsJob findJobById(long id){
        Job job=super.findJobById(id);
        return (ElectronicsJob) job;
    }
    @Override
    public ElectronicsJob[] findJobsByType(String type){
        ElectronicsJob[] electronicsJobs=new ElectronicsJob[5];
        int index=0;
        Job[] jobs=super.findJobsByType(type);
        for(Job job:jobs){
            if(index<electronicsJobs.length && job!=null){
                electronicsJobs[index]=(ElectronicsJob) job;
                index++;
            }
        }
        return electronicsJobs;
    }
    public ElectronicsJob[] findAll(){
        ElectronicsJob[] electronicsJobs=new ElectronicsJob[5];
        int index=0;
        Job[] jobs=super.findAll();
        for(Job job:jobs){
            if(index<electronicsJobs.length && job!=null){
                electronicsJobs[index]=(ElectronicsJob) job;
                index++;
            }
        }
        return electronicsJobs;
    }
}
