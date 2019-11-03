package department;

import candidate.Candidate;
import candidate.CandidateStatus;

public class Department implements Evaluator {

    private DepartmentNames name;
    private int levelCompMin;
    private int openPosition;

    public Department(DepartmentNames name, int levelCompMin, int openPosition) {
        this.name = name;
        this.levelCompMin = levelCompMin;
        this.openPosition = openPosition;
    }

    public DepartmentNames getName() {
        return name;
    }

    public void setName(DepartmentNames name) {
        this.name = name;
    }

    public int getLevelCompMin() {
        return levelCompMin;
    }

    public void setLevelCompMin(int levelCompMin) {
        this.levelCompMin = levelCompMin;
    }

    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate){
        return CandidateStatus.AWAITING_RESPONSE;
    }

    public int getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(int openPosition) {
        this.openPosition = openPosition;
    }

    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        return CandidateStatus.AWAITING_RESPONSE;
    }
}
