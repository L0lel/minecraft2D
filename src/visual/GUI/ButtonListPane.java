package visual.GUI;

import data.BlockFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Coords;

public class ButtonListPane extends VBox {

    Button pick_block_button;
    TextField pick_row_text;
    TextField pick_col_text;
    HBox pick_block_hbox;

    Button smelt_button;
    Button move_to_furnace_button;
    TextField inventory_index_text;
    HBox move_to_furnace_hbox;
    Button move_to_inventory_button;

    Button toggle_inv_sorting_button;

    private final MainGUI mc;

    public ButtonListPane(MainGUI m){
        super();

        mc = m;

        pick_block_hbox = new HBox();
        pick_row_text = new TextField();
        pick_block_hbox.getChildren().add(pick_row_text);
        pick_col_text = new TextField();
        pick_block_hbox.getChildren().add(pick_col_text);
        create_pick_button();
        pick_block_hbox.getChildren().add(pick_block_button);
        super.getChildren().add(pick_block_hbox);

        move_to_furnace_hbox = new HBox();
        inventory_index_text = new TextField();
        move_to_furnace_hbox.getChildren().add(inventory_index_text);
        create_move_to_furnace_button();
        move_to_furnace_hbox.getChildren().add(move_to_furnace_button);
        super.getChildren().add(move_to_furnace_hbox);

        create_smelt_button();
        super.getChildren().add(smelt_button);

        create_move_to_inventory_button();
        super.getChildren().add(move_to_inventory_button);

        create_toggle_inventory_sorting();
        super.getChildren().add(toggle_inv_sorting_button);

        Button test_button = new Button("Test");
        test_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //BlockPane bp = (BlockPane) MapPane.getElementAt(mc.getMainGUI().getMapPane(),0,0);
                BlockPane bp = (BlockPane) MapPane.getElementAt(mc.getMapPane(),0,0);
                bp.changeBlock(BlockFactory.sand_block());
                bp.initialise();
            }
        });
        super.getChildren().add(test_button);
    }

    private void create_toggle_inventory_sorting() {
        toggle_inv_sorting_button = new Button("Toggle Sorting Mode");
        toggle_inv_sorting_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO
            }
        });
    }

    private void create_move_to_inventory_button(){
        move_to_inventory_button = new Button("Move to Inventory");
        move_to_inventory_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //mc.move_from_inventory_to_furnace();
                //mc.redraw();
            }
        });
    }

    private void create_move_to_furnace_button(){
        move_to_furnace_button = new Button("Move to Furnace");
        move_to_furnace_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = Integer.parseInt(inventory_index_text.getText());
                //mc.move_from_furnace_to_inventory
                //mc.redraw();
            }
        });
    }

    private void create_smelt_button(){
        smelt_button = new Button("Smelt");
        smelt_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //mc.smelt();
                //mc.redraw();
            }
        });
    }

    private void create_pick_button(){
        pick_block_button = new Button("Pick Block");
        pick_block_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int row = Integer.parseInt(pick_row_text.getText());
                int col = Integer.parseInt(pick_col_text.getText());
                Coords c = new Coords(row,col);
                //mc.pick_block(c);
                //mc.redraw();
            }
        });
    }
}
