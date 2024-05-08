package visual.GUI;

import data.Block;
import data.BlockFactory;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import utils.Coords;
import visual.textual.Map;

public class MapPane extends GridPane {

    public MapPane(){
        super();
        initialise_air();
    }

    public void initialise_air(){
        for(int i = 0; i < Map.DIM_ROWS; i++){
            for(int j = 0; j < Map.DIM_COLUMNS; j++){
                BlockPane bp = new BlockPane(BlockFactory.air_block());
                super.add(bp, j,i);
            }
        }
    }

    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public BlockPane get_block_at_coord(Coords c){
        if(!c.isInBound()){
            return  null;
        }
        int row = c.getX();
        int col = c.getY();

        return (BlockPane) MapPane.getElementAt(this, row, col);
    }

    public void setCell(Coords c, Block b){
        if(this.get_block_at_coord(c) == null){
            super.add(new BlockPane(b), c.getY(), c.getX());
        }else {
            this.get_block_at_coord(c).changeBlock(b);
        }
    }


}
