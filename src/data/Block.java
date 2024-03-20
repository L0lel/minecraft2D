package data;

public class Block {

    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    private static final char DEFAULT_CONTENT = '.';
    private static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    private static final boolean DEFAULT_FALL_THROUGH = true;

    public Block(int rand){
        switch(rand){
            case 0:
                this.contenuto = 'X';
                this.falls_with_gravity = true;
                break;
            case 1:
                this.contenuto = '+';
                this.falls_with_gravity = true;
                break;
            case 2:
                this.contenuto = 'o';
                this.falls_with_gravity = true;
                break;
            default:
                this.contenuto = Block.DEFAULT_CONTENT;
                this.falls_with_gravity = true;
                break;
        }
        this.set_fall_through();
    }

    public Block(char content){
        this.contenuto = content;
        this.falls_with_gravity = true;
        this.set_fall_through();
    }

    public Block(){
        this.contenuto = Block.DEFAULT_CONTENT;
        this.falls_with_gravity = Block.DEFAULT_FALLS_WITH_GRAVITY;
        this.set_fall_through();
    }

    public char display(){
        return this.contenuto;
    }

    public boolean has_gravity(){
        return this.falls_with_gravity;
    }

    public boolean does_fall_through(){
        return this.fall_through;
    }

    private void set_fall_through(){
        this.fall_through = this.isDefault();
    }

    public boolean isDefault(){
        return this.contenuto == Block.DEFAULT_CONTENT;
    }
}
