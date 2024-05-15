package main;

import controller.simple.MainSimpleController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import data.model.MainFunctionalities;

public class SimpleMainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minecraft now in 2D!");

        MainSimpleController main_controller = new MainSimpleController(new MainFunctionalities());

        Scene scene = new Scene(main_controller.getMainGUI());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}