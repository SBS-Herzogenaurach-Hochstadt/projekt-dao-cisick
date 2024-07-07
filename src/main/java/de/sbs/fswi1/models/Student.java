package de.sbs.fswi1.models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;


public class Student extends StudentDTO {
    protected Timestamp timestamp;
    
    public Student(String vorname, String nachname, String geburtsdatum, String klasse){
        super(vorname, nachname, geburtsdatum, klasse);
        this.timestamp = new Timestamp(System.nanoTime());
    }

    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student student = (Student) obj;
            return this.vorname == student.getVorname() && this.nachname == student.getNachname() && this.geburtsdatum == student.getGeburtsdatum() && this.klasse == student.getKlasse() && this.timestamp == student.getTimestamp();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.vorname.hashCode() + this.nachname.hashCode() + this.geburtsdatum.hashCode() + this.klasse.hashCode() + this.timestamp.hashCode();
    }

    public String getNachnameVorname(){
        return super.vorname + " " + super.nachname;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int getAlterInJahrenZuHeute(){
        LocalDate date = LocalDate.parse(this.geburtsdatum);
        LocalDate currentDate = LocalDate.now();
        return Period.between(date, currentDate).getYears();        
    }

}
