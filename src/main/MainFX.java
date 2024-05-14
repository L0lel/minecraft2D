package main;

import controller.MainSimpleController;
import controller.SimpleController;
import data.Furnace;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import utils.Coords;
import visual.GUI.FurnacePane;
import visual.GUI.InventoryPane;
import visual.GUI.MainGUI;
import visual.GUI.MapPane;
import visual.textual.Inventory;
import visual.textual.MainView;
import visual.textual.Map;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minecraft now in 2D!");

        MainSimpleController main_controller = new MainSimpleController(new MainView());

        Scene scene = new Scene(main_controller.getMainGUI());
        scene.setFill(Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}