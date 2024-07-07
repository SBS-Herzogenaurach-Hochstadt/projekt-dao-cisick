package de.sbs.fswi1.models;

public abstract class Mensch{

protected String vorname;
protected String nachname;
protected final String geburtsdatum;

public Mensch(String vorname, String nachname, String geburtsdatum){
this.vorname = vorname;
this.nachname = nachname;
this.geburtsdatum = geburtsdatum;
}

public String getVorname() {
    return vorname;
}

public String getNachname() {
    return nachname;
}

public String getGeburtsdatum() {
    return geburtsdatum;
}
// Warum in Mensch? Warum nochmal in Student?
// Hinweis: Nochmal in RQ1 sehen, da ist die Anweisung es in Mensch zu implementieren.
// Schule vergleich:
public boolean equals(Object other){

if (other == null){
    return false;
}

if (other == this){
    return false;
}

if (other.getClass() != this.getClass()){
    return false;
}

Mensch mensch = (Mensch) other;

// Aus Vereinfachungsgründen nur den Nachnamenvergleich
if (mensch.nachname.equals(this.nachname)){
    return true;
}

return false;

}



}