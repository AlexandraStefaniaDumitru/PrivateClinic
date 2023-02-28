package com.example.clinicaprivata.service;

import com.example.clinicaprivata.domain.Consultatie;
import com.example.clinicaprivata.domain.Medic;
import com.example.clinicaprivata.domain.Sectie;
import com.example.clinicaprivata.domain.exceptions.EmptyStringException;
import com.example.clinicaprivata.domain.exceptions.NegativeNumberException;
import com.example.clinicaprivata.repository.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Service {
    private final Repository<Integer, Sectie> sectieRepository;
    private final Repository<Integer, Medic> medicRepository;
    private final Repository<Integer, Consultatie> consultatieRepository;

    public Service(Repository<Integer, Sectie> sectieRepository, Repository<Integer, Medic> medicRepository, Repository<Integer, Consultatie> consultatieRepository) {
        this.sectieRepository = sectieRepository;
        this.medicRepository = medicRepository;
        this.consultatieRepository = consultatieRepository;
    }

    public List<Sectie> getAllSectii() {
        List<Sectie> sectii = new ArrayList<>();
        this.sectieRepository.findAll().forEach(sectii::add);
        return sectii;
    }

    public List<Medic> getAllMedici() {
        List<Medic> medici = new ArrayList<>();
        this.medicRepository.findAll().forEach(medici::add);
        return medici;
    }

    public List<Consultatie> getAllConsultatii() {
        List<Consultatie> consultatii = new ArrayList<>();
        this.consultatieRepository.findAll().forEach(consultatii::add);
        return consultatii;
    }

    public List<Consultatie> getAllConsultatiiByMedic(Integer medic){
        List<Consultatie> consultatii = new ArrayList<>();
        for (Consultatie consultatie : this.getAllConsultatii()) {
            if (Objects.equals(medic, consultatie.getMedic())) {
                consultatii.add(consultatie);
            }
        }
        consultatii.sort(Comparator.comparing(Consultatie::getDatta).thenComparing(Consultatie::getOra));
        return consultatii;
    }

    public Iterable<Medic> getMediciBySectie(Integer sectie) {
        List<Medic> medici = new ArrayList<>();
        for (Medic medic : this.getAllMedici()) {
            if (Objects.equals(sectie, medic.getSectie())) {
                medici.add(medic);
            }
        }
        return medici;
    }

    public void programeaza(Medic medic, Integer cnp, String nume, LocalDate data, LocalTime ora) {
        Consultatie consultatie = new Consultatie(cnp, medic.getId(), cnp, nume, data, ora);
        System.out.println(consultatie);
        try {
            this.consultatieRepository.save(consultatie);
        } catch (EmptyStringException | NegativeNumberException e) {
            throw new RuntimeException(e);
        }
    }
}