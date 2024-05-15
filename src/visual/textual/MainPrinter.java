package visual.textual;

public class MainPrinter implements TextPrinter{

    MapPrinter m;
    InventoryPrinter i;
    FurnacePrinter f;

    public void update(MapPrinter map, InventoryPrinter inv, FurnacePrinter fur){
        this.m = map;
        this.i = inv;
        this.f = fur;
    }

    public void display_on_out(){
        this.m.display_on_out();
        this.f.display_on_out();
        this.i.display_on_out();
    }
}
