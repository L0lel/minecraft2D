package visual.GUI;

import controller.simple.MainSimpleController;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import visual.GUI.handlers.BlockPaneClickHandlerFactory;

public class MainGUI extends BorderPane {

    private MapPane map_pane;
    private ButtonListPane button_list;
    private InventoryPane inv_pane;
    private FurnacePane furnace_pane;

    private BlockPaneClickHandlerFactory handlerFactory;

    private final Color bg_color = Color.GAINSBORO;

    public MainGUI(MainSimpleController controller){
        super();

        this.handlerFactory = new BlockPaneClickHandlerFactory(controller);

        map_pane = new MapPane(handlerFactory);
        super.setCenter(map_pane);
        button_list = new ButtonListPane(controller);
        super.setLeft(button_list);
        inv_pane = new InventoryPane();
        super.setBottom(inv_pane);
        furnace_pane = new FurnacePane();
        super.setRight(furnace_pane);

        super.setBackground(new Background(new BackgroundFill(bg_color, null, null)));


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
