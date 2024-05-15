package controller.textual;

import data.model.Map;
import visual.textual.FurnacePrinter;
import visual.textual.MapPrinter;

public class TextMapController extends AbstractTextController{

    private Map m;

    TextMapController(Map map){
        tp = new MapPrinter();
        this.m = map;
    }

    public void update_printer(){
        ((MapPrinter)tp).update(m.content);
    }
}
