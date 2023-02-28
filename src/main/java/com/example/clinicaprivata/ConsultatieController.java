package com.example.clinicaprivata;

import com.example.clinicaprivata.domain.Medic;
import com.example.clinicaprivata.domain.Sectie;
import com.example.clinicaprivata.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ConsultatieController {

    private final ObservableList<Medic> medicModel = FXCollections.observableArrayList();

    private Service service;
    private Sectie sectie;
    @FXML
    private TextField numeTF;
    @FXML
    private TextField cnpTF;
    @FXML
    private Button programeazaButton;
    @FXML
    private TableView<Medic> mediciTableView;
    @FXML
    private DatePicker consultatieDatePicker;
    @FXML
    private Spinner<Integer> consultatieSpinner;
    @FXML
    private TableColumn<Medic, String> numeColumn;
    @FXML
    private TableColumn<Medic, Integer> vechImeColumn;
    @FXML
    private TableColumn<Medic, Boolean> rezidentColumn;

    public void initialize(Service service, Sectie sectie) {
        this.sectie = sectie;
        this.service = service;
        initModel();

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 20);
        consultatieSpinner.setValueFactory(valueFactory);

        numeColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
        vechImeColumn.setCellValueFactory(new PropertyValueFactory<>("vechime"));
        rezidentColumn.setCellValueFactory(new PropertyValueFactory<>("rezident"));
        mediciTableView.setItems(medicModel);
    }

    private void initModel() {
        Iterable<Medic> medici = service.getMediciBySectie(sectie.getId());
        List<Medic> medicList = StreamSupport.stream(medici.spliterator(), false).collect(Collectors.toList());
        medicModel.setAll(medicList);
    }

    public void onSelectedMedic(MouseEvent mouseEvent) {
    }

    public void onSelectedDate(ActionEvent actionEvent) {
    }

    public void onProgrameaza(ActionEvent actionEvent) {
        Medic medic = mediciTableView.getSelectionModel().getSelectedItem();
        LocalDate data = consultatieDatePicker.getValue();
        LocalTime ora = LocalTime.ofSecondOfDay(consultatieSpinner.getValue());
        String nume = numeTF.getText();
        Integer cnp = Integer.valueOf(cnpTF.getText());

        this.service.programeaza(medic,cnp,nume,data,ora);
    }
}