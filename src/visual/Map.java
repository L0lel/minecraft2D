package visual;

import data.*;

import java.util.Random;

public class Map {

    protected static final int DIM_COLUMNS = 32;
    protected static final int DIM_ROWS = 9;

    private static final int RANDOM_BLOCK_TO_ADD = 32;

    public Block[][] content;

    public Map(){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = DIM_ROWS-1; i >= 0; i--){
            for(int j = DIM_COLUMNS-1; j >= 0; j--){
                Block b = new AirBlock();
                this.insert_at_coords(b, new Coords(i, j), true);
            }
        }

        this.addRiver();

        Random rand = new Random();
        for(int i = 0; i < RANDOM_BLOCK_TO_ADD; i++){
            Block b;
            if(rand.nextInt(RANDOM_BLOCK_TO_ADD) < RANDOM_BLOCK_TO_ADD/2){
                b = new SandBlock();
            }else{
                b = new RawIronBlock();
            }
            int row = rand.nextInt(DIM_ROWS);
            int col = rand.nextInt(DIM_COLUMNS);
            this.insert_at_coords(b, new Coords(row, col), true);
        }
    }

    private void addRowsOfWater(){
        for(int i = 0; i < DIM_COLUMNS; i++){
            Block b = new WaterBlock();
            this.insert_at_coords(b, new Coords(0, i), true);
        }
    }

    public void addRiver(){
        this.addRowsOfWater();
    }

    public void addSea(){
        for(int i = 0; i < 3; i++) this.addRowsOfWater();
    }

    public void display_on_out() {

        System.out.println();
        System.out.print("|");
        for (int i = 0; i < DIM_COLUMNS + 2; i++) {
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();

        for (int i = 0; i < DIM_ROWS; i++) {
            System.out.print("||");
            for (int j = 0; j < DIM_COLUMNS; j++) {
                System.out.print(this.content[i][j].display());
            }
            System.out.print("||");
            System.out.println();
        }

        System.out.print("|");
        for (int i = 0; i < DIM_COLUMNS + 2; i++){
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();

    }

    public void change_cell(Coords c){
        if(c.getX() < 0 || c.getX() >= DIM_ROWS || c.getY() < 0 || c.getY() >= DIM_COLUMNS){
            return;
        }
        this.insert_at_coords(new SandBlock(), c, true);
    }

    public void swap(Coords c){
        Block tmp = this.content[c.getX()][c.getY()];
        this.content[c.getX()][c.getY()] = this.content[c.getX()+1][c.getY()];
        this.content[c.getX()+1][c.getY()] = tmp;
    }

    public void insert_at_coords(Block b, Coords c, boolean isStackable){
        if(c.getX() >= DIM_ROWS || c.getY() >= DIM_COLUMNS || c.getX() < 0 || c.getY() < 0){
            return;
        }

        this.content[c.getX()][c.getY()] = b;
        if(isStackable) {
            this.insert_rec(c);
        }
    }

    public void insert_rec(Coords c){
        if(c.getX() == DIM_ROWS-1){
            return;
        }
        if(!this.content[c.getX()][c.getY()].has_gravity()){
            return;
        }
        if(!this.content[c.getX()+1][c.getY()].does_fall_through()){
            return;
        }

        this.swap(c);
        this.insert_rec(new Coords(c.getX()+1, c.getY()));
    }

    public boolean isSmeltable(Coords c){
        return (this.content[c.getX()][c.getY()] instanceof SmeltableBlock);
    }

    public SmeltableBlock getSmeltableBlock(Coords c){
        if(this.isSmeltable(c)){
            return (SmeltableBlock) this.content[c.getX()][c.getY()];
        }
        return new NullBlock();
    }
}