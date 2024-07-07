package de.sbs.fswi1.models;

public class StudentDTO extends Mensch {

    protected String klasse;

    public StudentDTO(String vorname, String nachname, String geburtsdatum, String klasse) {
    super(vorname, nachname, geburtsdatum);

    this.klasse = klasse;
    }

    public String getKlasse() {
        return klasse;
    }

    public String print() {
        return this.vorname + ", " + this.nachname + ", " + this.geburtsdatum + ", " + this.klasse;
    }

    public boolean equals(Object obj) {
        if(obj instanceof StudentDTO) {
            StudentDTO student = (StudentDTO) obj;
            return this.vorname == student.getVorname() && this.nachname == student.getNachname() && this.geburtsdatum == student.getGeburtsdatum() && this.klasse == student.getKlasse();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.vorname.hashCode() + this.nachname.hashCode() + this.geburtsdatum.hashCode() + this.klasse.hashCode();
    }
}