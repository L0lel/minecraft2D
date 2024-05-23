package controller.simple;

import data.blocks.Block;
import visual.GUI.BlockPane;
import visual.GUI.InventoryPane;
import data.model.Inventory;
import visual.GUI.clickableBlockPanes.AnonymousClickableBlockPane;

import java.util.Iterator;

public class InventorySimpleController implements SimpleController{

    Inventory inv;
    InventoryPane inv_pane;

    MainSimpleController mc;

    public InventorySimpleController(Inventory inventory, InventoryPane ip, MainSimpleController controller){
        this.inv = inventory;
        this.inv_pane = ip;
        this.mc = controller;
        redraw();
    }

    public void redraw(){
        inv_pane.getChildren().clear();
        inv_pane.addText();

        Iterator<Block> iter = inv.getInventory();

        int index = 0;
        while(iter.hasNext()){
            inv_pane.getChildren().add(new AnonymousClickableBlockPane(iter.next(), this.mc, index));
            index++;
        }
    }
}
