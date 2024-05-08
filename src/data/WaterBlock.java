package data;

public class WaterBlock extends AbstractBlock{

    protected WaterBlock(){
        super();
        this.blockname = "Water";
        this.contenuto = 'W';
        this.falls_with_gravity = true;
        this.fall_through = true;
    }
}
