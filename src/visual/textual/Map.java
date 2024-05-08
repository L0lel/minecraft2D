package visual.textual;

import data.*;
import utils.BlockErrorException;
import utils.Coords;
import utils.WrongCoordinatesException;

import java.util.Random;

public class Map {

    public static final int DIM_COLUMNS = 32;
    public static final int DIM_ROWS = 9;

    private static final int RANDOM_BLOCK_TO_ADD = 32;

    public Block[][] content;

    public Map(){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = DIM_ROWS-1; i >= 0; i--){
            for(int j = DIM_COLUMNS-1; j >= 0; j--){

                Coords c = null;
                try{
                    c = new Coords(i,j);
                }catch (WrongCoordinatesException e){
                    System.out.println("Coords ["+ i +"]" + "["+ j +"]" + " not in bounds of Map");
                }

                this.insert_at_coords(BlockFactory.air_block(), c, true);
            }
        }

        this.addRiver();

        Random rand = new Random();
        for(int i = 0; i < RANDOM_BLOCK_TO_ADD; i++){
            Block b;
            if(rand.nextInt(RANDOM_BLOCK_TO_ADD) < RANDOM_BLOCK_TO_ADD/2){
                b = BlockFactory.sand_block();
            }else{
                b = BlockFactory.raw_iron_block();
            }
            int row = rand.nextInt(DIM_ROWS);
            int col = rand.nextInt(DIM_COLUMNS);

            Coords c = null;
            try{
                c = new Coords(row,col);
            }catch (WrongCoordinatesException e){
                System.out.println("Coords ["+ row +"]" + "["+ col +"]" + " not in bounds of Map");
            }

            this.insert_at_coords(b, c, true);
        }
    }

    private void addRowsOfWater(){
        for(int i = 0; i < DIM_COLUMNS; i++){

            Coords c = null;
            try{
                c = new Coords(0,i);
            }catch (WrongCoordinatesException e){
                System.out.println("Coords ["+ "0" +"]" + "["+ i +"]" + " not in bounds of Map");
            }

            this.insert_at_coords(BlockFactory.water_block(), c, true);
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
        this.insert_at_coords(BlockFactory.sand_block(), c, true);
    }

    public void swap(Coords c){
        Block tmp = this.content[c.getX()][c.getY()];
        this.content[c.getX()][c.getY()] = this.content[c.getX()+1][c.getY()];
        this.content[c.getX()+1][c.getY()] = tmp;
    }

    public void insert_at_coords(Block b, Coords c, boolean isStackable){
        if(c.getX() >= DIM_ROWS || c.getY() >= DIM_COLUMNS || c.getX() < 0 || c.getY() < 0){
            return; // ERROR EXCEPTION? maybe
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

        Coords c1 = null;
        try{
            c1 = new Coords(c.getX()+1,c.getY());
        }catch (WrongCoordinatesException e){
            System.out.println("Coords ["+ (c.getX()+1) +"]" + "["+ c.getY() +"]" + " not in bounds of Map");
        }

        this.insert_rec(c1);
    }

    private boolean isSmeltable(Coords c) {
        return (this.content[c.getX()][c.getY()] instanceof SmeltableBlock);
    }

    public SmeltableBlock getSmeltableBlock(Coords c) throws BlockErrorException {
        if(this.isSmeltable(c)){
            SmeltableBlock b = (SmeltableBlock) this.content[c.getX()][c.getY()];
            insert_at_coords(BlockFactory.air_block(), c, false);
            return b;
        }
        throw new BlockErrorException();
    }

    private boolean is_pickable(Coords c){
        return this.content[c.getX()][c.getY()].is_pickable();
    }

    public Block givePickable(Coords c) throws BlockErrorException{
        if(this.is_pickable(c)){
            Block b = this.content[c.getX()][c.getY()];
            insert_at_coords(BlockFactory.air_block(), c, true);
            checkGravity(c);
            return b;
        }
        throw new BlockErrorException();

    }

    private void checkGravity(Coords c) {

        if(c.getX()-1 >= 0){
            Coords c1 = null;
            try{
                c1 = new Coords(c.getX()-1, c.getY());
            }catch (WrongCoordinatesException e){
                System.out.println("Coords ["+ (c.getX()-1) +"]" + "["+ c.getY() +"]" + " not in bounds of Map");
            }

            Block checkedBlock = this.content[c1.getX()][c1.getY()];

            if(checkedBlock.isEntityBlock() && this.content[c.getX()][c.getY()] instanceof TorchBlock){
                insert_at_coords(BlockFactory.air_block(), c1, true);
            }else {
                insert_at_coords(checkedBlock, c1, true);
            }

            checkGravity(c1);
        }
    }
}