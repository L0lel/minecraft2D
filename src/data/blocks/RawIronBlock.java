package data.blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{

    public RawIronBlock(){
        super();
        this.blockname = "RawIron";
        this.contenuto = 'X';
    }

    public Block smelt() {
        return new IronSwordBlock();
    }
}
