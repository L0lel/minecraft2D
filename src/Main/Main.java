package Main;

import visual.Map;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map m = new Map();

        m.display_on_out();

        Scanner obj = new Scanner(System.in);
        System.out.println("Inserisci un blocco di sabbia");
        System.out.print("[x] ");
        int x_coord = obj.nextInt();
        System.out.print("[y] ");
        int y_coord = obj.nextInt();

        m.change_cell(x_coord,y_coord);

        m.display_on_out();

    }
}