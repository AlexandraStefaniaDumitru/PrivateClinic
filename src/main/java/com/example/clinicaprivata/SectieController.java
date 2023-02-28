package com.example.clinicaprivata;

import com.example.clinicaprivata.domain.Sectie;
import com.example.clinicaprivata.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SectieController {
    private final ObservableList<Sectie> sectieModel = FXCollections.observableArrayList();
    Service service;
    @FXML
    private TableView<Sectie> sectiiTableView;
    @FXML
    private TableColumn<Sectie, Integer> idColumn;
    @FXML
    private TableColumn<Sectie, String> numeColumn;
    @FXML
    private TableColumn<Sectie, Integer> sefColumn;
    @FXML
    private TableColumn<Sectie, Integer> pretColumn;
    @FXML
    private TableColumn<Sectie, Integer> durataColumn;

    public void initialize(Service service) {
        this.service = service;
        initModel();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        numeColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
        sefColumn.setCellValueFactory(new PropertyValueFactory<>("sef"));
        pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));
        durataColumn.setCellValueFactory(new PropertyValueFactory<>("durata"));
        sectiiTableView.setItems(sectieModel);
    }

    private void initModel() {
        Iterable<Sectie> secties = service.getAllSectii();
        List<Sectie> sectieList = StreamSupport.stream(secties.spliterator(), false).collect(Collectors.toList());
        sectieModel.setAll(sectieList);
    }

    public void onSelectedSectie(MouseEvent mouseEvent) {
        Sectie sectie = sectiiTableView.getSelectionModel().getSelectedItem();
        FXMLLoader consultatieLoader = new FXMLLoader(HelloApplication.class.getResource("consultatie-view.fxml"));
        Stage consultatieStage = new Stage();
        Scene consultatieScene;

        try {
            consultatieScene = new Scene(consultatieLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ConsultatieController consultatieController = consultatieLoader.getController();
        consultatieController.initialize(service, sectie);

        consultatieStage.setTitle("Consultatie " + sectie.getNume());
        consultatieStage.setScene(consultatieScene);
        consultatieStage.show();
    }
}