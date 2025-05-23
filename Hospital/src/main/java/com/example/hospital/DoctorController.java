package com.example.hospital;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class DoctorController implements Initializable{
    @FXML
    private Label Admin_id;

    @FXML
    private Label Appoinmet_appoinment_ID;

    @FXML
    private Label Appointment;

    @FXML
    private Button Appointment_button;

    @FXML
    private Label Appointment_date;

    @FXML
    private Label Appointment_doctors_id;

    @FXML
    private AnchorPane Appointment_id;

    @FXML
    private Label Appointment_patients_id;

    @FXML
    private Label Appointment_time;

    @FXML
    private TableColumn<?, ?> Appointments_appointment_date;

    @FXML
    private TableColumn<?, ?> Appointments_appointment_doctors_id;

    @FXML
    private TableColumn<?, ?> Appointments_appointment_patients_id;

    @FXML
    private TableColumn<?, ?> Appointments_appointment_time;

    @FXML
    private AnchorPane Appointments_dashbord;

    @FXML
    private Label Dashbord_AD;

    @FXML
    private Label Dashbord_TP;

    @FXML
    private TableView<?> Dashbord_Tabelview;

    @FXML
    private Button Dashbord_button;

    @FXML
    private Label Date_doctor;

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
    private Button appointmentClearBTN;

    @FXML
    private TextField appointment_appointment_ID;

    @FXML
    private TextField appointment_date;

    @FXML
    private TextField appointment_doctor_ID;

    @FXML
    private TextField appointment_patient_ID;

    @FXML
    private TextField appointment_time;

    @FXML
    private TableColumn<?, ?> appointments_appointment_id;

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
    private Label feature;

    @FXML
    private TextField patient_age_feild;

    @FXML
    private Button patient_confirm_button;

    @FXML
    private Label patient_gender;

    @FXML
    private ComboBox<String> patient_gender_select;

    @FXML
    private TextField patient_id_feild;

    @FXML
    private TextField patient_mobilenumber_feild;

    @FXML
    private TextField patient_name_field;

    @FXML
    private Button patient_record_button;

    @FXML
    private Label patients_PA_ID;

    @FXML
    private Label patients_PI_Age;

    @FXML
    private Label patients_PI_Gender;

    @FXML
    private Label patients_PI_MobileNumber;

    @FXML
    private Label patients_PI_Name;

    @FXML
    private AnchorPane patients_dasbord;

    @FXML
    private Button patient_add_button;

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

    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == Dashbord_button) {
            dashbord_form.setVisible(true);
            Appointments_dashbord.setVisible(false);
            patients_dasbord.setVisible(false);
        } else if (event.getSource() == Pateint_button) {
            dashbord_form.setVisible(false);
            Appointments_dashbord.setVisible(false);
            patients_dasbord.setVisible(true);
        } else if (event.getSource() == Appointment_button) {
            dashbord_form.setVisible(false);
            Appointments_dashbord.setVisible(true);
            patients_dasbord.setVisible(false);
        }
    }

    public void runTime() {
        new Thread() {
            @Override
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        Date_doctor.setText(format.format(new Date()));
                    });
                }
            }
        }.start();
    }

    public void appointmentClearBTN() {
        appointment_doctor_ID.clear();
        appointment_patient_ID.clear();
        appointment_appointment_ID.clear();
        appointment_time.clear();
        appointment_date.clear();
    }

    public void patientConfirmBtn() {

        // CHECK IF SOME OR ALL FIELDS ARE EMPTY
        if (patient_id_feild.getText().isEmpty()
                || patient_name_field.getText().isEmpty()
                || patient_gender_select.getSelectionModel().getSelectedItem() == null
                || patient_age_feild.getText().isEmpty()
                || patient_mobilenumber_feild.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {

            // TO DISPLAY THE DATA FROM PERSONAL ACCOUNT
            patients_PA_ID.setText(patient_id_feild.getText());

            // TO DISPLAY THE DATA FROM PERSONAL INFORMATION
            patients_PI_Name.setText(patient_name_field.getText());
            patients_PI_Gender.setText(patient_gender_select.getSelectionModel().getSelectedItem());
            patients_PI_Age.setText(patient_age_feild.getText());
            patients_PI_MobileNumber.setText(patient_mobilenumber_feild.getText());
        }

    }



    public void patientRecordBtn() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RecordPageForm.fxml"));
            Stage stage = new Stage();

            stage.setTitle("Hospital Management System | Record of Patients ");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        runTime();
        appointmentClearBTN();
        patient_gender_select.getItems().addAll("Male", "Female");



    }

    }

