package data;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{

    public RawIronBlock(){
        this.blockname = "RawIron";
        this.contenuto = 'X';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public Block smelt() {
        return new IronSwordBlock();
    }
}
