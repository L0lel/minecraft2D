package data.model;

import data.BlockFactory;
import data.blocks.Block;
import data.blocks.NullBlock;
import data.blocks.SmeltableBlock;

public class Furnace {

    private SmeltableBlock input;
    private Block output;

    public Furnace(){
        this.input = BlockFactory.null_block();
        this.output = BlockFactory.null_block();
    }

    private void resetFurnace(){
        this.input = BlockFactory.null_block();
        this.output = BlockFactory.null_block();
    }

    public Block smelt(){
        Block b = this.input.smelt();
        this.resetFurnace();
        return b;
    }

    public void setInput(SmeltableBlock b){
        this.input = b;
    }

    public SmeltableBlock getInput(){
        return this.input;
    }

    public Block getOutput(){
        return this.output;
    }
}
