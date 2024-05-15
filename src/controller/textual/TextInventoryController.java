package controller.textual;

import data.blocks.Block;
import data.model.Inventory;
import visual.textual.FurnacePrinter;
import visual.textual.InventoryPrinter;

import java.util.ArrayList;

public class TextInventoryController extends AbstractTextController{

    private Inventory i;

    TextInventoryController(Inventory inv){
        tp = new InventoryPrinter();
        this.i = inv;
    }

    public void update_printer(){
        ((InventoryPrinter)tp).update(i.getInventory(), i.getBlockComparator());
    }
}
