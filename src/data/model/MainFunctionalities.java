package data.model;

import data.*;
import data.blocks.Block;
import data.blocks.NullBlock;
import data.blocks.SmeltableBlock;
import utils.BlockErrorException;
import utils.Coords;

public class MainFunctionalities {

    private Map m;
    private Furnace f;
    private Inventory i;

    public MainFunctionalities(){
        this.m = new Map();
        this.f = new Furnace();
        this.i = new Inventory();
    }

    public void map_to_furnace(Coords c){
        try{
            SmeltableBlock sb = this.m.getSmeltableBlock(c);
            this.f.setInput(sb);
            m.insert_at_coords(BlockFactory.air_block(), c, true);
        }catch (BlockErrorException e) {
            System.out.println("Block selected not smeltable");
        }
    }

    public void inv_to_furnace(int index){
        try{
            SmeltableBlock b = this.i.get_smeltable_item(index);
            if(this.f.getInput() instanceof NullBlock){
                this.i.pop_item(index);
                this.f.setInput(b);
            }else{
                System.out.println("Furnace is already full");
            }
        }catch(BlockErrorException e){
            System.out.println("Block selected not smeltable");
        }
    }

    public void furnace_to_inv(){
        if(!(this.f.getInput() instanceof NullBlock)){
            this.i.add_block(this.f.getInput());
        }
        this.f.setInput(BlockFactory.null_block());
    }

    public void smelt(){
        Block b = this.f.smelt();
        if(!(b instanceof NullBlock)) {
            this.i.add_block(b);
        }
    }

    public void pick_up_block(Coords c){
        try{
            this.i.add_block(this.m.givePickable(c));
        }catch (BlockErrorException e){
            System.out.println("Block selected not pickable");
        }
    }

    public void toggle_inventory_comparator(){this.i.toggleComparatorMode();}

    public Furnace getFurnace() {
        return this.f;
    }

    public Inventory getInventory() {
        return this.i;
    }

    public Map getMap(){
        return this.m;
    }
}
