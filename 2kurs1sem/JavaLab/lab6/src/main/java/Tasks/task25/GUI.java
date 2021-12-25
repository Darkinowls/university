package Tasks.task25;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JRadioButton radioBlack = new JRadioButton("Black");
    private JRadioButton radioRed = new JRadioButton("Red");
    private JRadioButton radioGreen = new JRadioButton("Green");
    private JRadioButton radioBlue = new JRadioButton("Blue");
    private JTextField SizeField = new JTextField();
    private JTextPane TextPane = new JTextPane();
    private JPanel LowPanel = new JPanel( new FlowLayout( FlowLayout.CENTER , 50 ,50));
    private JPanel Grid = new JPanel(new GridLayout(2,2));
    private JPanel HighPanel = new JPanel( new FlowLayout( FlowLayout.CENTER , 20 ,20));
    private ButtonGroup Group = new ButtonGroup();


    public GUI() {
        super("Task 25");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        HighPanel.setName("Font settings");
        Border border = BorderFactory.createTitledBorder(HighPanel.getName());
        HighPanel.setBorder(border);


        HighPanel.add(new JLabel("Color :"));

        radioBlack.setSelected(true);
        radioBlack.setForeground(Color.BLACK);
        Group.add(radioBlack);
        Grid.add(radioBlack);

        radioRed.setForeground(Color.RED);
        Group.add(radioRed);
        Grid.add(radioRed);

        radioGreen.setForeground(Color.GREEN);
        Group.add(radioGreen);
        Grid.add(radioGreen);

        radioBlue.setForeground(Color.BLUE);
        Group.add(radioBlue);
        Grid.add(radioBlue);

        HighPanel.add(Grid);

        HighPanel.add (new JLabel("Size :"));
        SizeField.setText("12");
        SizeField.setPreferredSize(new Dimension(20, 20));
        HighPanel.add(SizeField);


        add (HighPanel , BorderLayout.PAGE_START) ;


        LowPanel.setName("Out the text");
        border = BorderFactory.createTitledBorder(LowPanel.getName());
        LowPanel.setBorder(border);

        TextPane.setText("Simple text");
        LowPanel.add(TextPane);

        add(LowPanel);


        radioBlack.addActionListener(this);
        radioBlue.addActionListener(this);
        radioRed.addActionListener(this);
        radioGreen.addActionListener(this);

        SizeField.addActionListener(this) ;

        pack();

    }

    public void actionPerformed(ActionEvent e) {

        TextPane.setForeground((radioGreen.isSelected())? Color.GREEN :
                (radioRed.isSelected())? Color.RED :
                        (radioBlue.isSelected())? Color.BLUE :
                                (radioBlack.isSelected())? Color.BLACK : Color.BLACK);


        if (!SizeField.getText().matches("[1-9][0-9]") ) {
            JOptionPane.showMessageDialog(null, "Error! Enter integer number between 10 and 99!");
            SizeField.setText("12");
        }

        TextPane.setFont( new Font (null , Font.PLAIN , Integer.parseInt(SizeField.getText())));
    }




}

