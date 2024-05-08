package data;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{

    protected NullBlock(){
        super();
        this.pickable = false;
    }

    public Block smelt(){
        return new NullBlock();
    }
}
