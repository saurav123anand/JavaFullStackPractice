package interfaceTask.com.traningapps.jobapp.jobms;

import interfaceTask.com.traningapps.jobapp.companyms.Company;

public class ElectronicsJob extends Job {
    private String deviceUsed;
    private int experienceWithDeviceInYrs;

    public ElectronicsJob() {
    }

    public ElectronicsJob(long id, String type, Company company, String deviceUsed, int experienceWithDeviceInYrs) {
        super(id, type, company);
        this.deviceUsed = deviceUsed;
        this.experienceWithDeviceInYrs = experienceWithDeviceInYrs;
    }

    public String getDeviceUsed() {
        return deviceUsed;
    }

    public void setDeviceUsed(String deviceUsed) {
        this.deviceUsed = deviceUsed;
    }

    public int getExperienceWithDeviceInYrs() {
        return experienceWithDeviceInYrs;
    }

    public void setExperienceWithDeviceInYrs(int experienceWithDeviceInYrs) {
        this.experienceWithDeviceInYrs = experienceWithDeviceInYrs;
    }

    @Override
    public String toString() {
        return "ElectronicsJob{" +
                "deviceUsed='" + deviceUsed + '\'' +
                ", experienceWithDeviceInYrs=" + experienceWithDeviceInYrs +
                '}';
    }
}
