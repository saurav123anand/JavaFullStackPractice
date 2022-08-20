package interfaceTask.com.traningapps.jobapp.jobms;

public interface IElectronicsJobService extends IJobService{
    ElectronicsJob addJob(ElectronicsJob electronicsJob);
    ElectronicsJob findJobById(long id);
    ElectronicsJob[] findAll();
    ElectronicsJob[] findJobsByType(String type);
}
