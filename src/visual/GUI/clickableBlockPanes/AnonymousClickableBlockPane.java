package visual.GUI.clickableBlockPanes;

import controller.simple.MainSimpleController;
import data.blocks.Block;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import visual.GUI.BlockPane;

public class AnonymousClickableBlockPane extends BlockPane {

    public AnonymousClickableBlockPane(Block bb, MainSimpleController mc, int index){
        super(bb);
        this.setOnMouseClicked(event -> mc.inv_to_furnace(index));
    }
}
