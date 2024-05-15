package data.blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{

    public NullBlock(){
        super();
        this.blockname = "NullBlock";
        this.pickable = false;
    }

    public Block smelt(){
        return new NullBlock();
    }
}
