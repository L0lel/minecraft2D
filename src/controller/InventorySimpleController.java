package controller;

import data.Block;
import javafx.scene.text.Text;
import visual.GUI.BlockPane;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

import java.util.Iterator;

public class InventorySimpleController implements SimpleController{

    Inventory inv;
    InventoryPane inv_pane;

    public InventorySimpleController(Inventory inventory, InventoryPane ip){
        this.inv = inventory;
        this.inv_pane = ip;
        redraw();
    }

    public void redraw(){
        inv_pane.getChildren().clear();
        inv_pane.addText();

        Iterator<Block> iter = inv.getInventory();

        while(iter.hasNext()){
            inv_pane.getChildren().add(new BlockPane(iter.next()));
        }
    }
}
