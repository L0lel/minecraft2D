package visual.GUI;

import controller.simple.MainSimpleController;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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

        super.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case S:
                        controller.toggle_inventory_comparator();
                        break;
                    case N:
                        controller.add_random_block();
                        break;
                    case R:
                        for(int i = 0 ; i < 10 ; i++){
                            controller.add_random_block();
                        }
                        break;
                    default:
                        System.out.println("Key pressed is not bound to any action");
                        break;
                }
            }
        });
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
