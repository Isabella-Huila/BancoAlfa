package com.example.seguimiento14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button añadirBtt;

    @FXML
    private TextField descriptionT;

    @FXML
    private DatePicker fechaDP;

    @FXML
    private TextField montoT;

    @FXML
    private ComboBox<String> tipoCBOX;

    @FXML
    private Button volverAlInicio;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tipoCBOX.setPromptText("Selection an option");
        ObservableList<String> items = FXCollections.observableArrayList("INCOME", "EXPENSE");
        tipoCBOX.setItems(items);

        añadirBtt.setOnAction(action -> {
            String descripcion = descriptionT.getText();
            Type tipo = tipoCBOX.getSelectionModel().isSelected(0) ? Type.INCOME : Type.EXPENSE;
            double mont = Double.parseDouble(montoT.getText());
            LocalDate fechaSeleccionada = fechaDP.getValue();
            Instant instant = fechaSeleccionada.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Date fecha = Date.from(instant);
            Dato dato = new Dato(descripcion, mont, tipo, fecha);
            DataRegister.getInstance().getDatos().add(dato);
            Stage stage = (Stage) añadirBtt.getScene().getWindow();
            stage.close();
            HelloApplication.openWindow("hello-view.fxml");
        });

        volverAlInicio.setOnAction(Action->{
            HelloApplication.openWindow("hello-view.fxml");
            Stage stage= (Stage) volverAlInicio.getScene().getWindow();
            stage.close();
        });

    }
}

