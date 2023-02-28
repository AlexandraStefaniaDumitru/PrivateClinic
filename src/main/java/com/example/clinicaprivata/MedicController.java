package com.example.clinicaprivata;

import com.example.clinicaprivata.domain.Consultatie;
import com.example.clinicaprivata.domain.Medic;
import com.example.clinicaprivata.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MedicController {

    private final ObservableList<Consultatie> consultatieModel = FXCollections.observableArrayList();

    public TableView<Consultatie> consultatiiTableView;
    public TableColumn<Consultatie, Integer> cnpColumn;
    public TableColumn<Consultatie, String> numeColumn;
    public TableColumn<Consultatie, LocalDate> dattaColumn;
    public TableColumn<Consultatie, LocalTime> oraColumn;
    private Service service;
    private Medic medic;

    public void initialize(Service service, Medic medic) {
        this.medic = medic;
        this.service = service;
        initModel();

        numeColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
        cnpColumn.setCellValueFactory(new PropertyValueFactory<>("cnp"));
        dattaColumn.setCellValueFactory(new PropertyValueFactory<>("datta"));
        oraColumn.setCellValueFactory(new PropertyValueFactory<>("ora"));
        consultatiiTableView.setItems(consultatieModel);
    }

    private void initModel() {
        Iterable<Consultatie> consultatii = service.getAllConsultatiiByMedic(medic.getId());
        List<Consultatie> consultatieList = StreamSupport.stream(consultatii.spliterator(), false).collect(Collectors.toList());
        consultatieModel.setAll(consultatieList);
    }
}