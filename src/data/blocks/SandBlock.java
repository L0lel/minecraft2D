package data.blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock{

    public SandBlock(){
        super();
        this.blockname = "Sand";
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.pickable = true;
        this.entity_block = true;
    }

    public Block smelt(){
        return new GlassBlock();
    }
}
