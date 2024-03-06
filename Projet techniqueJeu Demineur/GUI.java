import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class GUI {
    private JButton[][] buttons;
    private Board board;
    private int rows;
    private int cols;
    private Timer timer;
    private JLabel label;
    private int seconds = 0;
    private TimerTask task;
    private boolean flagmod= false;
    private JFrame frame;

    public GUI(int rows, int cols, int bombs) {
        this.rows = rows;
        this.cols = cols;
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                label.setText(Integer.toString( seconds));
            }
        });
        this.board = new Board(rows, cols, bombs);
        this.buttons = new JButton[rows][cols];
        this.task = new UptdateTimer();
        initializeGUI();

    }



    private void initializeGUI() {
        frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(rows+1, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                frame.add(button);
            }
        }

        frame.setSize(cols * 50, (rows+1) * 50);
        JLabel label = new JLabel(Long.toString(0));
        label.setPreferredSize(new Dimension(cols*50,50));
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
        this.label = label;
        JButton flag = new JButton();
        flag.setPreferredSize(new Dimension(50, 50));
        flag.setText("P");
        flag.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            flagmod = !flagmod;
        }

        });
        frame.add(flag);
        frame.setVisible(true);
    }

    private void revealCell(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if(label.getText().equals("0")){
            timer.start();
        }
        JButton button = buttons[row][col];
        if (!button.isEnabled()) {
            return;
        }

        String text =board.DisplayCell(row,col);
        if(flagmod){
            //board.flagCell(row,col);
            if(button.getText().equals("P")) button.setText(" ");
            else button.setText("P");
            return;
        }
        button.setEnabled(false);
        int r =board.revealCellG(row,col);
        System.out.println("r=" +r);
        if (r == 100) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    revealCell(i, j);
                }
            }
        } else if (r == -1) {
            // Game over - reveal all cells and show a message
            revealAllCells();
            timer.stop();

            int a =  JOptionPane.showConfirmDialog(null, "Game Over! Play again ?","Game Over",JOptionPane.YES_NO_OPTION);
            System.out.println("\n"+a);
            if(a==0){
                new GUI_initer();
                frame.setVisible(false);
            }
        } else {
            button.setText(text);
        }
        if(board.isGameWon()) {
            if(!board.isGameOver()){
                JOptionPane.showMessageDialog(null,"You Win");
            }
        }
    }

    private void revealAllCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = buttons[i][j];
                button.setEnabled(false);
                button.setText(board.DisplayCell(i,j));
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            revealCell(row, col);
        }

    }
    private class UptdateTimer extends TimerTask{
        private long time = 0;
        UptdateTimer(){
            super();
        }
        @Override
        public void run() {
            time ++;
            label.setText(Long.toString(time));
        }
        private void completeTask() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                ;
            }
        }
    }
}

