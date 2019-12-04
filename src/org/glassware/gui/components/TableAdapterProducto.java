package org.glassware.gui.components;

import org.glassware.task.producto.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.glassware.model.Producto;

/**
 *
 * @author LiveGrios
 */
public class TableAdapterProducto {

    public static void adapt(TableView<Producto> table) {
        //Creamos las columnas y establecemos el texto de cabecera 
        //que mostrarán:
        TableColumn<Producto, Integer> tcidProducto = new TableColumn<>("Id");
        TableColumn<Producto, String> tcNombre = new TableColumn<>("nombre");
        TableColumn<Producto, Double> tcMarca = new TableColumn<>("marca");
        TableColumn<Producto, Double> tcPrecio = new TableColumn<>("precio");

        //Ahora, le diremos a cada columna como deberá mostrarse y cual será
        //el atributo que mostrará de un objeto de tipo Producto, a través de
        //un CellFactory y un CallBack.
        //Para propiedades directas, del objeto podemos utilizar:
        tcidProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        tcidProducto.setVisible(false);
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precioUso"));

        table.getColumns().clear();
        table.getColumns().addAll(tcidProducto, tcNombre, tcMarca,
                tcPrecio);
    }
}
