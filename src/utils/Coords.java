package utils;

import data.model.Map;

public class Coords {

    private int x;
    private int y;

    public Coords(int X, int Y){
        this.x = X;
        this.y = Y;
        try{
            isInBound();
        }catch (WrongCoordinatesException e){
            System.out.println("Coordinates not in bound of map");
        }
    }

    public boolean isInBound() throws WrongCoordinatesException{
        if(this.x < Map.DIM_ROWS && this.x >= 0 && this.y < Map.DIM_COLUMNS && this.y >= 0){
            return true;
        }else{
            throw new WrongCoordinatesException();
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
