package com.example.programacion3_parcial2.ejercicio1.controller;

import com.example.programacion3_parcial2.ejercicio1.model.Observatorio;
import com.example.programacion3_parcial2.ejercicio1.model.Sismo;
import com.example.programacion3_parcial2.ejercicio1.utils.ObservatorioUtil;
import com.example.programacion3_parcial2.ejercicio1.utils.Persistencia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


public class SismosController {

    @FXML
    private TableColumn<Sismo, String> tcCiudad;

    @FXML
    private TableColumn<Sismo, String> tcCodigo;

    @FXML
    private TableColumn<Sismo, String> tcDepartamento;

    @FXML
    private TableColumn<Sismo, String> tcHoraFin;

    @FXML
    private TableColumn<Sismo, String> tcHoraInicio;

    @FXML
    private TableColumn<Sismo, String> tcMagnitud;

    @FXML
    private TableColumn<Sismo, String> tcProfundidad;

    @FXML
    private TableView<Sismo> tvSismos;

    @FXML
    private TextField txtBucarCiudad;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDepartamento;

    @FXML
    private TextField txtHoraFin;

    @FXML
    private TextField txtHoraInicio;

    @FXML
    private TextField txtMagnitud;

    @FXML
    private TextField txtProfundidad;

    public void initialize() throws IOException {

        Observatorio  observatorio = new Observatorio();
        observatorio.getListaSismos().addAll(Persistencia.cargarSismos());
        Persistencia.guardarRecursoBinario(observatorio);
        Persistencia.guardarRecursoSubastaXML(observatorio);
        initData();
    }

    @FXML
    void buscarSismos(ActionEvent event) throws IOException {

        ArrayList<Sismo> listaEncontrados = new ArrayList<>(Persistencia.cargarSismo(txtBucarCiudad.getText()));
        tvSismos.setItems(FXCollections.observableArrayList(listaEncontrados));
        tvSismos.refresh();

    }

    @FXML
    void registrarSismo(ActionEvent event) throws IOException {

        Persistencia.guardarSismos(crearSismo());
        limpiarDatos();

    }

    public Sismo crearSismo() {

        Sismo sismo = new Sismo();

        sismo.setProfundidad(Float.parseFloat(txtProfundidad.getText()));
        sismo.setMagnitud(Float.parseFloat(txtMagnitud.getText()));
        sismo.setHoraFinal(txtHoraFin.getText());
        sismo.setHoraInicio(txtHoraInicio.getText());
        sismo.setCodigo(txtCodigo.getText());
        sismo.setCiudad(txtCiudad.getText());
        sismo.setDepartamento(txtDepartamento.getText());

        return sismo;
    }

    public void limpiarDatos(){

        txtCiudad.setText("");
        txtDepartamento.setText("");
        txtCodigo.setText("");
        txtBucarCiudad.setText("");
        txtMagnitud.setText("");
        txtHoraFin.setText("");
        txtHoraInicio.setText("");
    }

    public void initData(){
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tcDepartamento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartamento()));
        tcCiudad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCiudad()));
        tcHoraFin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHoraFinal()));
        tcHoraInicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHoraInicio()));
        tcMagnitud.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getMagnitud())));
        tcProfundidad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProfundidad())));
    }

}



