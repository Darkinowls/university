package Tasks.task5;


import Tasks.Colorist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class MyFrame extends JFrame implements ActionListener {

    private JPanel PanelHigh = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
    private JPanel PanelLow = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
    private JTextField TextField;
    private JSpinner MyFont;
    private JSpinner MyColor;
    private JButton Button;


    MyFrame() {

        super("Task 5");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


        PanelHigh.setName("Managing of output");
        Border border = BorderFactory.createTitledBorder(PanelHigh.getName());
        PanelHigh.setBorder(border);


        PanelHigh.add(new JLabel("Text :"));
        TextField = new JTextField("Some text", 30);
        PanelHigh.add(TextField);


        PanelHigh.add(new JLabel("Set font :"));
        MyFont = new JSpinner(new SpinnerListModel(new String[]{"Times New Roman", "Arial", "Verdana"}));
        PanelHigh.add(MyFont);

        PanelHigh.add(new JLabel("Set color :"));
        MyColor = new JSpinner(new SpinnerListModel(new String[]{"Black", "Red", "Green", "Blue"}));
        MyColor.setPreferredSize(new Dimension(60 ,20));
        PanelHigh.add(MyColor);

        Button = new JButton("Make my text beautiful!");
        PanelHigh.add(Button);

        add(PanelHigh, BorderLayout.PAGE_START);


        PanelLow.setName("Out the text");
        border = BorderFactory.createTitledBorder(PanelLow.getName());
        PanelLow.setBorder(border);

        add(PanelLow);

        Button.addActionListener(this);


        pack();
    }


    public void actionPerformed(ActionEvent event) {

        Graphics g = getGraphics();

        System.out.println(getTypeOfString());

        paint(g);

    }

    public String getTypeOfString() {
        return MyFont.getValue().toString() + " - " + MyColor.getValue().toString();
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Colorist.getColor(MyColor.getValue()));

        g.setFont(new Font(MyFont.getValue().toString(), Font.PLAIN, 20));

        g.drawString(TextField.getText(), 150, 160 );
    }

}
