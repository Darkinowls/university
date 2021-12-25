package Tasks.task13;

import Tasks.Colorist;
import jdk.jfr.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame implements ActionListener {
    private JPanel Panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox ComboBox;
    private JRadioButton Button12;
    private JRadioButton Button14;
    private JRadioButton Button16;
    private JPanel Panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    private JTextPane TextPane;

    public GUI() {

        super("Task 13");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        Panel1.setName("Setting Font");
        Border border = BorderFactory.createTitledBorder(Panel1.getName());
        Panel1.setBorder(border);

        Panel1.add(new JLabel("Color :"));
        ComboBox = new JComboBox(new String[]{"Black", "Red", "Green", "Blue"});
        ComboBox.setPreferredSize(new Dimension(70, 20));
        Panel1.add(ComboBox);

        Panel1.add(Button12 = new JRadioButton("12 pt"));
        Button12.setActionCommand("12");
        Panel1.add(Button14 = new JRadioButton("14 pt"));
        Button14.setActionCommand("14");
        Panel1.add(Button16 = new JRadioButton("16 pt"));
        Button16.setActionCommand("16");
        buttonGroup.add(Button12);
        buttonGroup.add(Button14);
        buttonGroup.add(Button16);
        Button12.setSelected(true);


        add(Panel1, BorderLayout.PAGE_START);


        Panel2.setName("Text");
        border = BorderFactory.createTitledBorder(Panel2.getName());
        Panel2.setBorder(border);

        TextPane = new JTextPane();
        TextPane.setText("Simple text");
        TextPane.setFont(new Font("Arial", Font.PLAIN, 12));
        TextPane.setPreferredSize(new Dimension(325, 40));
        Panel2.add(TextPane);

        add(Panel2);

        Button12.addActionListener(this);
        Button14.addActionListener(this);
        Button16.addActionListener(this);
        ComboBox.addActionListener(this);


        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(getSettings());

        TextPane.setForeground(Colorist.getColor(ComboBox.getSelectedItem()) );

        TextPane.setFont(new Font("Arial", Font.PLAIN, Integer.parseInt(
                buttonGroup.getSelection().getActionCommand())));

    }


    public String getSettings(){
        return ComboBox.getSelectedItem() + " - " + buttonGroup.getSelection().getActionCommand() + "pt";
    }

}
