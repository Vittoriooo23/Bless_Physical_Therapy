package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
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

    @FXML
    private Label dateLabel;

    @FXML
    private TextField searchName;


    private ObservableList<Patient> list;


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
        list = FXCollections.observableList(patients);
        setUpTable();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM / dd / yy");
        dateLabel.setText(LocalDate.now().format(myFormatObj));
        table.refresh();
    }


    @FXML
    void addButtonPush() throws IOException {

        stage.setScene(addNewPatientScene);

        table.refresh();

    }

    @FXML
    void deleteButtonPush() throws IOException {

        Patient patient = table.getSelectionModel().getSelectedItem();
        jdbc.deletePatientFromDB(patient.getId());

        table.refresh();

    }

    @FXML
    void search(KeyEvent keyEvent){
        String search = searchName.getText();
        search = search.toLowerCase();
        ArrayList<Patient> searchList = new ArrayList<>();

        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getName().toLowerCase().startsWith(search)){
                searchList.add(patients.get(i));
            }
        }

        list = FXCollections.observableList(searchList);
        table.setItems(list);
        table.refresh();


        //attempt to make faster
        /*ArrayList<Integer> indexsToRemove = new ArrayList<>();
        if(searchList.isEmpty()){
            for(int i = 0; i < patients.size(); i++){
                if(patients.get(i).getName().toLowerCase().startsWith(search)){
                    searchList.add(patients.get(i));
                }
            }
        }
        else{
            for(int i = 0; i < searchList.size(); i++){
                if(searchList.get(i).getName().toLowerCase().startsWith(search)){
                    System.out.println(searchList.get(i).getName() + "   " + search);
                    searchList.set(i, searchList.get(i));
                }
                else{
                    indexsToRemove.add(i);
                }
            }
            System.out.println(indexsToRemove);
            for(int i = 0; i < indexsToRemove.size(); i++){
                searchList.remove(indexsToRemove.get(i));
            }
        }
        list = FXCollections.observableList(searchList);
        table.setItems(list);
        table.refresh();*/
    }

    @FXML
    void refresh(){
        initialize();
    }

    @FXML
    void keyPressed(KeyEvent keyEvent) throws IOException {     //delete key now deletes patients from table

        if (table.getSelectionModel().getSelectedItem() != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteButtonPush();
            }
        }
    }

    @FXML
    void tableClick(MouseEvent event){          //double-clicking a row in table opens new scene
        if(event.getClickCount() == 2){
            stage.setScene(patientSpecificsScene);
            Patient patient = table.getSelectionModel().getSelectedItem();

        }
    }


}
