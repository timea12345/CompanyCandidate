package company;

import candidate.Candidate;
import candidate.CandidateStatus;
import candidate.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import department.Department;
import department.DepartmentNames;
import department.Marketing;
import department.Production;
import exceptions.EvaluationIncapacityException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private List<Candidate> candidates = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    public Company() {
        departments.add(Marketing.getInstance());
        departments.add(Production.getInstance());
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void recruiting() {
        readFromFile();

        Collections.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.getLevelOfCompetence() > o2.getLevelOfCompetence()) {
                    return -1;
                } else if (o1.getLevelOfCompetence() < o2.getLevelOfCompetence()) {
                    return 1;
                } else return 0;
            }
        });

        List<Candidate> candidatesInMarketing = new ArrayList<>();
        List<Candidate> candidatesInProd = new ArrayList<>();

        for (Candidate c: candidates) {
            if (c.getDepartmentName().equals(DepartmentNames.MARKETING)) {
               candidatesInMarketing.add(c);
            } else if (c.getDepartmentName().equals(DepartmentNames.PRODUCTION)) {
                candidatesInProd.add(c);
            } else {
                throw new EvaluationIncapacityException();
            }
        }
        List<Candidate> candidatesAccepted = getFinalCandidatesInMarketing(candidatesInMarketing);
        writeCandidateToJsonFile(candidatesAccepted);

    }

    public int getNumberOfFemales() {
        int count = 0;
        for (Candidate c: this.candidates) {
            if(c.getGender().equals(Gender.F)) {
                count++;
            }
        } return count;
    }

    public int getNumberOfFemalesUsingStreams() {
        return this.candidates.stream().filter(candidate -> candidate.getGender().equals(Gender.F)).collect(Collectors.toList()).size();
    }

    public int getNumberOfMalesUsingStreams() {
        return this.candidates.stream().filter(candidate -> candidate.getGender().equals(Gender.M)).collect(Collectors.toList()).size();
    }

    private List<Candidate> getFinalCandidatesInMarketing(List<Candidate> candidatesForMarketing) {

        Marketing marketing = Marketing.getInstance();
        List<Candidate> finalCandidates = new ArrayList<>();

        if (candidatesForMarketing.isEmpty()) {
            System.out.println("no candidates for marketing");
            return finalCandidates;
        }

        for (Candidate c: candidatesForMarketing) {
            CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);
            c.setStatus(firstResponse);
            if (firstResponse.equals(CandidateStatus.ACCEPTED)) {
                CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);

                if (finalResponse.equals(CandidateStatus.ACCEPTED)) {
                    finalCandidates.add(c);
                }
            }

        }
        System.out.println(finalCandidates);
        return finalCandidates;
    }

    private void writeCandidateToJsonFile(List<Candidate> candidates) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("accepted-candidate.json"), candidates);
        } catch (Exception e) {
            System.out.println("Writing to Json file has failed");
        }
    }

    private void readFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String input = new String (Files.readAllBytes(Paths.get("initial-candidates.json")));
            this.candidates = objectMapper.readValue(input, objectMapper.getTypeFactory().constructCollectionType(List.class, Candidate.class));
            System.out.println(candidates);
        } catch (IOException e) {
            System.out.println("reading from file failed");
        }
    }

}
