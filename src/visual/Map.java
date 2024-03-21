package visual;

import data.Block;
import data.AirBlock;
import data.SandBlock;
import data.WaterBlock; 

public class Map {

    private static final int DIM_COLUMNS = 32;
    private static final int DIM_ROWS = 9;

    private Block[][] content;

    public Map(){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = DIM_ROWS; i >= 0; i--){
            for(int j = DIM_COLUMNS; j >= 0; j--){
                Block b = new AirBlock();
                this.insert_at_coords(b, i, j, true);
            }
        }

        this.addRiver();
    }

    private void addRowsOfWater(){
        for(int i = 0; i < DIM_COLUMNS; i++){
            Block b = new WaterBlock();
            this.insert_at_coords(b, 0, i, true);
        }
    }

    public void addRiver(){
        this.addRowsOfWater();
    }

    public void addSea(){
        for(int i = 0; i < 3; i++) this.addRowsOfWater();
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
        this.insert_at_coords(new SandBlock(), row, col, true);
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
