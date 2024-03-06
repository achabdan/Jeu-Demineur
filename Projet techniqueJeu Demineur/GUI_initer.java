import javax.swing.*;
import java.awt.*;

public class GUI_initer {
    private int difficulty= 1;
    GUI_initer(){
        JFrame frame = new JFrame("starting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 6));
        JTextField PlayerName  =new JTextField();
        JButton start = new JButton();
        start.addActionListener(actionEvent -> {
            switch (difficulty){
                case 1:

                    new GUI(8,8,8);
                    frame.setVisible(false);
                    break;
                case 2:
                    new GUI(12,12,24);
                    frame.setVisible(false);
                    break;
                default:
                    new GUI(16,16,48);
                    frame.setVisible(false);
            }
        });
        start.setText("Start");
        JButton d1,d2,d3;
        d1 = new JButton();
        d2 = new JButton();
        d3 = new JButton();
        d1.addActionListener(actionEvent -> {
            difficulty=1;
            d1.setEnabled(false);
            d2.setEnabled(true);
            d3.setEnabled(true);
        });
        d2.addActionListener(actionEvent -> {
            difficulty=2;
            d1.setEnabled(true);
            d2.setEnabled(false);
            d3.setEnabled(true);
        });
        d3.addActionListener(actionEvent -> {
            difficulty=3;
            d1.setEnabled(true);
            d2.setEnabled(true);
            d3.setEnabled(false);
        });

        d1.setText("EASY");
        d2.setText("MEDIUM");
        d3.setText("HARD");

        d1.setEnabled(false);

        d1.setPreferredSize(new Dimension(200,50));
        d2.setPreferredSize(new Dimension(200,50));
        d3.setPreferredSize(new Dimension(200,50));

        start.setPreferredSize(new Dimension(200,50));
        PlayerName.setPreferredSize(new Dimension(300,50));
        frame.setSize(1100,100);
        frame.add(d1);
        frame.add(d2);
        frame.add(d3);
        frame.add(start);
        frame.add(PlayerName);
        frame.setVisible(true);
    }
}
