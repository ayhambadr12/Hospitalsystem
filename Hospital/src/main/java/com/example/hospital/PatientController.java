package com.example.hospital;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class PatientController  implements Initializable {

    @FXML
    private AnchorPane About_appointment;

    @FXML
    private TextField Doctor_Name;

    @FXML
    private AnchorPane About_doctor;

    @FXML
    private AnchorPane About_patient;

    @FXML
    private Label Admin_id;

    @FXML
    private Label Appointment;

    @FXML
    private Label Appointment1;

    @FXML
    private Button Appointment_button;

    @FXML
    private AnchorPane Appointments_dashbord;

    @FXML
    private TableColumn<?, ?> Appointments_date1;

    @FXML
    private TableColumn<?, ?> Appointments_doctors_id1;

    @FXML
    private TableColumn<?, ?> Appointments_patients_id1;

    @FXML
    private TableColumn<?, ?> Appointments_time1;

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
    private TextField age_pateint;

    @FXML
    private Button appointment_clear;

    @FXML
    private Button appointment_confirm;

    @FXML
    private ComboBox<?> appointment_doctor_name;

    @FXML
    private TableColumn<?, ?> appointments_id1;

    @FXML
    private Button book;

    @FXML
    private Label current_form;

    @FXML
    private TextField date;

    @FXML
    private Label doctor_contact;

    @FXML
    private AnchorPane doctor_dashboard;

    @FXML
    private Label doctor_id;

    @FXML
    private Label doctor_name;

    @FXML
    private TextField doctor_specialaize;

    @FXML
    private Label doctor_speciality;

    @FXML
    private Label doctors;

    @FXML
    private Label feature;

    @FXML
    private TextField gender_patient;

    @FXML
    private AnchorPane home_form;

    @FXML
    private TextField name_patient;

    @FXML
    private TableColumn<?, ?> patients_age1;

    @FXML
    private TableColumn<?, ?> patients_contact1;

    @FXML
    private TableColumn<?, ?> patients_gender1;

    @FXML
    private TableColumn<?, ?> patients_id1;

    @FXML
    private TableColumn<?, ?> patients_name1;

    @FXML
    private Label status;

    @FXML
    private Circle status_color;

    @FXML
    private TableView<?> tabel_appointment;

    @FXML
    private TableView<?> tabel_patient;

    @FXML
    private Circle top_profile;

    @FXML
    private Label username;

    @FXML
    private Label username_name;

    @FXML
    private Label welcome_user;
    @FXML
    private void showPatientScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == Dashbord_button) {
            home_form.setVisible(true);
            Appointments_dashbord.setVisible(false);
            doctor_dashboard.setVisible(false);
        } else if (event.getSource() == Doctor_button) {
            home_form.setVisible(false);
            Appointments_dashbord.setVisible(false);
            doctor_dashboard.setVisible(true);
        } else if (event.getSource() == Appointment_button) {
            home_form.setVisible(false);
            Appointments_dashbord.setVisible(true);
            doctor_dashboard.setVisible(false);
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


    public void appointmentClearBtn() {
        if (name_patient != null) name_patient.clear();
        if (gender_patient != null) gender_patient.clear();
        if (age_pateint != null) age_pateint.clear();
        if (Doctor_Name != null) Doctor_Name.clear();
        if (doctor_specialaize != null) doctor_specialaize.clear();
        if (date != null) date.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        runTime();
        appointmentClearBtn();

    }
}

