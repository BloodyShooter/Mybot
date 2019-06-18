package org.gvozdetscky.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();

        Label label = new Label("name bot");

        Button btnStart = new Button("launch");

        btnStart.setOnAction(event ->{
            btnStart.setText(btnStart.getText() + "its alive!!!");
        });

        root.getChildren().addAll(label, btnStart);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
