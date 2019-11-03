package department;

import candidate.Candidate;
import candidate.CandidateStatus;

public class Production extends Department {
    private static Production instance = new Production();
    public Production() {
        super(DepartmentNames.PRODUCTION, 8, 3);
    }

    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getLevelCompMin()) {
            candidate.setStatus(CandidateStatus.REJECTED);
        } else {
            candidate.setStatus(CandidateStatus.ACCEPTED);
        }
        return candidate.getStatus();
    }

    public static Production getInstance() {
        return instance;
    }

}
