package data.blocks;

public abstract class AbstractBlock implements Block{

    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected boolean pickable;
    protected boolean entity_block; // ex: Sand and Gravel (entity_blocks) break if they fall on a torch
    protected int block_value;

    protected String blockname;

    protected static final char DEFAULT_CONTENT = '.';
    protected static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    protected static final boolean DEFAULT_FALL_THROUGH = true;

    public AbstractBlock(){
        this.pickable = false;
        this.entity_block = false;
    }

    public char display(){
        return this.contenuto;
    }

    public void display_in_inventory(){
        System.out.print("["+contenuto+"]");
    }

    public boolean has_gravity(){
        return this.falls_with_gravity;
    }

    public boolean does_fall_through(){
        return this.fall_through;
    }

    protected void set_fall_through(){
        this.fall_through = this.isDefault();
    }

    public boolean isDefault(){
        return this.contenuto == AbstractBlock.DEFAULT_CONTENT;
    }

    public boolean is_pickable(){
        return this.pickable;
    }

    public int getBlock_value() {
        return block_value;
    }

    public void setBlock_value(int value){
        this.block_value = value;
    }

    public boolean isEntityBlock(){
        return this.entity_block;
    }

    public String getBlockname() {
        return blockname;
    }

    @Override
    public String toString(){
        String info_summary = "Block: " + this.blockname;
        if(this.has_gravity()){
            info_summary.concat("\nHas gravity: Yes");
        }else{
            info_summary.concat("\nHas gravity: No");
        }
        if(this.does_fall_through()){
            info_summary.concat("\nFall Through: Yes");
        }else{
            info_summary.concat("\nFall Through: Yes");
        }
        return info_summary;
    }
}
