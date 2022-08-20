package interfaceTask.com.traningapps.jobapp.jobms;

public interface IITJobService extends IJobService{
    ITJob addJob(ITJob itJob);
    ITJob findJobById(long id);
    ITJob[] findAll();
    ITJob[] findJobsByType(String type);
}
