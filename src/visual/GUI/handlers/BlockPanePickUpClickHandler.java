package visual.GUI.handlers;

import controller.simple.MainSimpleController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.Coords;

public class BlockPanePickUpClickHandler implements EventHandler<MouseEvent> {

    private MainSimpleController mc;
    private Coords coord;

    BlockPanePickUpClickHandler(MainSimpleController m, Coords c){
        this.coord = c;
        this.mc = m;
    }

    public void handle(MouseEvent mouseEvent){
        this.mc.pick_up_block(this.coord);
    }
}
