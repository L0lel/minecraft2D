package data;

public class Map {

    private static final int DIM_COLUMNS = 10;
    private static final int DIM_ROWS = 10;

    private Block[][] content;

    public Map(){

        this.content = new Block[DIM_ROWS][DIM_COLUMNS];

        for(int i = 0; i < DIM_ROWS; i++){
            for(int j = 0; j < DIM_COLUMNS; j++){
                this.content[i][j] = new Block();
            }
        }
    }

    public void display_on_out(){
        for(int i = 0; i < DIM_ROWS; i++){
            for(int j = 0; j < DIM_COLUMNS; j++){
                System.out.print(this.content[i][j].display());
            }
            System.out.println("");
        }
    }

    public void change_cell(int row, int col){
        if(row < 0 || row >= DIM_ROWS || col < 0 || col >= DIM_COLUMNS){
            return;
        }
        this.content[row][col] = new Block('A');
    }

    public void swap(int x, int y){
        if(x < 0 || x >= DIM_ROWS-1 || y < 0 || y >= DIM_COLUMNS){
            return;
        }
        Block tmp = this.content[x][y];
        this.content[x][y] = this.content[x+1][y];
        this.content[x+1][y] = tmp;
    }

    public void insert_at_coords(Block b, int x, int y){
        if(x < 0 || x >= DIM_ROWS || y < 0 || y >= DIM_COLUMNS){
            return;
        }

        this.content[x][y] = b;

        insert_rec(b, x, y);
    }

    public void insert_rec(Block b, int x, int y){
        if(x == DIM_COLUMNS-1 || !b.has_gravity() || !this.content[x+1][y].does_fall_through()){
            return;
        }
        this.swap(x,y);
        this.insert_rec(b, x+1, y);
    }
}
