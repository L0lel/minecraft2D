package visual.textual;

import data.Block;
import data.SmeltableBlock;
import utils.AlphabeticalBlockComparator;
import utils.BlockComparator;
import utils.BlockErrorException;

import java.util.*;

public class Inventory {

    private ArrayList<Block> inventory;
    private Comparator<Block> blockComparator;
    private static int blockQuantity = 0;

    public Inventory(){
        inventory = new ArrayList<>();
        blockComparator = new BlockComparator();
    }

    public void display_inventory(){
        for (Block block : inventory) {
            block.display_in_inventory();
        }
        System.out.println("<" + blockComparator.getClass().getSimpleName() + ">");
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
}
