package data;

public class Block {

    private char[] contenuto;

    public Block(char content){
        this.contenuto = new char[]{content};
    }

    public Block(){
        this('.');
    }

    public char[] display(){
        return this.contenuto;
    }
}
