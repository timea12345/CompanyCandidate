package department;

import candidate.Candidate;
import candidate.CandidateStatus;

public interface Evaluator {
    CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate);
    CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate);

}
