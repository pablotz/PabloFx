/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.task.empleado;

import org.glassware.task.sucursal.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.glassware.model.Empleado;


/**
 *
 * @author LiveGrios
 */
public class TableAdapterEmpleado
{
    public static void adapt(TableView<Empleado> table)
    {
        //Creamos las columnas y establecemos el texto de cabecera 
        //que mostrarán:
        TableColumn<Empleado, String> tcNumEmpleado = new TableColumn<>("No. Empleado");
        TableColumn<Empleado, String> tcNombre = new TableColumn<>("Nombre");
        TableColumn<Empleado, String> tcApellidoP = new TableColumn<>("Apellido Paterno");
        TableColumn<Empleado, String> tcApellidoM = new TableColumn<>("Apellido Materno");
        TableColumn<Empleado, String> tcPuesto = new TableColumn<>("Puesto");
        TableColumn<Empleado, Integer> tcEstatus = new TableColumn<>("Estatus");
        
        //Ahora, le diremos a cada columna como deberá mostrarse y cual será
        //el atributo que mostrará de un objeto de tipo Producto, a través de
        //un CellFactory y un CallBack.
        
        //Para propiedades directas, del objeto podemos utilizar:
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidoP.setCellValueFactory(new PropertyValueFactory<>("numeroEmpleado"));
        tcApellidoM.setCellValueFactory(new PropertyValueFactory<>("longitud"));
        tcPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        tcEstatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        
        table.getColumns().clear();
        table.getColumns().addAll(tcNombre, tcApellidoP,
                                  tcApellidoM, tcPuesto, tcEstatus);
    }
}
