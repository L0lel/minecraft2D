package visual.GUI.clickableBlockPanes;

import controller.simple.MainSimpleController;
import data.blocks.Block;
import data.blocks.SmeltableBlock;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import visual.GUI.BlockPane;

public class InternalClickableBlockPane extends BlockPane {

    public InternalClickableBlockPane(Block bb, MainSimpleController mc){
        super(bb);
        EventHandler<MouseEvent> bpch; //button_pressed_click_handler
        if(bb instanceof SmeltableBlock){
            bpch = new BlockPaneSmeltClickHandler(mc);
        }else{
            bpch = new BlockPaneMoveBackClickHandler(mc);
        }
        this.setOnMouseClicked(bpch);
    }

    static class BlockPaneSmeltClickHandler implements EventHandler<MouseEvent>{
        private final MainSimpleController mc;

        BlockPaneSmeltClickHandler(MainSimpleController main_controller){
            this.mc = main_controller;
        }

        public void handle(MouseEvent mouseEvent){
            mc.smelt();
        }
    }

    static class BlockPaneMoveBackClickHandler implements EventHandler<MouseEvent>{
        private final MainSimpleController mc;

        BlockPaneMoveBackClickHandler(MainSimpleController main_controller){
            this.mc = main_controller;
        }

        public void handle(MouseEvent mouseEvent){
            mc.furnace_to_inv();
        }
    }

}
