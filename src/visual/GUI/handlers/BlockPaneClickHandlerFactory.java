package visual.GUI.handlers;

import controller.simple.MainSimpleController;
import utils.Coords;

public class BlockPaneClickHandlerFactory {

    private MainSimpleController mc;

    public BlockPaneClickHandlerFactory(MainSimpleController m){
        this.mc = m;
    }

    public BlockPanePickUpClickHandler createNewPickUpHandler(Coords c){
        return new BlockPanePickUpClickHandler(this.mc, c);
    }
}
