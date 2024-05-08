package data;

public class AirBlock extends AbstractBlock{

    protected AirBlock(){
        super();
        this.blockname = "Air";
        this.contenuto = AbstractBlock.DEFAULT_CONTENT;
        this.falls_with_gravity = AbstractBlock.DEFAULT_FALLS_WITH_GRAVITY;
        this.set_fall_through();
    }
}
