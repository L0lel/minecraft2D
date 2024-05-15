package visual.textual;

import data.blocks.Block;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class InventoryPrinter implements TextPrinter{

    private Iterator<Block> inventory;
    private Comparator<Block> blockComparator;

    public void update(Iterator<Block> i, Comparator<Block> bc){
        this.inventory = i;
        this.blockComparator = bc;
    }

    public void display_on_out(){
        for (Iterator<Block> it = inventory; it.hasNext(); ) {
            Block block = it.next();
            block.display_in_inventory();
        }
        System.out.println("<" + blockComparator.getClass().getSimpleName() + ">");
    }
}
