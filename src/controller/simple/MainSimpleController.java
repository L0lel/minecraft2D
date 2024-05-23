package controller.simple;

import utils.Coords;
import visual.GUI.MainGUI;
import data.model.MainFunctionalities;

import java.util.ArrayList;
import java.util.Iterator;

public class MainSimpleController implements SimpleController{

    MainFunctionalities view;
    MainGUI gui;

    ArrayList<SimpleController> controllersList;
    MapSimpleController map_controller;
    InventorySimpleController inv_controller;
    FurnaceSimpleController furnace_controller;

    public MainSimpleController(MainFunctionalities v){
        this.view = v;
        this.gui = new MainGUI(this);

        map_controller = new MapSimpleController(view.getMap(), gui.getMapPane());
        inv_controller = new InventorySimpleController(view.getInventory(), gui.getInventoryPane(), this);
        furnace_controller = new FurnaceSimpleController(view.getFurnace(), gui.getFurnacePane(), this);

        controllersList = new ArrayList<SimpleController>();
        controllersList.add(map_controller);
        controllersList.add(inv_controller);
        controllersList.add(furnace_controller);
    }

    public void redraw() {
        Iterator<SimpleController> i = this.controllersList.iterator();
        while (i.hasNext()){
            i.next().redraw();
        }
    }

    public void smelt(){
        this.view.smelt();
        furnace_controller.redraw();
        inv_controller.redraw();
    }

    public void inv_to_furnace(int index){
        this.view.inv_to_furnace(index);
        furnace_controller.redraw();
        inv_controller.redraw();
    }

    public void furnace_to_inv(){
        this.view.furnace_to_inv();
        furnace_controller.redraw();
        inv_controller.redraw();
    }

    public void pick_up_block(Coords c){
        this.view.pick_up_block(c);
        map_controller.redraw();
        inv_controller.redraw();
    }

    public void toggle_inventory_comparator(){
        this.view.toggle_inventory_comparator();
        inv_controller.redraw();
    }

    public MainGUI getMainGUI() {
        return this.gui;
    }
}
