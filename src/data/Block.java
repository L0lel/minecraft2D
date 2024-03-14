package data;

public class Block {

    private char contenuto;
    private boolean falls_with_gravity;
    private boolean falls_through;

    private static final char DEFAULT_CONTENT = '.';
    private static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    private static final boolean DEFAULT_FALL_THROUGH = true;

    public Block(char content){
        this.contenuto = content;
        this.falls_with_gravity = true;
        this.falls_through = false;
    }

    public Block(){
        this.contenuto = '.';
        this.falls_with_gravity = DEFAULT_FALLS_WITH_GRAVITY;
        this.falls_through = DEFAULT_FALL_THROUGH;
    }

    public boolean isWithGravity(){
        return this.falls_with_gravity;
    }

    public boolean doesFallThrough(){
        return this.falls_through;
    }

    public char display(){
        return this.contenuto;
    }
}
