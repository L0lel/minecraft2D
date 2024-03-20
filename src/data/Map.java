package data;

import java.util.Random;

public class Map {

    private static final int DIM_COLUMNS = 10;
    private static final int DIM_ROWS = 10;

    private Block[][] content;

    public Map(){
        this(true);
    }

    public Map(boolean random){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = DIM_ROWS; i >= 0; i--){
            for(int j = DIM_COLUMNS; j >= 0; j--){
                Block b;
                if(random){
                    Random rand = new Random();
                    int r = rand.nextInt(5);
                    b = new Block(r);
                }else{
                    b = new Block();
                }
                this.insert_at_coords(b, i, j, true);
            }
        }
    }

    public void display_on_out(){
        for(int i = 0; i < DIM_ROWS; i++){
            for(int j = 0; j < DIM_COLUMNS; j++){
                System.out.print(this.content[i][j].display());
            }
            System.out.println();
        }
    }

    public void change_cell(int row, int col){
        if(row < 0 || row >= DIM_ROWS || col < 0 || col >= DIM_COLUMNS){
            return;
        }
        this.insert_at_coords(new Block('A'), row, col, true);
    }

    public void swap(int x, int y){
        Block tmp = this.content[x][y];
        this.content[x][y] = this.content[x+1][y];
        this.content[x+1][y] = tmp;
    }

    public void insert_at_coords(Block b, int x, int y, boolean isStackable){
        if(x >= DIM_ROWS || y >= DIM_COLUMNS){
            return;
        }

        this.content[x][y] = b;
        if(isStackable) {
            this.insert_rec(x, y);
        }
    }

    public void insert_rec(int x, int y){
        if(x == DIM_ROWS-1){
            return;
        }
        if(!this.content[x][y].has_gravity()){
            return;
        }
        if(!this.content[x+1][y].does_fall_through()){
            return;
        }

        this.swap(x,y);
        this.insert_rec(x+1, y);
    }
}
