package de.sbs.fswi1;

public class Main {
    public static void main(String[] args) {
        
        DataAccessObject dao = new DataAccessObject("C:\Users\lisaf\OneDrive\Dokumente\data\Studenten.csv");
        List<StudentenDTO> studenten = dao.findAll();
        // C:\Users\lisaf\OneDrive\Dokumente\data
    }
}