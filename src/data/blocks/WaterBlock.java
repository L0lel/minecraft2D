package data.blocks;

public class WaterBlock extends AbstractBlock{

    public WaterBlock(){
        super();
        this.blockname = "Water";
        this.contenuto = '~';
        this.falls_with_gravity = true;
        this.fall_through = true;
    }
}
