package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

import static sample.Main.*;
import static sample.Office.patients;

public class addNewPatientSceneController {

    private DateTimeFormatter formatter;

    @FXML
    private TextField nameAdd;

    @FXML
    private TextField addressAdd;

    @FXML
    private TextField partsAdd;

    @FXML
    private DatePicker doaDate;

    @FXML
    private DatePicker dobDate;

    @FXML
    private CheckBox CS;

    @FXML
    private CheckBox TS;

    @FXML
    private CheckBox LS;

    @FXML
    private CheckBox R_SH;

    @FXML
    private CheckBox L_SH;

    @FXML
    private CheckBox R_KN;

    @FXML
    private CheckBox L_KN;




    public void initialize() {
        formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
    }

    private String getParts(){
        String parts = "";

        if(CS.isSelected()){
            parts = parts + "CS,  ";
        }
        if(TS.isSelected()){
            parts = parts + "TS,  ";
        }
        if(LS.isSelected()){
            parts = parts + "LS,  ";
        }
        if(R_SH.isSelected()){
            parts = parts + "R-SH,  ";
        }
        if(L_SH.isSelected()){
            parts = parts + "L-SH,  ";
        }
        if(R_KN.isSelected()){
            parts = parts + "R-KN,  ";
        }
        if(L_KN.isSelected()){
            parts = parts + "L-KN,  ";
        }

        return parts;
    }


    @FXML
    void addNewPatient(ActionEvent event){
        AddPatientException addPatientException;
        try{
            if(nameAdd.getText() == ""){
                addPatientException = new AddPatientException("Invalid Name");
                throw addPatientException;
            }
            if(addressAdd.getText() == ""){
                addPatientException = new AddPatientException("Invalid Address");
                throw addPatientException;
            }
            if(doaDate == null){
                addPatientException = new AddPatientException("Invalid DOA");
                throw addPatientException;
            }
            if(dobDate == null){
                addPatientException = new AddPatientException("Invalid DOB");
                throw addPatientException;
            }
            if(getParts() == ""){
                addPatientException = new AddPatientException("Invalid Parts");
                throw addPatientException;
            }

            Patient patient = new Patient(nameAdd.getText(), addressAdd.getText(), formatter.format(doaDate.getValue()), formatter.format(dobDate.getValue()), getParts(), 0, 0);


            jdbc.addPatientToDB(patient);

            stage.setScene(mainScene);
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setTitle("");
            alert.showAndWait();
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void backToMain(ActionEvent event){
        stage.setScene(mainScene);
    }


}
