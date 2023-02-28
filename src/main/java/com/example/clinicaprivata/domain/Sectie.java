package com.example.clinicaprivata.domain;

public class Sectie extends Entity<Integer>{
    private String nume;
    private Integer sef;
    private Integer pret;
    private Integer durata;

    public Sectie(Integer id, String nume, Integer sef, Integer pret, Integer durata) {
        super(id);
        this.nume = nume;
        this.sef = sef;
        this.pret = pret;
        this.durata = durata;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getSef() {
        return sef;
    }

    public void setSef(Integer sef) {
        this.sef = sef;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Sectie{" +
                "nume='" + nume + '\'' +
                ", sef=" + sef +
                ", pret=" + pret +
                ", durata=" + durata +
                '}';
    }
}