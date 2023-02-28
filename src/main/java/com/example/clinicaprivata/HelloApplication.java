package com.example.clinicaprivata;

import com.example.clinicaprivata.domain.Consultatie;
import com.example.clinicaprivata.domain.Medic;
import com.example.clinicaprivata.domain.Sectie;
import com.example.clinicaprivata.repository.Repository;
import com.example.clinicaprivata.repository.database.ConsultatieDBRepository;
import com.example.clinicaprivata.repository.database.MedicDBRepository;
import com.example.clinicaprivata.repository.database.SectieDBRepository;
import com.example.clinicaprivata.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Repository<Integer, Sectie> sectieRepository = new SectieDBRepository();
        Repository<Integer, Medic> medicRepository = new MedicDBRepository();
        Repository<Integer, Consultatie> consultatieRepository = new ConsultatieDBRepository();
        Service service = new Service(sectieRepository, medicRepository, consultatieRepository);

        FXMLLoader sectiiLoader = new FXMLLoader(HelloApplication.class.getResource("sectie-view.fxml"));
        Scene sectiiScene = new Scene(sectiiLoader.load(), 600, 400);
        SectieController sectieController = sectiiLoader.getController();
        sectieController.initialize(service);
        stage.setTitle("Sectii");
        stage.setScene(sectiiScene);
        stage.show();

        service.getAllMedici().forEach(medic -> {
            FXMLLoader medicLoader = new FXMLLoader(HelloApplication.class.getResource("medic-view.fxml"));
            Stage medicStage = new Stage();
            Scene medicScene;

            try{
                medicScene = new Scene(medicLoader.load(),500,300);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
            MedicController clientController = medicLoader.getController();
            clientController.initialize(service, medic);

            medicStage.setTitle(medic.getNume());
            medicStage.setScene(medicScene);
            medicStage.show();
        });

    }
}