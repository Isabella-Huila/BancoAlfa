package com.example.seguimiento14;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Label balance;

    @FXML
    private Button botonMostrar;

    @FXML
    private Button registroInicio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        registroInicio.setOnAction(action -> {
            HelloApplication.openWindow("Registro.fxml");
            Stage currentStage = (Stage) registroInicio.getScene().getWindow();
            currentStage.close();
        });

        botonMostrar.setOnAction(action -> {
            HelloApplication.openWindow("TableView.fxml");
            Stage currentStage = (Stage) botonMostrar.getScene().getWindow();
            currentStage.close();
        });


        double balancess = DataRegister.getInstance().calculateBalance(); // se calcula el balnce
        BigDecimal balanceDecimal = BigDecimal.valueOf(balancess);
        BigDecimal balanceFormatted = balanceDecimal.setScale(2, RoundingMode.HALF_UP); // redondeo el balanceo a 2 decimales
        String balanceString = balanceFormatted.toString();
        balance.setText(balanceString);


    }
}