package visual.textual;

import data.blocks.Block;
import data.blocks.SmeltableBlock;

public class FurnacePrinter implements TextPrinter{

    private SmeltableBlock input;
    private Block output;

    public void update(SmeltableBlock i, Block o){
        this.input = i;
        this.output = o;
    }

    public void display_on_out(){
        System.out.println("|| "
                + this.input.display()
                + " --> "
                + this.output.display()
                + " ||");
    }
}
