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
import org.glassware.model.Sucursal;

/**
 *
 * @author LiveGrios
 */
public class TableAdapterSucursal
{
    public static void adapt(TableView<Sucursal> table)
    {
        //Creamos las columnas y establecemos el texto de cabecera 
        //que mostrarán:
        TableColumn<Sucursal, String> tcidSucursal = new TableColumn<>("id");
        TableColumn<Sucursal, String> tcNombre = new TableColumn<>("Nombre");
        TableColumn<Sucursal, String> tcDomicilio = new TableColumn<>("Domicilio");
        TableColumn<Sucursal, Double> tcLongitud = new TableColumn<>("Longitud");
        TableColumn<Sucursal, Double> tcLatitud = new TableColumn<>("Latitud");
        TableColumn<Sucursal, Integer> tcStatus = new TableColumn<>("Estatus");
        
        //Ahora, le diremos a cada columna como deberá mostrarse y cual será
        //el atributo que mostrará de un objeto de tipo Producto, a través de
        //un CellFactory y un CallBack.
        
        //Para propiedades directas, del objeto podemos utilizar:
        tcidSucursal.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        tcLongitud.setCellValueFactory(new PropertyValueFactory<>("longitud"));
        tcLatitud.setCellValueFactory(new PropertyValueFactory<>("latitud"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        
        table.getColumns().addAll(tcidSucursal, tcNombre, tcDomicilio,
                                  tcLongitud, tcLatitud, tcStatus);
    }
}
