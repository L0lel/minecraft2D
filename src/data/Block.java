package data;

public class Block {

    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    private static final char DEFAULT_CONTENT = '.';
    private static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    private static final boolean DEFAULT_FALL_THROUGH = true;

    public Block(char content, boolean gravity, boolean fallsThrough){
        this.contenuto = content;
        this.falls_with_gravity = gravity;
        this.fall_through = fallsThrough;
    }

    public Block(char content){
        this(content, DEFAULT_FALLS_WITH_GRAVITY, DEFAULT_FALL_THROUGH);
    }

    public Block(){
        this(DEFAULT_CONTENT, DEFAULT_FALLS_WITH_GRAVITY, DEFAULT_FALL_THROUGH);
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
}
