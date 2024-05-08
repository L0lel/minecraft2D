package main;

import data.Furnace;
import utils.Coords;
import utils.WrongCoordinatesException;
import visual.textual.Inventory;
import visual.textual.MainView;
import visual.textual.Map;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map m = new Map();
        Furnace f = new Furnace();
        Inventory i = new Inventory();

        MainView view = new MainView(m, f, i);
        view.display_on_out();

        boolean loop = true;
        while(loop) {
            Scanner obj = new Scanner(System.in);
            System.out.println("Coordinate blocco: ");
            System.out.print("[x] ");
            int x_coord = obj.nextInt();
            System.out.print("[y] ");
            int y_coord = obj.nextInt();
            Coords c = null;
            try{
                c = new Coords(x_coord,y_coord);
            }catch (WrongCoordinatesException e){
                System.out.println("Coords ["+ x_coord +"]" + "["+ y_coord +"]" + " not in bounds of Map");
            }

            System.out.println("What do you want to do?");
            System.out.println("1 - Move block directly to Furnace"); // map_to_furnace
            System.out.println("2 - Move block to Inventory"); // pick_up_block
            System.out.println("3 - Move Furnace input to Inventory"); // furnace_to_inv
            System.out.println("4 - Smelt Furnace Input and add it to Inventory"); // smelt();
            System.out.println("5 - Toggle Inventory sorting mode"); // toggle_inventory_comparator
            System.out.println("Other - Move from Inventory to Furnace");
            System.out.print("[Option] ");
            int option = obj.nextInt();
            if (option == 1) {
                view.map_to_furnace(c);
            } else if (option == 2) {
                view.pick_up_block(c);
            } else if (option == 3) {
                view.furnace_to_inv();
            } else if (option == 4) {
                view.smelt();
            } else if (option == 5) {
                view.toggle_inventory_comparator();
            } else {
                System.out.println("Give index of inventory slot to take from");
                System.out.print("[i] ");
                int index = obj.nextInt();
                view.inv_to_furnace(index);
            }
            view.display_on_out();

            System.out.println("Vuoi fare altre azioni? [1] SI [0] NO");
            System.out.print("[Opzione] ");
            loop = obj.nextInt() != 0;
        }
    }
}