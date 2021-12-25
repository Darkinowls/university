package Project.Controllers;


import Project.DataBase.DHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ControllerEntrance {


    @FXML
    private AnchorPane Pane;

    @FXML
    private Button ButtonEntrance;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField LoginField;


    @FXML
    void initialize() {


        makeStageDraggable(Pane);

        ButtonEntrance.setOnAction(event -> {

            String Login ;
            String Password ;


            try {

                ResultSet rs = new DHandler().executeQuery("Select * from mydb.Users ");

                while (rs.next()) {

                    Login = rs.getString(2);
                    Password = rs.getString(3);


                    if (Login.equals(LoginField.getText().toLowerCase().trim()) &&
                            Password.equals(PasswordField.getText().toLowerCase())) goToMenu();
                    else {
                        LoginField.setStyle(" -fx-text-box-border: #B22222");
                        PasswordField.setStyle(" -fx-text-box-border: #B22222 ");
                    }


            }
            } catch(SQLException e){
                e.printStackTrace();
            }




        });
    }


    private void goToMenu() {
        ButtonEntrance.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("/Project/FXMLs/Stages/StageMenu.fxml")));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("BlackMain");
        stage.getIcons().add( new Image("Project/FXMLs/Ico.png"));
        stage.showAndWait();

    }

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void makeStageDraggable(Node Panel) {

        Panel.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();

        });

        Panel.setOnMouseDragged(event -> {
            Stage stage = (Stage) Panel.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }


}

