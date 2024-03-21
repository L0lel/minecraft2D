package data;

public class AirBlock extends AbstractBlock{

    public AirBlock(){
        this.blockname = "Air";
        this.contenuto = AbstractBlock.DEFAULT_CONTENT;
        this.falls_with_gravity = AbstractBlock.DEFAULT_FALLS_WITH_GRAVITY;
        this.set_fall_through();
    }
}
