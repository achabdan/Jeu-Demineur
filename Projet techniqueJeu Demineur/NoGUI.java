import java.util.Scanner;

public class NoGUI {
    private Board board;
    private Player currentPlayer;
    private int Bomb;
    public NoGUI(String Nom, int difficultyLevel){
        this.currentPlayer = new Player(Nom);
        startNewGame(difficultyLevel);

    }
    private void startNewGame(int difficultyLevel) {
        switch(difficultyLevel) {
            case 1 :
                Bomb = 10;
                initializeBoard(8, 8);
                break;
            case 2 :
                Bomb = 54;
                initializeBoard(12, 12);
                break;
            case 3 :
                Bomb = 100;
                initializeBoard(16, 16);
                break;

            default:
                initializeBoard(8, 8);
        }
    }
    private void initializeBoard(int rows, int colomns) {
        this.board = new Board(rows, colomns,Bomb);
    }

    public void GameUpdate() {
        board.Display();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la ligne : ");
        int row = scanner.nextInt();
        System.out.print("Entrez la colonne : ");
        int column = scanner.nextInt();


        // Perform player action
        performPlayerAction(row, column);

        // Check output condition (GameEnd)
        if (!GameEnd()) {
            // If the exit condition is not met, recursively call GameUpdate
            GameUpdate();
        } else {
            board.Display();

            // Exit condition reached, display an end-of-game message or perform other actions
            System.out.println("Fin de jeu!");
        }
    }
    public void performPlayerAction(int row, int column){
        if (row>=0){
            if (column >=0){
                if (row<board.height){
                    if (column<board.width){
                        board.revealCell(row,column);
                    }
                }
            }
        }
    }
    private boolean GameEnd() {
        // Logic to check whether the end-of-game condition has been reached
        return board.isGameOver()|| board.isGameWon();
    }
}



