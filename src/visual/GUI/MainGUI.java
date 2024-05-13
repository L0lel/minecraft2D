package visual.GUI;

import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane {

    private MapPane map_pane;
    private ButtonListPane button_list;
    private InventoryPane inv_pane;
    private FurnacePane furnace_pane;

    public MainGUI(){
        super();
        map_pane = new MapPane();
        super.setCenter(map_pane);
        button_list = new ButtonListPane(this);
        super.setLeft(button_list);
        inv_pane = new InventoryPane();
        super.setBottom(inv_pane);
        furnace_pane = new FurnacePane();
        super.setRight(furnace_pane);
    }

    public MapPane getMapPane() {
        return map_pane;
    }

    public InventoryPane getInventoryPane() {
        return this.inv_pane;
    }

    public FurnacePane getFurnacePane() {
        return this.furnace_pane;
    }
}
