package data.model;

import data.blocks.Block;
import data.blocks.SmeltableBlock;
import utils.comparators.AlphabeticalBlockComparator;
import utils.comparators.BlockComparator;
import utils.exceptions.BlockErrorException;

import java.util.*;

public class Inventory {

    private ArrayList<Block> inventory;
    private Comparator<Block> blockComparator;
    private static int blockQuantity = 0;

    public Inventory(){
        inventory = new ArrayList<>();
        blockComparator = new BlockComparator();
    }

    public void add_block(Block b){
        inventory.add(b);
        blockQuantity++;
        b.setBlock_value(blockQuantity);
    }

    private boolean is_smeltable(int index){
        return inventory.get(index) instanceof SmeltableBlock;
    }

    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException {
        if(is_smeltable(index)){
            return (SmeltableBlock) inventory.get(index);
        }
        throw new BlockErrorException();
    }

    public void pop_item(int index) {
        inventory.remove(index);
        blockQuantity--;
    }

    public void sort(){
        this.inventory.sort(this.blockComparator);
    }

    public void toggleComparatorMode(){
        if(blockComparator instanceof AlphabeticalBlockComparator){
            this.blockComparator = new BlockComparator();
            return;
        }
        this.blockComparator = new AlphabeticalBlockComparator();
        this.sort();
    }

    public Iterator<Block> getInventory(){
        return this.inventory.iterator();
    }
    public Comparator<Block> getBlockComparator(){
        return this.blockComparator;
    }
}
