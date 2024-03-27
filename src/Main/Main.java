package Main;

import data.Furnace;
import visual.Coords;
import visual.MainView;
import visual.Map;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map m = new Map();
        Furnace f = new Furnace();

        MainView view = new MainView(m, f);

        view.display_on_out();

        Scanner obj = new Scanner(System.in);
        System.out.println("Coordinate blocco da smeltare: ");
        System.out.print("[x] ");
        int x_coord = obj.nextInt();
        System.out.print("[y] ");
        int y_coord = obj.nextInt();

        view.move_to_furnace(new Coords(x_coord, y_coord));

        view.display_on_out();

    }
}