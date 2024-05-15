package main;

import controller.textual.TextMainController;
import utils.Coords;
import data.model.MainFunctionalities;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TextMainController view = new TextMainController();
        view.update_and_display();

        boolean loop = true;
        while(loop) {
            Scanner obj = new Scanner(System.in);
            System.out.println("Coordinate blocco: ");
            System.out.print("[x] ");
            int x_coord = obj.nextInt();
            System.out.print("[y] ");
            int y_coord = obj.nextInt();
            Coords c = new Coords(x_coord,y_coord);

            System.out.println("What do you want to do?");
            System.out.println("1 - Move block to Inventory"); // pick_up_block
            System.out.println("2 - Move Furnace input to Inventory"); // furnace_to_inv
            System.out.println("3 - Smelt Furnace Input and add it to Inventory"); // smelt();
            System.out.println("4 - Toggle Inventory sorting mode"); // toggle_inventory_comparator
            System.out.println("5 - Move from Inventory to Furnace");
            System.out.print("[Option] ");
            int option = obj.nextInt();
            if (option == 1) {
                view.pick_up_block(c);
            } else if (option == 2) {
                view.furnace_to_inv();
            } else if (option == 3) {
                view.smelt();
            } else if (option == 4) {
                view.toggle_inventory_comparator();
            } else if (option == 5){
                System.out.println("Give index of inventory slot to take from");
                System.out.print("[i] ");
                int index = obj.nextInt();
                view.inv_to_furnace(index);
            }
            view.update_and_display();

            System.out.println("Vuoi fare altre azioni? [1] SI [0] NO");
            System.out.print("[Opzione] ");
            loop = obj.nextInt() != 0;
        }
    }
}