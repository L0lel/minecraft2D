package visual.GUI;

import data.Block;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BlockPane extends StackPane {

    private Rectangle sfondo;
    private Text testo;

    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;

    private Block blocco;

    public BlockPane(Block b){
        super();
        this.blocco = b;

        initialise();
    }

    private void initialise() {
        this.sfondo = new Rectangle(DIM_SQUARE,DIM_SQUARE);
        this.sfondo.setFill(BlockPane.chooseColorFromBlock(this.blocco));
        this.sfondo.setStroke(BLOCK_BORDER);

        this.testo = new Text(""+this.blocco.display());
        this.testo.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        this.testo.setFill(FONT_FILL);
        this.testo.setStroke(FONT_BORDER);

        super.getChildren().addAll(sfondo,testo);
        super.setAlignment(Pos.CENTER);
    }

    private static Color chooseColorFromBlock(Block blocco) {
        int blockInt = blocco.getBlock_value();
        Color result = null;
        switch(blockInt){
            case 0:
                result = Color.BLACK;
                break;
            case 1:
                result = Color.WHITE;
                break;
            case 2:
                result = Color.AQUA;
                break;
            case 3:
                result = Color.GREEN;
                break;
            case 4:
                result = Color.BEIGE;
                break;
            case 5:
                result = Color.AZURE;
                break;
            case 6:
                result = Color.DARKGRAY;
                break;
            case 7:
                result = Color.SILVER;
                break;
        }
        return result;
    }

    public void changeBlock(Block b){
        this.blocco = b;
        initialise();
    }

}
