package com.example.seguimiento14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.List;

public class TableController  implements Initializable {
    @FXML
    private TableColumn<Dato, String> ColumnaDescription;

    @FXML
    private TableColumn<Date, Date> ColumnaFecha;

    @FXML
    private TableColumn<Dato, Double> ColumnaMonto;

    @FXML
    private TableColumn<Dato, Type> ColumnaTipo;

    @FXML
    private TableView<Dato> DatosT;

    @FXML
    private Button GatosBtt;

    @FXML
    private Button IngresosBtt;

    @FXML
    private Button ambosBtt;

    @FXML
    private Button iniciobtt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ColumnaDescription.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        ColumnaFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
        ColumnaMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        ColumnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        List<Dato> datos = DataRegister.getInstance().getDatos();

        ObservableList<Dato> incomes = FXCollections.observableArrayList();
        ObservableList<Dato> expenses = FXCollections.observableArrayList();
        ObservableList<Dato> inYex = FXCollections.observableArrayList(datos);

        for (Dato dato : datos) {
            if (dato.getTipo().equals(Type.INCOME)) {
                incomes.add(dato);
            } else if (dato.getTipo().equals(Type.EXPENSE)) {
                expenses.add(dato);
            }
        }
        IngresosBtt.setOnAction(action -> DatosT.setItems(incomes));
        GatosBtt.setOnAction(action -> DatosT.setItems(expenses));
        ambosBtt.setOnAction(action -> DatosT.setItems(inYex));

        iniciobtt.setOnAction(action -> {
            HelloApplication.openWindow("hello-view.fxml");
            Stage stage = (Stage) iniciobtt.getScene().getWindow();
            stage.close();
        });
    }
}
