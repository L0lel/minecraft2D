package data;

public class Furnace {

    private SmeltableBlock input;
    private Block output;

    public Furnace(){
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    private void resetFurnace(){
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void display_on_out(){
        System.out.println("|| "
                + this.input.display()
                + " --> "
                + this.output.display()
                + " ||");
    }

    public Block smelt(){
        Block b = this.input.smelt();
        this.resetFurnace();
        return b;
    }

    public void setInput(SmeltableBlock b){
        this.input = b;
    }

    public SmeltableBlock getInput(){
        return this.input;
    }
}
