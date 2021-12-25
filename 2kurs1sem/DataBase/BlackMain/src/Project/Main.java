package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BlackMain");

        primaryStage.getIcons().add(new Image("Project/FXMLs/Ico.png"));


        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/Stages/StageEntrance.fxml"));

        primaryStage.setScene(new Scene(root ,Color.TRANSPARENT));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
