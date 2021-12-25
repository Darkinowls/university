package Tasks.task20;

import Tasks.Colorist;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class GUI extends JFrame implements ActionListener {
    private JPanel Triangle = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 200));
    private JPanel Parameters = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 25));
    private JPanel Grid = new JPanel(new GridLayout(2, 2, 10, 0));
    private JSpinner MyColor;
    private JSpinner MyAngle;
    private JTextField FieldX;
    private JTextField FieldY;
    private JButton Button;

    private int arrayX[] = new int[]{100, 100, 200};
    private int arrayY[] = new int[]{100, 200, 100};


    GUI() {
        super("Task 20");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


        Triangle.setName("Triangle");
        Border border = BorderFactory.createTitledBorder(Triangle.getName());
        Triangle.setBorder(border);

        add(Triangle, BorderLayout.PAGE_START);


        Parameters.setName("Settings");
        border = BorderFactory.createTitledBorder(Parameters.getName());
        Parameters.setBorder(border);

        Parameters.add(new JLabel("Color :"));
        MyColor = new JSpinner(new SpinnerListModel(new String[]{"Black", "Red", "Green", "Blue"}));
        MyColor.setPreferredSize(new Dimension(60, 20));
        Parameters.add(MyColor);

        Parameters.add(new JLabel("Number of angle :"));
        MyAngle = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));
        Parameters.add(MyAngle);

        Grid.add(new JLabel("coordinate X :"));

        Grid.add(FieldX);

        Grid.add(new JLabel("coordinate Y :"));

        Grid.add(FieldY);

        Parameters.add(Grid);

        Button = new JButton("Change triangle");
        Parameters.add(Button);


        add(Parameters);


        Button.addActionListener(this);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (!FieldX.getText().matches("[0-9]+") || !FieldY.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Error! Enter integer numbers!");
        }

        arrayX[(int) MyAngle.getValue() - 1] = Integer.parseInt(FieldX.getText());
        arrayY[(int) MyAngle.getValue() - 1] = Integer.parseInt(FieldY.getText());

        paint(getGraphics());

        System.out.println(this);

    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Colorist.getColor(MyColor.getValue()));

        g.drawPolygon(arrayX, arrayY, 3);
    }

    @Override
    public String toString() {
        return "arrayX=" + Arrays.toString(arrayX) +
                "\n" +
                "arrayY=" + Arrays.toString(arrayY)+
                "\n";
    }
}
