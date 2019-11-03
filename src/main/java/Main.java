import candidate.Candidate;
import candidate.Gender;
import company.Company;
import department.Department;
import department.DepartmentNames;
import department.Marketing;
import department.Production;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Company myCompany = new Company();
//
//        myCompany.addCandidate(new Candidate("Ana", 9, DepartmentNames.MARKETING, Gender.F));
//        myCompany.addCandidate(new Candidate("Elena", 3, DepartmentNames.MARKETING, Gender.F));
//        myCompany.addCandidate(new Candidate("Maria", 4, DepartmentNames.PRODUCTION, Gender.F));
//        myCompany.addCandidate(new Candidate("Andrei", 10, DepartmentNames.PRODUCTION, Gender.M));
//        myCompany.addCandidate(new Candidate("Alex", 8, DepartmentNames.PRODUCTION, Gender.M));
//        myCompany.addCandidate(new Candidate("Cristina", 10, DepartmentNames.MARKETING, Gender.F));
//        myCompany.addCandidate(new Candidate("Vlad", 4, DepartmentNames.MARKETING, Gender.M));
//        myCompany.addCandidate(new Candidate("Andreea", 9, DepartmentNames.MARKETING, Gender.F));
//        myCompany.addCandidate(new Candidate("Alina", 7, DepartmentNames.MARKETING, Gender.F));
//        myCompany.addCandidate(new Candidate("Mihai", 6, DepartmentNames.MARKETING, Gender.M));
//        myCompany.addCandidate(new Candidate("Laurentiu", 10, DepartmentNames.MARKETING, Gender.M));
//

        myCompany.recruiting();

//        HashSet<Department> deps = new HashSet<Department>();
//        Marketing m1 = Marketing.getInstance();
//        Marketing m2 = Marketing.getInstance();
//        Production p = new Production();
//
//        deps.add(m1);
//        deps.add(m2);
//        deps.add(p);
    }

}
