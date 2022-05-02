package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public static MyJDBC jdbc = new MyJDBC();

    public static Stage stage;
    public static Scene cScene, mainScene, addNewPatientScene;
    public static Controller controller = new Controller();



    @Override
    public void start(Stage primaryStage) throws Exception{

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        sceneSetup(primaryStage, screenSize);

        stage.setMaximized(true);
        stage.setTitle("Hello World");

        stage.setScene(mainScene);
        cScene = primaryStage.getScene();
        primaryStage.show();
    }

    private void sceneSetup(Stage primaryStage, Rectangle2D screenSize) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        mainScene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());

        root = FXMLLoader.load(getClass().getResource("addNewPatientScene.fxml"));
        addNewPatientScene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());

        stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
