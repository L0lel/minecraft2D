package data.blocks;

public class AirBlock extends AbstractBlock{

    public AirBlock(){
        super();
        this.blockname = "Air";
        this.contenuto = AbstractBlock.DEFAULT_CONTENT;
        this.falls_with_gravity = AbstractBlock.DEFAULT_FALLS_WITH_GRAVITY;
        this.set_fall_through();
    }
}
