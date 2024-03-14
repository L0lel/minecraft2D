package data;

public class Map {

    private static final int DIM_COLUMNS = 10;
    private static final int DIM_ROWS = 5;

    private Block[][] content;

    public Map(){
        this(false);
    }

    public Map(boolean random){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = 0; i < DIM_ROWS; i++){
            for(int j = 0; j < DIM_COLUMNS; j++){
                Block b = null;
                if(random){
                    //TODO
                } else{
                    b = new Block();
                }
                this.content[i][j] = b;
            }
        }
    }

    public void display_on_out(){
        for(int i = 0; i < DIM_ROWS; i++){
            for(int j = 0; j < DIM_COLUMNS; j++){
                System.out.println(this.content[i][j].display());
            }
        }
    }

    public void change_cell(int row, int col){
        if(row >= DIM_ROWS || col >= DIM_COLUMNS){
            return;
        }
        this.content[row][col] = new Block('A');
    }
}
