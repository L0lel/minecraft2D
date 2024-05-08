package visual.textual;

import data.*;
import utils.BlockErrorException;
import utils.Coords;

public class MainView {

    private Map m;
    private Furnace f;
    private Inventory i;

    public MainView(Map m, Furnace f, Inventory i){
        this.m = m;
        this.f = f;
        this.i = i;
    }

    public void display_on_out(){
        this.m.display_on_out();
        this.f.display_on_out();
        this.i.display_inventory();
    }

    public void map_to_furnace(Coords c){
        try{
            SmeltableBlock sb = this.m.getSmeltableBlock(c);
            this.f.setInput(sb);
            m.insert_at_coords(BlockFactory.air_block(), c, true);
        }catch (BlockErrorException e) {
            System.out.println("Block selected not smeltable");
        }
    }

    public void inv_to_furnace(int index){
        try{
            SmeltableBlock b = this.i.get_smeltable_item(index);
            this.i.pop_item(index);
            this.f.setInput(b);
        }catch(BlockErrorException e){
            System.out.println("Block selected not smeltable");
        }
    }

    public void furnace_to_inv(){
        this.i.add_block(this.f.getInput());
        this.f.setInput(BlockFactory.null_block());
    }

    public void smelt(){
        Block b = this.f.smelt();
        this.i.add_block(b);
    }

    public void pick_up_block(Coords c){
        try{
            this.i.add_block(this.m.givePickable(c));
        }catch (BlockErrorException e){
            System.out.println("Block selected not pickable");
        }
    }

    public void toggle_inventory_comparator(){this.i.toggleComparatorMode();}

}
