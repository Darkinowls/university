package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

import static sample.Methods.*;
import static sample.Reader.*;

public class Controller {

    float[] ARR_X = new float[4];
    float[] ARR_Y = new float[4];

    @FXML
    private Button BLagrange;
    @FXML
    private Button BNewton;
    @FXML
    private TextField Bx0;
    @FXML
    private Button BCompareLNN;
    @FXML
    private TextField FieldA;
    @FXML
    private TextField FieldB;
    @FXML
    private Button BChebishev;
    @FXML
    private Button BCreateNewLagrange;
    @FXML
    private Button BCompareTLN;
    @FXML
    private TextField FieldNodes;
    @FXML
    private TextField FieldX0;
    @FXML
    private TextField FieldX1;
    @FXML
    private TextField FieldX2;
    @FXML
    private TextField FieldX3;
    @FXML
    private Button BCalculate;
    @FXML
    private Label LabelY0;
    @FXML
    private Label LabelY1;
    @FXML
    private Label LabelY2;
    @FXML
    private Label LabelY3;
    @FXML
    private Button BNewtonGregory;
    @FXML
    private Button BCompareGN;
    @FXML
    private Button BSpline;
    @FXML
    private Button BCompareSN;
    @FXML
    private Button BSquares;
    @FXML
    private Button BCompareLGN;
    @FXML
    private Button BClean;
    @FXML
    private TextArea TextField = null;
    @FXML
    private Button BCount;
    @FXML
    private Button BCompareRow;
    @FXML
    private TextField x0;
    @FXML
    private TextField x1;
    @FXML
    private TextField x2;

    @FXML
    void initialize() {

        CalculateTable();

        BCalculate.setOnAction(event -> {

            CalculateTable();

        });

        BLagrange.setOnAction(event -> {

            float x = Float.parseFloat(Bx0.getText());


            System.out.println("Lagrange interpolation : ");
            TextField.setText(TextField.getText() + "Lagrange interpolation : \n");


            float f = LagrangeInterpolation(ARR_X, ARR_Y, x);
            System.out.println("f(" + x + ") = " + f);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + f + "\n");

        });

        BNewton.setOnAction(event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Newton interpolation : ");
            TextField.setText(TextField.getText() + "Newton interpolation : " + "\n");


            float f = NewtonInterpolation(ARR_X, ARR_Y, x);
            System.out.println("f(" + x + ") = " + f);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + f + "\n");

        });

        BCompareLNN.setOnAction(Event -> {
            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Comparing Lagrange, Newton & Native : ");
            TextField.setText(TextField.getText() + "Comparing Lagrange, Newton & Native : \n");


            float l = LagrangeInterpolation(ARR_X, ARR_Y, x);
            float n = NewtonInterpolation(ARR_X, ARR_Y, x);
            float f = MyFunctionCalc(x);

            System.out.println("when x = " + x);
            TextField.setText(TextField.getText() + "when x = " + x + "\n");

            System.out.println("Native function and Lagrange\n|" + f + " - " + l + "| = " + Math.abs(f - l));
            TextField.setText(TextField.getText() + "Native function and Lagrange\n|" + f + " - " + l + "| = "
                    + Math.abs(f - l) + "\n");

            System.out.println("Native function and Newton\n|" + f + " - " + n + "| = " + Math.abs(f - n));
            TextField.setText(TextField.getText() + "Native function and Newton\n|" + f + " - " + n + "| = "
                    + Math.abs(f - n) + "\n");

        });

        BChebishev.setOnAction(Event -> {

            float[] arr = ChebishevPoints(Float.parseFloat(FieldA.getText()),
                    Float.parseFloat(FieldB.getText()), Integer.parseInt(FieldNodes.getText()) - 1);

            System.out.println("Chebishev points : ");
            TextField.setText(TextField.getText() + "Chebishev points : " + "\n");

            System.out.println(Arrays.toString(arr));
            TextField.setText(TextField.getText() + Arrays.toString(arr) + "\n");

        });

        BCreateNewLagrange.setOnAction(Event -> {


            System.out.println("Minimized Lagrange interpolation : ");
            TextField.setText(TextField.getText() + "Minimized Lagrange interpolation : " + "\n");

            float x = Float.parseFloat(Bx0.getText());

            float f = MinLagrangeInterpolation(Float.parseFloat(FieldA.getText()),
                    Float.parseFloat(FieldB.getText()), Integer.parseInt(FieldNodes.getText()) - 1, x);

            System.out.println("f(" + x + ") = " + f);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + f + "\n");


        });

        BCompareTLN.setOnAction(Event -> {
            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Comparing Two Lagrange & Native : ");
            TextField.setText(TextField.getText() + "Comparing Two Lagrange & Native : " + "\n");


            float l = LagrangeInterpolation(ARR_X, ARR_Y, x);
            float n = MinLagrangeInterpolation(Float.parseFloat(FieldA.getText()),
                    Float.parseFloat(FieldB.getText()), Integer.parseInt(FieldNodes.getText()) - 1, x);
            float f = MyFunctionCalc(x);

            System.out.println("when x = " + x);
            TextField.setText(TextField.getText() + "when x = " + x + "\n");

            System.out.println("Native function and Old Lagrange\n|" + f + " - " + l + "| = " + Math.abs(f - l));
            TextField.setText(TextField.getText() + "Native function and Old Lagrange\n|" + f + " - " + l + "| = "
                    + Math.abs(f - l) + "\n");

            System.out.println("Native function and Minimized Lagrange\n|" + f + " - " + n + "| = " + Math.abs(f - n));
            TextField.setText(TextField.getText() + "Native function and Minimized Lagrange\n|" + f + " - " + n + "| = "
                    + Math.abs(f - n) + "\n");

        });

        BNewtonGregory.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Newton-Gregory interpolation : ");
            TextField.setText(TextField.getText() + "Newton-Gregory interpolation : " + "\n");

            float f = NewtonGregoryInterpolation(ARR_X, ARR_Y, x);
            System.out.println("f(" + x + ") = " + f);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + f + "\n");

        });

        BCompareGN.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Comparing Newton-Gregory & Native : ");
            TextField.setText(TextField.getText() + "Comparing Newton-Gregory & Native : " + "\n");


            float g = LagrangeInterpolation(ARR_X, ARR_Y, x);
            float f = MyFunctionCalc(x);

            System.out.println("when x = " + x);
            TextField.setText(TextField.getText() + "when x = " + x + "\n");

            System.out.println("Native function and Newton-Gregory\n|" + f + " - " + g + "| = " + Math.abs(f - g));
            TextField.setText(TextField.getText() + "Native function and Newton-Gregory\n|" + f + " - " + g + "| = "
                    + Math.abs(f - g) + "\n");

        });

        BSpline.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Spline interpolation : ");
            TextField.setText(TextField.getText() + "Spline interpolation : " + "\n");

            float f = SplineInterpolation(ARR_X, ARR_Y, x);
            System.out.println("f(" + x + ") = " + f);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + f + "\n");

        });

        BCompareSN.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Comparing Spline interpolation & Native : ");
            TextField.setText(TextField.getText() + "Comparing Spline interpolation & Native : " + "\n");

            float s = SplineInterpolation(ARR_X, ARR_Y, x);
            float f = MyFunctionCalc(x);

            System.out.println("when x = " + x);
            TextField.setText(TextField.getText() + "when x = " + x + "\n");

            System.out.println("Native function and Spline\n|" + f + " - " + s + "| = " + Math.abs(f - s));
            TextField.setText(TextField.getText() + "Native function and Spline\n|" + f + " - " + s + "| = "
                    + Math.abs(f - s) + "\n");

        });

        BSquares.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());

            System.out.println("Least squares interpolation : ");
            TextField.setText(TextField.getText() + "Least squares interpolation : " + "\n");


            float s = LeastSquares(new float[][]{ARR_X}, new float[][]{ARR_Y}, new float[]{x});
            System.out.println("f(" + x + ") = " + s);
            TextField.setText(TextField.getText() + "f(" + x + ") = " + s + "\n");

        });

        BCompareLGN.setOnAction(Event -> {

            float x = Float.parseFloat(Bx0.getText());


            System.out.println("Comparing Least squares, Newton-Gregory interpolations & Native : ");
            TextField.setText(TextField.getText() + "Comparing Least squares, Newton-Gregory interpolations & Native : "
                    + "\n");

            System.out.println("when x = " + x);
            TextField.setText(TextField.getText() + "when x = " + x + "\n");

            float s = LeastSquares(new float[][]{ARR_X}, new float[][]{ARR_Y}, new float[]{x});
            float n = NewtonGregoryInterpolation(ARR_X, ARR_Y, x);
            float f = MyFunctionCalc(x);

            System.out.println("Least squares interpolation and Newton-Gregory interpolation\n|" +
                    s + " - " + n + "| = " + Math.abs(s - n));
            TextField.setText(TextField.getText() + "Least squares interpolation and Newton-Gregory interpolation\n|" +
                    s + " - " + n + "| = " + Math.abs(s - n) + "\n");

            System.out.println("Least squares interpolation and Native\n|" + s + " - " + f + "| = " + Math.abs(s - f));
            TextField.setText(TextField.getText() + "Least squares interpolation and Native\n|" +
                    s + " - " + f + "| = " + Math.abs(s - f) + "\n");

        });

        BClean.setOnAction(Event -> {
            TextField.setText("");
        });

        BCount.setOnAction(Event -> {

            float[] x = new float[]{Float.parseFloat(x0.getText()),
                    Float.parseFloat(x1.getText()), Float.parseFloat(x2.getText())};



            System.out.println("Counting the Task : ");
            TextField.setText(TextField.getText() + "Counting the Task : " + "\n");

            float s = LeastSquares(ReadX(WIDTH , LENGTH, "E:\\Objects\\Modeling\\Lab1\\src\\sample\\data.txt"),
                    ReadY(WIDTH , LENGTH, "E:\\Objects\\Modeling\\Lab1\\src\\sample\\data.txt"), x);

            System.out.println("f" + Arrays.toString(x) + " = " + s);
            TextField.setText(TextField.getText() + "f" + Arrays.toString(x) + " = " + s + "\n");

        });

        BCompareRow.setOnAction(Event -> {

            String path = "E:\\Objects\\Modeling\\Lab1\\src\\sample\\data.txt";

            float[] x = firstX(WIDTH,path);
            float y = firstY(WIDTH, path);

            System.out.println("Comparing value with first row : ");
            TextField.setText(TextField.getText() + "Comparing value with first row : " + "\n");

            float s = LeastSquares(ReadX(WIDTH , LENGTH, path),
                    ReadY(WIDTH , LENGTH, path), x);

            System.out.println("Least Squares Function and first row\n|" +
                    s + " - " + y + "| = " + Math.abs(s - y));

            TextField.setText(TextField.getText() + "Least Squares Function and first row\n|" +
                    s + " - " + y + "| = " + Math.abs(s - y) + "\n");

        });

    }


    void CalculateTable() {
        ARR_X[0] = Float.parseFloat(FieldX0.getText());
        ARR_X[1] = Float.parseFloat(FieldX1.getText());
        ARR_X[2] = Float.parseFloat(FieldX2.getText());
        ARR_X[3] = Float.parseFloat(FieldX3.getText());

        LabelY0.setText(String.valueOf(ARR_Y[0] = MyFunctionCalc(ARR_X[0])));
        LabelY1.setText(String.valueOf(ARR_Y[1] = MyFunctionCalc(ARR_X[1])));
        LabelY2.setText(String.valueOf(ARR_Y[2] = MyFunctionCalc(ARR_X[2])));
        LabelY3.setText(String.valueOf(ARR_Y[3] = MyFunctionCalc(ARR_X[3])));

        System.out.println("Table is calculated");

        TextField.setText(TextField.getText() + "Table is calculated\n");
    }

}
