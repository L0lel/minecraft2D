package visual;

import data.AirBlock;
import data.Furnace;

public class MainView {

    private Map main_map;
    private Furnace main_furnace;

    public MainView(Map m, Furnace f){

        this.main_map = m;
        this.main_furnace = f;

    }

    public void display_on_out(){

        this.main_map.display_on_out();
        this.main_furnace.display_on_out();

    }

    public void move_to_furnace(Coords c){
        if(main_map.isSmeltable(c)){
            main_furnace.setInput(main_map.getSmeltableBlock(c));
            main_map.insert_at_coords(new AirBlock(), c, true);
        }
    }
}
