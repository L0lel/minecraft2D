package main;

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
import visual.textual.Map;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minecraft now in 2D!");

        MainGUI view = new MainGUI();

//        Map m = new Map();
//        MapPane mp = view.getMapPane();
//
//        for(int i = 0; i < Map.DIM_ROWS; i++){
//            for(int j = 0; j < Map.DIM_COLUMNS; j++){
//                mp.setCell(new Coords(i,j), m.content[i][j]);
//            }
//        }

        Scene scene = new Scene(view);
        scene.setFill(Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}