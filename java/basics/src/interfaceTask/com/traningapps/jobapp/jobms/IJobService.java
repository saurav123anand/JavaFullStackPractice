package interfaceTask.com.traningapps.jobapp.jobms;

public interface IJobService {
    Job findJobById(long id);
    Job[] findAll();
}
