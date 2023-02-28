package com.example.clinicaprivata.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultatie extends Entity<Integer>{
    private Integer medic;
    private Integer cnp;
    private String nume;
    private LocalDate datta;
    private LocalTime ora;

    public Consultatie(Integer id, Integer medic, Integer cnp, String nume, LocalDate datta, LocalTime ora) {
        super(id);
        this.medic = medic;
        this.cnp = cnp;
        this.nume = nume;
        this.datta = datta;
        this.ora = ora;
    }

    public Integer getMedic() {
        return medic;
    }

    public void setMedic(Integer medic) {
        this.medic = medic;
    }

    public Integer getCnp() {
        return cnp;
    }

    public void setCnp(Integer cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDate getDatta() {
        return datta;
    }

    public void setDatta(LocalDate datta) {
        this.datta = datta;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    @Override
    public String toString() {
        return "Consultatie{" +
                "medic=" + medic +
                ", cnp=" + cnp +
                ", nume=" + nume +
                ", datta=" + datta +
                ", ora=" + ora +
                '}';
    }
}