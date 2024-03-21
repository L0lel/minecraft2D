package data;

public abstract class AbstractBlock implements Block{

    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;

    protected String blockname;

    protected static final char DEFAULT_CONTENT = '.';
    protected static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    protected static final boolean DEFAULT_FALL_THROUGH = true;

    public char display(){
        return this.contenuto;
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

//    public void toString(){
//        System.out.println("Block: " + this.blockname);
//        if(this.has_gravity()){
//            System.out.println("Has gravity: Yes");
//        }else{
//            System.out.println("Has gravity: No");
//        }
//        if(this.does_fall_through()){
//            System.out.println("Fall Through: Yes");
//        }else{
//            System.out.println("Fall Through: Yes");
//        }
//    }
}
