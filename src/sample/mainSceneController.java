package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

;import static sample.Main.*;
import static sample.Office.patients;

public class mainSceneController {

    @FXML
    private TableView<Patient> table;

    @FXML
    private TableColumn<Patient, Integer> id;

    @FXML
    private TableColumn<Patient, String> nameCol;

    @FXML
    private TableColumn<Patient, String> addressCol;

    @FXML
    private TableColumn<Patient, String> doaCol;

    @FXML
    private TableColumn<Patient, String> dobCol;

    @FXML
    private TableColumn<Patient, String> partsCol;

    @FXML
    private TableColumn<Patient, Integer> countCol;



    ObservableList<Patient> list = FXCollections.observableList(patients);
    private void setUpTable(){
        id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
        doaCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("doa"));
        dobCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("dob"));
        partsCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("parts"));
        countCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("count"));

        table.setItems(list);
    }

    @FXML
    public void initialize(){
        setUpTable();
    }


    @FXML
    void addButtonPush(ActionEvent event) throws IOException {

        controller.switchToAddNewPat();

        Patient patient = new Patient("a","ads","ad","adsf","adsf",1,0);
        jdbc.addPatientToDB(patient);

        table.refresh();

    }

    @FXML
    void deleteButtonPush(ActionEvent event) throws IOException {

        Patient patient = table.getSelectionModel().getSelectedItem();
        jdbc.deletePatientFromDB(patient.getId());

        table.refresh();

    }


}
