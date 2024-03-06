import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MinesweeperGUI {
    private JButton[][] buttons;
    private int[][] board;
    private int rows;
    private int cols;
    private int bombs;

    public MinesweeperGUI(int rows, int cols, int bombs) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombs;
        this.board = new int[rows][cols];
        this.buttons = new JButton[rows][cols];

        initializeBoard();
        initializeGUI();
    }

    private void initializeBoard() {
        // Initialize the board with bombs
        Random random = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < bombs) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (board[row][col] != -1) {
                board[row][col] = -1; // Bomb
                bombsPlaced++;
            }
        }

        // Calculate the number of surrounding bombs for each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != -1) {
                    int count = countSurroundingBombs(i, j);
                    board[i][j] = count;
                }
            }
        }
    }

    private int countSurroundingBombs(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == -1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(30, 30));
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                frame.add(button);
            }
        }

        frame.setSize(cols * 30, rows * 30);
        frame.setVisible(true);
    }

    private void revealCell(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        JButton button = buttons[row][col];
        if (!button.isEnabled()) {
            return;
        }

        button.setEnabled(false);

        if (board[row][col] == 0) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    revealCell(i, j);
                }
            }
        } else if (board[row][col] == -1) {
            // Game over - reveal all cells and show a message
            revealAllCells();
            JOptionPane.showMessageDialog(null, "Game Over!");
        } else {
            button.setText(Integer.toString(board[row][col]));
        }
    }

    private void revealAllCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = buttons[i][j];
                button.setEnabled(false);

                if (board[i][j] == -1) {
                    button.setText("B");
                } else {
                    button.setText(Integer.toString(board[i][j]));
                }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MinesweeperGUI(8, 8, 10);
        });
    }
}

