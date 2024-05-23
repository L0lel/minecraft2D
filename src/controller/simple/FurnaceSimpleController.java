package controller.simple;

import data.model.Furnace;
import visual.GUI.BlockPane;
import visual.GUI.FurnacePane;
import visual.GUI.clickableBlockPanes.InternalClickableBlockPane;

public class FurnaceSimpleController implements SimpleController{

    Furnace f;
    FurnacePane fp;
    MainSimpleController mc;

    public FurnaceSimpleController(Furnace furnace, FurnacePane pane, MainSimpleController controller){
        this.f = furnace;
        this.fp = pane;
        this.mc = controller;
        redraw();
    }

    public void redraw(){
        fp.getChildren().clear();
        fp.addText();
        fp.getChildren().add(new InternalClickableBlockPane(f.getInput(), this.mc));
        fp.addArrow();
        fp.getChildren().add(new InternalClickableBlockPane(f.getOutput(), this.mc));
    }
}
