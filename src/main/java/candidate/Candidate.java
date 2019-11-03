package candidate;

import department.DepartmentNames;

public class Candidate {
    private String fullName;
    private int levelOfCompetence;
    private DepartmentNames departmentName;
    private CandidateStatus status;
    private Gender gender;

    public Candidate(String fullName, int levelOfCompetence, DepartmentNames departmentName, Gender gender) {
        this.fullName = fullName;
        this.levelOfCompetence = levelOfCompetence;
        this.departmentName = departmentName;
        this.status = CandidateStatus.AWAITING_RESPONSE;
        this.gender = gender;
    }

    public Candidate() {

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLevelOfCompetence() {
        return levelOfCompetence;
    }

    public void setLevelOfCompetence(int levelOfCompetence) {
        this.levelOfCompetence = levelOfCompetence;
    }

    public DepartmentNames getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentNames departmentName) {
        this.departmentName = departmentName;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "fullName='" + fullName + '\'' +
                ", levelOfCompetence=" + levelOfCompetence +
                ", departmentName='" + departmentName + '\'' +
                ", status=" + status +
                '}' + '\n';
    }
}
