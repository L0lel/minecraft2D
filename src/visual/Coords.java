package visual;

public class Coords {

    private int x;
    private int y;

    public Coords(int X, int Y){
        x = X;
        y = Y;
        if(!isInBound()){
            System.out.println("Coords ["+x+"]" + "["+y+"]" + " not in bounds of Map");
        }
    }

    public boolean isInBound(){
        return (x < Map.DIM_ROWS && x >= 0 && y < Map.DIM_COLUMNS && y >= 0);
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}
