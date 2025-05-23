package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private Button login_button;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private PasswordField enterpassword;
    @FXML
    private TextField enterusername;
    @FXML
    private ChoiceBox<String> choose;
    @FXML
    private Label myLabel;
    @FXML
    private Label wrong;


    private String[] Choose = {"Doctor","Admin","Patient"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choose.getItems().addAll(Choose);
        choose.setOnAction(this::getChoose);
    }

    public void getChoose(ActionEvent event) {
        String choose = this.choose.getValue();
        myLabel.setText(choose);
    }

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin(event);
    }

    private void checkLogin(ActionEvent event) throws IOException {



        if (enterusername.getText().equals("admin") && enterpassword.getText().equals("123")) {
            wrong.setText("Success!");

            // Get the selected role from ChoiceBox
            String selectedRole = choose.getValue();

            if (selectedRole != null) {
                String fxmlFile;
                // Determine which FXML file to load based on the selected role
                switch (selectedRole) {
                    case "Doctor":
                        fxmlFile = "Doctor.fxml";
                        break;
                    case "Patient":
                        fxmlFile = "Patient.fxml";
                        break;
                    case "Admin":
                        fxmlFile = "Admin.fxml";
                        break;
                    default:
                        wrong.setText("Please select a role!");
                        return;
                }

                // Load the appropriate FXML file
                Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
                Scene scene = new Scene(root);

                // Get the Stage information
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

                // Set the Scene
                stage.setTitle("Hospital Management System");
                stage.setScene(scene);
                stage.show();




            } else {
                wrong.setText("Please select a role!");
            }
        } else if (enterusername.getText().isEmpty() && enterpassword.getText().isEmpty()) {
            wrong.setText("Enter username and password!");
        } else {
            wrong.setText("Wrong username or password!");
        }
    }
}