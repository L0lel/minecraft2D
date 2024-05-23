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

    public void smelt(){
        if(this.getOutput() instanceof NullBlock){
            this.output = this.input.smelt();
            this.setInput(BlockFactory.null_block());
        }else{
            System.out.println("Cannot smelt because furnace output is not empty");
        }
    }

    public void setInput(SmeltableBlock b){
        this.input = b;
    }

    public SmeltableBlock getInput(){
        return this.input;
    }

    public void resetOutput(){
        this.output = BlockFactory.null_block();
    }

    public Block getOutput(){
        return this.output;
    }
}
