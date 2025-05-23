package com.example.hospital;


import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminController implements Initializable {

    @FXML
    private Label Admin_id;

    @FXML
    private Label Appointment;

    @FXML
    private Button Appointment_button;

    @FXML
    private AnchorPane Appointments_dashbord;

    @FXML
    private TableColumn<?, ?> Appointments_date;

    @FXML
    private TableColumn<?, ?> Appointments_doctors_id;

    @FXML
    private TableColumn<?, ?> Appointments_patients_id;

    @FXML
    private TableColumn<?, ?> Appointments_time;

    @FXML
    private Label Dashbord_AD;

    @FXML
    private Label Dashbord_TP;

    @FXML
    private TableView<?> Dashbord_Tabelview;

    @FXML
    private Button Dashbord_button;

    @FXML
    private Label Date;

    @FXML
    private Button Doctor_button;

    @FXML
    private Label ID;

    @FXML
    private Label Intro;

    @FXML
    private Button Pateint_button;

    @FXML
    private TableColumn<?, ?> Tabelview_DoctorID;

    @FXML
    private TableColumn<?, ?> Tabelview_Name;

    @FXML
    private TableColumn<?, ?> Tabelview_Speciality;

    @FXML
    private TableColumn<?, ?> appointments_id;

    @FXML
    private TableView<?> appointments_tabelview;

    @FXML
    private Label current_form;

    @FXML
    private AnchorPane dashboard;

    @FXML
    private BarChart<?, ?> dashbord_chart_DD;

    @FXML
    private AreaChart<?, ?> dashbord_chart_PD;

    @FXML
    private AnchorPane dashbord_form;

    @FXML
    private AnchorPane doctor_dashboard;

    @FXML
    private Label doctors;

    @FXML
    private TableColumn<?, ?> doctors_ID;

    @FXML
    private TableColumn<?, ?> doctors_contact;

    @FXML
    private TableColumn<?, ?> doctors_names;

    @FXML
    private TableColumn<?, ?> doctors_specialty;

    @FXML
    private TableView<?> doctors_tabelview;

    @FXML
    private Label feature;

    @FXML
    private Label patients;

    @FXML
    private TableColumn<?, ?> patients_age;

    @FXML
    private TableColumn<?, ?> patients_contact;

    @FXML
    private AnchorPane patients_dasbord;

    @FXML
    private TableColumn<?, ?> patients_gender;

    @FXML
    private TableColumn<?, ?> patients_id;

    @FXML
    private TableColumn<?, ?> patients_name;

    @FXML
    private Label status;

    @FXML
    private Circle status_color;

    @FXML
    private Circle top_profile;

    @FXML
    private Label username;

    @FXML
    private Label username_name;

    @FXML
    private Label welcome_user;

    public void switchForm(ActionEvent event) {

        if(event.getSource() == Dashbord_button){
            dashbord_form.setVisible(true);
            Appointments_dashbord.setVisible(false);
            doctor_dashboard.setVisible(false);
            patients_dasbord.setVisible(false);
        } else if (event.getSource() == Doctor_button) {
            dashbord_form.setVisible(false);
            Appointments_dashbord.setVisible(false);
            doctor_dashboard.setVisible(true);
            patients_dasbord.setVisible(false);
        } else if (event.getSource() == Pateint_button) {
            dashbord_form.setVisible(false);
            Appointments_dashbord.setVisible(false);
            doctor_dashboard.setVisible(false);
            patients_dasbord.setVisible(true);
        } else if (event.getSource() == Appointment_button) {
            dashbord_form.setVisible(false);
            Appointments_dashbord.setVisible(true);
            doctor_dashboard.setVisible(false);
            patients_dasbord.setVisible(false);

        }

    }

    public void runTime() {

        new Thread() {

            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {

                        Thread.sleep(1000); // 1000 ms = 1s

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        Date.setText(format.format(new Date()));
                    });
                }
            }
        }.start();

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        runTime();

    }
}
