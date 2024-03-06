import java.util.Arrays;
import java.util.Random;
public class Board {
    private static final int Mine = -1;
    private static final int[][] NEIGHBOR_OFFSETS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},            {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    private boolean GameOver=false;
    public final int width;
    public final int height;
    private final int numMines;
    private final Tile[][] cells;

    public Board(int width, int height, int numMines) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.cells = new Tile[width][height];
        initializeBoard();

    }
    public void initializeBoard() {
        int bombplaced = 0;
        int[] a = new int[height*width];

        Random rd = new Random();
        Arrays.fill(a, 0);
        for (int g = 0; g < numMines; g++) {
            int randomIndex;
            do {
                randomIndex = rd.nextInt(width*height);
            } while (a[randomIndex] != 0); // Assurez-vous que l'index n'a pas déjà été choisi

            a[randomIndex] = 1;
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j]=new Tile(i*width+j,i,j,(a[i*width+j]==1));

            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int nbBomb = 0;
                if (i>=1){
                    if(j>=1){
                        if (cells[i-1][j-1].isBomb()) nbBomb++;
                    }
                    if(j<height-1){
                        if (cells[i-1][j+1].isBomb()) nbBomb++;
                    }
                    if (cells[i-1][j].isBomb()) nbBomb++;
                }
                if (i<width-1){
                    if(j>=1){
                        if (cells[i+1][j-1].isBomb()) nbBomb++;
                    }
                    if(j<height-1){
                        if (cells[i+1][j+1].isBomb()) nbBomb++;
                    }
                    if (cells[i+1][j].isBomb()) nbBomb++;
                }
                if(j>=1){
                    if (cells[i][j-1].isBomb()) nbBomb++;
                }
                if(j<height-1){
                    if (cells[i][j+1].isBomb()) nbBomb++;
                }
                cells[i][j].setNbBomb(nbBomb);
            }
        }
    }
    public int revealCell(int x, int y) {

        int result = cells[x][y].click();

        if(result==100){

            if (x>0){
                if(y>0){
                    revealCell(x-1,y-1);
                }
                if(y<height-1){
                    revealCell(x-1,y+1);
                }
                revealCell(x-1,y);
            }
            if (x<width-1){
                if(y>0){
                    revealCell(x+1,y-1);
                }
                if(y<height-1){
                    revealCell(x+1,y+1);
                }
                revealCell(x+1,y);
            }
            if(y>=1){
                revealCell(x,y-1);
            }
            if(y<height-1){
                revealCell(x,y+1);
            }
        } else if (result==-1) {
            GameOver = true;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if(cells[i][j].isBomb()){
                        cells[i][j].click();
                    }
                }
            }
        }
        return result;
    }
    public int revealCellG(int x, int y) {
        int result = cells[x][y].click();
        if (result==-1)  GameOver = true;
        return result;
    }

    public void flagCell(int x, int y) {
        cells[x][y].Flag();
    }
    public boolean isGameWon() {
        boolean result = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(cells[i][j].clicked||cells[i][j].isBomb()){
                    continue;
                }
                result = false;
            }
        }

        // Check that all cells without lead are revealed

        return result;
    }
    public boolean isGameOver() {
        // Check if a mine has been revealed
        // ...
        return this.GameOver;
    }
    public void Display(){
        for ( int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                cells[i][j].Display();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public String DisplayCell(int x, int y){
        cells[x][y].clicked = true;
        return cells[x][y].Display();
    }
}









