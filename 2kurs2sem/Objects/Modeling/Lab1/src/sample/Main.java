package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Arrays;

import static sample.Matrix.*;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();

    }


    public static void main(String[] args) {
        //Tests();
        launch(args);
    }

    static void Tests(){
        float[][] n = new float[][]{ {0, 2, 6, 1},
                                     {7, 19, 6, 2},
                                     {2, 3, 3, 3},
                                     {7 ,9, 4, 10}};


        n = MultiplyMatrix(n , ReversedMatrix(n));
        System.out.println("Одинична матриця");
        for (int i = 0 ; i < n.length ; i++) System.out.println(Arrays.toString(n[i]));

        System.out.println();


        float[][] k = new float[][]{ {0, 2, 6},
                                     {7, 0, 6},
                                    {2, 3, 5},
                                    {1 ,7, 4}};

        n = MultiplyMatrix(k , TransponateMatrix(k));

        k = TransponateMatrix(k);
        for (int i = 0 ; i < k.length ; i++) System.out.println(Arrays.toString(k[i]));
        System.out.println();

        for (int i = 0 ; i < n.length ; i++) System.out.println(Arrays.toString(n[i]));

    }
}
