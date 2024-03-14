package Main;

import java.util.Scanner;
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

        System.out.println("Fine Main");

    }
}