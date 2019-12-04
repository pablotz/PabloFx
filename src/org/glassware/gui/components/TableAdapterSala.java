/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui.components;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.glassware.model.Sala;
import org.glassware.model.Sucursal;

/**
 *
 * @author LiveGrios
 */
public class TableAdapterSala {

    public static void adapt(TableView<Sala> table) {
        //Creamos las columnas y establecemos el texto de cabecera 
        //que mostrarán:
        TableColumn<Sala, Integer> tcidSala = new TableColumn<>("Id");
        TableColumn<Sala, String> tcNombre = new TableColumn<>("Nombre");
        TableColumn<Sala, String> tcDescripcion = new TableColumn<>("Descripcion");
        TableColumn<Sala, Boolean> tcEstatus = new TableColumn<>("Estatus");
        TableColumn<Sala, Integer> tcSucursal = new TableColumn<>("Sucursal");

        //Ahora, le diremos a cada columna como deberá mostrarse y cual será
        //el atributo que mostrará de un objeto de tipo Producto, a través de
        //un CellFactory y un CallBack.
        //Para propiedades directas, del objeto podemos utilizar:
        tcidSala.setCellValueFactory(new PropertyValueFactory<>("idSala"));
        tcidSala.setVisible(false);
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcEstatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcSucursal.setCellValueFactory(new PropertyValueFactory<>("sucursal"));

        table.getColumns().clear();
        table.getColumns().addAll(tcidSala, tcNombre, tcDescripcion, tcEstatus, tcSucursal);
    }
}
