/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.glassware.model.Producto;
import org.glassware.gui.components.TableAdapterProducto;
import org.glassware.task.producto.TaskProductoDelete;
import org.glassware.task.producto.TaskProductoSearch;
import org.glassware.task.producto.TaskProductoUpdate;
import org.glassware.task.producto.TaskProductolGetAll;
import org.glassware.task.producto.TaskProductolInsert;

/**
 *
 * @author ximena Uribe
 */
public class PanelProducto {

    @FXML
    AnchorPane rootPane;

    @FXML
    private JFXButton btnCerrarModulo;

    @FXML
    private JFXTextField txtBuscarProducto;

    @FXML
    private JFXButton btnBuscarProducto;

    @FXML
    private JFXTextField txtNombreProducto;

    @FXML
    private JFXTextField txtMarcaProducto;

    @FXML
    private JFXTextField txtPrecio;

    @FXML
    private JFXButton btnModificarProducto;

    @FXML
    private JFXButton btnGuardarProducto;

    @FXML
    private JFXButton btnEliminarProducto;

    @FXML
    private JFXTextField txtIdProducto;

    @FXML
    private TableView<Producto> tblvProductos;

    @FXML
    private JFXTextField txtEstatus;
    
    @FXML
    private JFXButton btnLimpiar;
    
    @FXML
    private Tab tabDetalle;
    
    @FXML
    private Tab tabTabla;
    
    @FXML
    private JFXTabPane allTabPane;
    
    @FXML
    private JFXButton btnRegistrar;

    public JFXButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JFXButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JFXTextField getTxtEstatus() {
        return txtEstatus;
    }

    public TableView<Producto> getTblvProductos() {
        return tblvProductos;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public JFXButton getBtnCerrarModulo() {
        return btnCerrarModulo;
    }

    public JFXTextField getTxtBuscarProducto() {
        return txtBuscarProducto;
    }

    public JFXButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    public JFXTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public JFXTextField getTxtMarcaProducto() {
        return txtMarcaProducto;
    }

    public JFXTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JFXButton getBtnModificarProducto() {
        return btnModificarProducto;
    }

    public JFXButton getBtnGuardarProducto() {
        return btnGuardarProducto;
    }

    public JFXButton getBtnEliminarProducto() {
        return btnEliminarProducto;
    }

    public Node getRoot() {
        return fxmll.getRoot();
    }

    public JFXTextField getTxtIdProducto() {
        return txtIdProducto;
    }

    public Tab getTabDetalle() {
        return tabDetalle;
    }

    public Tab getTabTabla() {
        return tabTabla;
    }

    public JFXTabPane getAllTabPane() {
        return allTabPane;
    }
    
    

    WindowMain app;

    FXMLLoader fxmll;
    TableAdapterProducto tableA = new TableAdapterProducto();

    public PanelProducto(WindowMain app) {
        this.app = app;

    }

    public void consultarProductos() {
        Thread hilo = null;
        TaskProductolGetAll task = new TaskProductolGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    public void buscarProductos() {
        Producto pr = new Producto();
        pr.setNombre(txtBuscarProducto.getText());
        if(pr.getNombre().equals(" ")){
            consultarProductos();
             
        }else{
            Thread hilo = null;
        TaskProductoSearch task = new TaskProductoSearch(app, this, pr);

        hilo = new Thread(task);
        hilo.start();
            
            
        }

       
    }

    public void insertarProducto() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos Incorectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Producto pr = new Producto();
        pr.setNombre(txtNombreProducto.getText());
        pr.setMarca(txtMarcaProducto.getText());
        pr.setPrecioUso(Float.parseFloat(txtPrecio.getText()));

        TaskProductolInsert task2 = new TaskProductolInsert(app, this, pr);
        hilo = new Thread(task2);
        hilo.start();

    }

    public String validarDatos() {
        String error = null;
        if (txtNombreProducto.getText().trim().isEmpty()) {
            error = "Debe de especificar un nombre de producto";
        } else if (txtMarcaProducto.getText().trim().isEmpty()) {
            error = "Debe de especificar la marca del producto";
        } else {
            try {
                Float.valueOf(txtPrecio.getText().trim());
            } catch (Exception e) {
                error = "Captura solo numeros para el precio";
            }
        }
        return error;
    }
    public void seleccionarProducto(){
        tblvProductos.getSelectionModel().selectedItemProperty().addListener(evt -> {
        allTabPane.getSelectionModel().select(tabDetalle);
        mostrarDetalleProducto();
    });
    }
    public void mostrarDetalleProducto() {
        Producto p = tblvProductos.getSelectionModel().getSelectedItem();
        if (p == null) {
            limpiarCampos();
            return;
        } else {
            txtIdProducto.setText("" + p.getIdProducto());
            txtIdProducto.setVisible(false);
            txtNombreProducto.setText("" + p.getNombre());
            txtMarcaProducto.setText("" + p.getMarca());
            txtPrecio.setText("" + p.getPrecioUso());

            if (p.getEstatus() == 1) {
                txtEstatus.setText("Activa");
                txtEstatus.setVisible(false);
            } else {
                txtEstatus.setText("Inactiva");
            }

        }
    }

    public void limpiarCampos() {

        txtNombreProducto.setText("");
        txtMarcaProducto.setText("");
        txtPrecio.setText("");
        txtEstatus.setText("");

    }

    public void updateProducto() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos Incorectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Producto pr = new Producto();
        pr.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
        pr.setNombre(txtNombreProducto.getText());
        pr.setMarca(txtMarcaProducto.getText());
        pr.setPrecioUso(Float.parseFloat(txtPrecio.getText()));

        TaskProductoUpdate task2 = new TaskProductoUpdate(app, this, pr);
        hilo = new Thread(task2);
        hilo.start();

    }

    public void deleteProducto() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos Incorectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Producto pr = new Producto();
        pr.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
        pr.setNombre(txtNombreProducto.getText());
        pr.setMarca(txtMarcaProducto.getText());
        pr.setPrecioUso(Float.parseFloat(txtPrecio.getText()));
        TaskProductoDelete task2 = new TaskProductoDelete(app, this, pr);
        hilo = new Thread(task2);
        hilo.start();

    }
    public void bloquear (){
        txtNombreProducto.setDisable(true);
        txtMarcaProducto.setDisable(true);
        txtPrecio.setDisable(true);
    }
    public void desbloquear(){
         txtNombreProducto.setDisable(false);
        txtMarcaProducto.setDisable(false);
        txtPrecio.setDisable(false);
        
    }

    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_producto.fxml"));
        fxmll.setController(this);
        fxmll.load();
        agregarOyentes();
        seleccionarProducto();
        bloquear();
        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
        consultarProductos();
        tableA.adapt(tblvProductos);

    }

    public void agregarOyentes() {
        tblvProductos.getSelectionModel().selectedItemProperty().addListener(evt -> {
            mostrarDetalleProducto();
        });
        btnGuardarProducto.setOnAction(evt -> {
             updateProducto();
        });
        btnRegistrar.setOnAction(evt -> {
              insertarProducto();});
        
        btnModificarProducto.setOnAction(evt -> {
            desbloquear();
        });
        btnEliminarProducto.setOnAction(evt -> {
            deleteProducto();
        });
        btnBuscarProducto.setOnAction(evt -> {
            buscarProductos();
        });
        btnLimpiar.setOnAction(evt -> {limpiarCampos();});
    }

}
