package visual.GUI.clickableBlockPanes;

import data.blocks.Block;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import visual.GUI.BlockPane;

public class ExternalClickableBlockPane extends BlockPane {

    public ExternalClickableBlockPane(Block bb, EventHandler<MouseEvent> bg){
        super(bb);
        this.setOnMouseClicked(bg);
    }
}