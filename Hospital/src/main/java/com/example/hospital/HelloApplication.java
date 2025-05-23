package com.example.hospital;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class HelloApplication extends Application {

    private static Stage stg;
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));


            Scene scene = new Scene(root);



            // Configure stage
            stage.setTitle("Hospital Management System");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                exit(stage);
            });

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void exit(Stage stage ) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Click ok to exit.");

        if (alert.showAndWait().get() == ButtonType.OK) {

           // stage = (Stage) scenepane.getScene().getWindow();
            stage.close();
            System.out.println("you succefully exit");
            stage.close();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}