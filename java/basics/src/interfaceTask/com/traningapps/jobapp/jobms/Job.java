package interfaceTask.com.traningapps.jobapp.jobms;

import interfaceTask.com.traningapps.jobapp.companyms.Company;

public class Job {
    private long id;

    private String type;

    private Company company;

    public Job() {
    }

    public Job(long id, String type, Company company) {
        this.id = id;
        this.type = type;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", type='" + type + '\'' +
                ", company=" + company +
                '}';
    }
}
