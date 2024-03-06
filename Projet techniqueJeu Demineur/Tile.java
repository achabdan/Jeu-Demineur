public class Tile {
    final private boolean bomb;
    public int bomba;
    boolean flaged = false;
    public int posX,posY,ID;
    public boolean clicked = false ;

    public  Tile(int ID,int posX,int posY,boolean bomb){
        this.ID=ID;
        this.posX=posX;
        this.posY=posY;
        this.bomb=bomb;
        this.bomba=-5;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setNbBomb(int bomba) {
        this.bomba = bomba;
    }

    public void Flag() {
        this.flaged = !this.flaged;
    }
    public boolean isFlaged() {
        return flaged;
    }
    public int click(){
        this.clicked  = true;
        if (this.bomb) return -1;
        if (bomba==0) return 100;
        return bomba;
    }
    public String Display(){
        if(this.clicked) {
            if (this.bomb) {
                System.out.print('O');
                return "O";
            }
            else if (this.bomba>0) {
                System.out.print(this.bomba);
                return Integer.toString(this.bomba);
            }
            else {
                System.out.print(' ');
                return " ";
            }
        }
        else{
            if(!this.flaged) {
                System.out.print('#');

            }
            else {
                System.out.print('P');
            }
            return "";
    }
    }
}
