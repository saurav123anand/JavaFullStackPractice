package InhertitanceTask.com.traningapps.jobapp.jobms;

import InhertitanceTask.com.traningapps.jobapp.companyms.Company;

public class ITJob extends Job{
    private String language;
    private int codingExperienceInYrs;

    public ITJob() {
    }

    public ITJob(long id, String type, Company company, String language, int codingExperienceInYrs) {
        super(id, type, company);
        this.language = language;
        this.codingExperienceInYrs = codingExperienceInYrs;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCodingExperienceInYrs() {
        return codingExperienceInYrs;
    }

    public void setCodingExperienceInYrs(int codingExperienceInYrs) {
        this.codingExperienceInYrs = codingExperienceInYrs;
    }

    @Override
    public String toString() {
        return "ITJob{" +
                "language='" + language + '\'' +
                ", codingExperienceInYrs=" + codingExperienceInYrs +
                '}';
    }
}
