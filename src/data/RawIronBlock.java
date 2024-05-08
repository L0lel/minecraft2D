package data;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{

    protected RawIronBlock(){
        super();
        this.blockname = "RawIron";
        this.contenuto = 'X';
    }

    public Block smelt() {
        return new IronSwordBlock();
    }
}
