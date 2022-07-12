package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static sample.Main.mainScene;
import static sample.Main.stage;

public class PatientSpecificsController {

    private Patient patient;

    public PatientSpecificsController(){

    }

    public void getPatient(Patient patient){
        this.patient = patient;
    }

    @FXML
    private Label name;


    public void initialize() {

    }

    @FXML
    void backToMain(ActionEvent event){
        stage.setScene(mainScene);
    }
}
