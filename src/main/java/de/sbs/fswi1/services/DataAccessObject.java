package de.sbs.fswi1.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import de.sbs.fswi1.models.StudentDTO;

public class DataAccessObject {
    
private String pathAsString;

public DataAccessObject(String pathAsString){
    this.pathAsString = pathAsString;
    File file = new File(this.pathAsString);
    if (file.exists()) {
        file.delete();
    }
}

public boolean save(StudentDTO student) {
    try (FileWriter writer = new FileWriter(this.pathAsString, true)) {

        writer.append(student.getVorname()).append(",");
        writer.append(student.getNachname()).append(",");
        writer.append(student.getGeburtsdatum()).append(",");
        writer.append(student.getKlasse()).append("\n");

    } catch (IOException e) {
        return false;
    }    
    return true;
}

public List<StudentDTO> findAll() {
    List<StudentDTO> students = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(this.pathAsString))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            StudentDTO student = new StudentDTO(values[0], values[1], values[2], values[3]);
            students.add(student);
        }
    } catch (IOException e) {
        System.out.println("Fehler beim Lesen der CSV-Datei: " + e.getMessage());
    }
    return students;

    // neu: 02.07.24

    try (HttpClient client = HttpClient.newHttpClient()){

        HttpRequest request = 
            HttpRequest.newBuilder()
            .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
            .GET()
            .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            StringBuilder rawJason = new StringBuilder(response.body()
            .replace("[\n", ""])
            .replace("\n]")
            
            );

            return response.body();


    }






}

}
