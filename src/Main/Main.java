package Main;

import java.util.Scanner;

import data.Block;
import data.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Inizio Main");

        Map m = new Map();

        for(int i = 0; i < 5; i++){
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            System.out.println("Changing: " + row + " - " + col);
            m.change_cell(row,col);
        }

        m.display_on_out();

        System.out.println("Dove inserire un nuovo blocco?");
        System.out.println("[x] ");
        Scanner myObj = new Scanner(System.in);
        int x_coord = myObj.nextInt();

        System.out.println("[y] ");
        int y_coord = myObj.nextInt();

        m.insert_at_coords(new Block('T', true, false), x_coord, y_coord);

        m.display_on_out();

        System.out.println("Fine Main");

    }
}