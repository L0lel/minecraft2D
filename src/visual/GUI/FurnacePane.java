package visual.GUI;

import data.BlockFactory;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {

    private BlockPane input;
    private BlockPane output;

    public FurnacePane(){
        super();
        addText();
        input = new BlockPane(BlockFactory.null_block());
        super.getChildren().add(input);
        addArrow();
        output = new BlockPane(BlockFactory.null_block());
        super.getChildren().add(output);
        super.setAlignment(Pos.TOP_CENTER);
    }

    public void addText(){
        Text f = new Text("Furnace: ");
        super.getChildren().add(f);
    }

    public void addArrow(){
        Text arrow = new Text("▽");
        super.getChildren().add(arrow);
    }
}
