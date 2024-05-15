package visual.textual;

import data.blocks.Block;
import data.model.Map;

public class MapPrinter implements TextPrinter{

    private Block[][] content;

    public void update(Block[][] c){
        this.content = c;
    }

    public void display_on_out() {

        System.out.println();
        System.out.print("|");
        for (int i = 0; i < Map.DIM_COLUMNS + 2; i++) {
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();

        for (int i = 0; i < Map.DIM_ROWS; i++) {
            System.out.print("||");
            for (int j = 0; j < Map.DIM_COLUMNS; j++) {
                System.out.print(this.content[i][j].display());
            }
            System.out.print("||");
            System.out.println();
        }

        System.out.print("|");
        for (int i = 0; i < Map.DIM_COLUMNS + 2; i++){
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();

    }
}
