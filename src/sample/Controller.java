package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.*;


public class Controller {

    public void switchToAddNewPat(){
        stage.setScene(addNewPatientScene);
    }

    public void switchToMainScene(){
        stage.setScene(mainScene);
    }


}
