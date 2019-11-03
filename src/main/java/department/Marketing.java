package department;

import candidate.Candidate;
import candidate.CandidateStatus;
import candidate.Gender;

public class Marketing extends Department{
    private static Marketing instance = new Marketing();
    private int maximMales = getOpenPosition() * 40 / 100;
    private int maximFemales = getOpenPosition() * 60 / 100;

    private Marketing() {
        super(DepartmentNames.MARKETING, 5, 4);
    }

    public static Marketing getInstance() {
        return instance;
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getLevelCompMin()) {
            candidate.setStatus(CandidateStatus.REJECTED);
        } else {
            candidate.setStatus(CandidateStatus.ACCEPTED);
        }
        return candidate.getStatus();
    }

    @Override
    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        if (candidate.getGender().equals(Gender.M)) {
            if (maximMales == 0) {
               return CandidateStatus.REJECTED;
            } else {
                maximMales = maximMales -1;
                return CandidateStatus.ACCEPTED;
            }
        } else if (candidate.getGender().equals(Gender.F)) {
            if (maximFemales == 0) {
                return CandidateStatus.REJECTED;
            } else {
                maximFemales = maximFemales -1;
                return CandidateStatus.ACCEPTED;
            }
        } return null;
    }

}
