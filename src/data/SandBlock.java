package data;

public class SandBlock extends AbstractBlock implements SmeltableBlock{

    public SandBlock(){
        this.blockname = "Sand";
        this.contenuto = 'A';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public Block smelt(){
        return new GlassBlock();
    }
}
