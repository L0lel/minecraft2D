package controller.textual;

import data.model.MainFunctionalities;
import utils.Coords;
import visual.textual.FurnacePrinter;
import visual.textual.InventoryPrinter;
import visual.textual.MainPrinter;
import visual.textual.MapPrinter;

public class TextMainController extends AbstractTextController{

    TextFurnaceController f;
    TextMapController m;
    TextInventoryController i;

    MainFunctionalities main_func;

    public TextMainController(){
        this.main_func = new MainFunctionalities();

        tp = new MainPrinter();

        this.m = new TextMapController(main_func.getMap());
        this.i = new TextInventoryController(main_func.getInventory());
        this.f = new TextFurnaceController(main_func.getFurnace());
    }

    public void update_printer(){
        m.update_printer();
        i.update_printer();
        f.update_printer();

        ((MainPrinter)tp).update((MapPrinter) m.getTextPrinter(), (InventoryPrinter) i.getTextPrinter(), (FurnacePrinter) f.getTextPrinter());
    }

    public void smelt(){
        this.main_func.smelt();
//        f.update_and_display();
//        i.update_and_display();
    }

    public void inv_to_furnace(int index){
        this.main_func.inv_to_furnace(index);
    }

    public void furnace_to_inv(){
        this.main_func.furnace_to_inv();
    }

    public void pick_up_block(Coords c) {
        this.main_func.pick_up_block(c);
    }

    public void toggle_inventory_comparator() {
        this.main_func.toggle_inventory_comparator();
    }
}
