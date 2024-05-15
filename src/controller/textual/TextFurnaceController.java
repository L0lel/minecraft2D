package controller.textual;

import data.model.Furnace;
import visual.textual.FurnacePrinter;

public class TextFurnaceController extends AbstractTextController{

    private Furnace f;

    TextFurnaceController(Furnace fur){
        tp = new FurnacePrinter();
        this.f = fur;
    }

    public void update_printer(){
        ((FurnacePrinter)tp).update(f.getInput(), f.getOutput());
    }
}
