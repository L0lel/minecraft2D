package controller;

import data.Furnace;
import visual.GUI.BlockPane;
import visual.GUI.FurnacePane;

public class FurnaceSimpleController implements SimpleController{

    Furnace f;
    FurnacePane fp;

    public FurnaceSimpleController(Furnace furnace, FurnacePane pane){
        this.f = furnace;
        this.fp = pane;
        redraw();
    }

    public void redraw(){
        fp.getChildren().clear();
        fp.addText();
        fp.getChildren().add(new BlockPane(f.getInput()));
        fp.addArrow();
        fp.getChildren().add(new BlockPane(f.getOutput()));
    }
}
