package com.example.clinicaprivata.domain;

public class Medic extends Entity<Integer>{
    private Integer sectie;
    private String nume;
    private Integer vechime;
    private Boolean rezident;

    public Medic(Integer integer, Integer sectie, String nume, Integer vechime, Boolean rezident) {
        super(integer);
        this.sectie = sectie;
        this.nume = nume;
        this.vechime = vechime;
        this.rezident = rezident;
    }

    public Integer getSectie() {
        return sectie;
    }

    public void setSectie(Integer sectie) {
        this.sectie = sectie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVechime() {
        return vechime;
    }

    public void setVechime(Integer vechime) {
        this.vechime = vechime;
    }

    public Boolean getRezident() {
        return rezident;
    }

    public void setRezident(Boolean rezident) {
        this.rezident = rezident;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "sectie=" + sectie +
                ", nume='" + nume + '\'' +
                ", vechime=" + vechime +
                ", rezident=" + rezident +
                '}';
    }
}