package visual.GUI;

import data.blocks.Block;
import data.BlockFactory;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import utils.Coords;
import utils.WrongCoordinatesException;
import data.model.Map;
import visual.GUI.clickableBlockPanes.ExternalClickableBlockPane;
import visual.GUI.handlers.BlockPaneClickHandlerFactory;

public class MapPane extends GridPane {

    private BlockPaneClickHandlerFactory handlerFactory;

    public MapPane(BlockPaneClickHandlerFactory hf){
        super();
        this.handlerFactory = hf;
        initialise_air();
    }

    public void initialise_air(){
        for(int i = 0; i < Map.DIM_ROWS; i++){
            for(int j = 0; j < Map.DIM_COLUMNS; j++){
                this.setCell(new Coords(i,j), BlockFactory.air_block());
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
        try {
            if(!c.isInBound()){
                return  null;
            }
        } catch (WrongCoordinatesException e) {
            throw new RuntimeException(e);
        }
        int row = c.getX();
        int col = c.getY();

        return (BlockPane) MapPane.getElementAt(this, row, col);
    }

    public void setCell(Coords c, Block b){
        if(this.get_block_at_coord(c) == null){
            EventHandler<MouseEvent> eventHandler = this.handlerFactory.createNewPickUpHandler(c);
            super.add(new ExternalClickableBlockPane(b, eventHandler), c.getY(), c.getX());
        }else {
            this.get_block_at_coord(c).changeBlock(b);
        }
    }

}
