package visual.GUI;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class InventoryPane extends HBox {

    Text i;
    HBox inventory;

    public InventoryPane(){
        super();
        //TEXT?
        this.inventory = new HBox();
        super.getChildren().add(inventory);
    }



}
