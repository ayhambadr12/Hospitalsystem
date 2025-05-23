package com.example.hospital;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;


public class RecordController implements Initializable {

    @FXML
    private TableColumn<?, ?> recordpage_col_address;

    @FXML
    private TableColumn<?, ?> recordpage_col_gender;

    @FXML
    private TableColumn<?, ?> recordpage_col_mobileNumber;

    @FXML
    private TableColumn<?, ?> recordpage_col_name;

    @FXML
    private TableColumn<?, ?> recordpage_col_patientID;

    @FXML
    private AnchorPane recordpage_mainForm;

    @FXML
    private TextField recordpage_search;

    @FXML
    private TableView<?> recordpage_tableView;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
