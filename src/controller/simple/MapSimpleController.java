package controller.simple;

import utils.Coords;
import visual.GUI.MapPane;
import data.model.Map;

public class MapSimpleController implements SimpleController{

    Map m;
    MapPane mp;

    public MapSimpleController(Map mappa, MapPane map_pane){
        this.m = mappa;
        this.mp = map_pane;
        redraw();
    }

    public void redraw() {
        for(int i = 0; i < Map.DIM_ROWS; i++){
            for(int j = 0; j < Map.DIM_COLUMNS; j++){
                mp.setCell(new Coords(i,j), m.content[i][j]);
            }
        }
    }
}
