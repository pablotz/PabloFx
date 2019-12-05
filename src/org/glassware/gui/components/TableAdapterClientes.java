/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui.components;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.glassware.model.Cliente;
import org.glassware.model.Empleado;


/**
 *
 * @author LiveGrios
 */
public class TableAdapterClientes
{
    public static void adapt(TableView<Cliente> table)
    {
        //Creamos las columnas y establecemos el texto de cabecera 
        //que mostrarán:
        TableColumn<Cliente, Integer> tcId = new TableColumn<>("Clave");
        TableColumn<Cliente, String> tcNombre = new TableColumn<>("Nombre");
        TableColumn<Cliente, String> tcApellidoP = new TableColumn<>("Apellido Paterno");
        TableColumn<Cliente, String> tcApellidoM = new TableColumn<>("Apellido Materno");
        TableColumn<Cliente, String> tcGenero = new TableColumn<>("Genero");
        TableColumn<Cliente, String> tcRfc = new TableColumn<>("RFC");
        TableColumn<Cliente, String> tcTelefono = new TableColumn<>("Telefono");
        TableColumn<Cliente, String> tcCorreo = new TableColumn<>("Correo");
        
        //Ahora, le diremos a cada columna como deberá mostrarse y cual será
        //el atributo que mostrará de un objeto de tipo Producto, a través de
        //un CellFactory y un CallBack.
        
        //Para propiedades directas, del objeto podemos utilizar:
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        
        
        //Para propiedades anidadas, debemos utilizar:
        tcNombre.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set( c.getPersona().getNombre());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
            
        tcApellidoP.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>(){
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set( c.getPersona().getApellidoPaterno());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcApellidoM.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set( c.getPersona().getApellidoMaterno());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcGenero.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set(c.getPersona().getGenero());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcRfc.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set(c.getPersona().getRfc());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcTelefono.setCellFactory(new Callback<TableColumn<Cliente, String>, 
                                       TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, 
                                                    String> param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Cliente c = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            c = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set(c.getPersona().getTelefono());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
         table.getColumns().clear();
        
          table.getColumns().addAll(  tcNombre, tcApellidoP, tcApellidoM,
                                    tcGenero, tcRfc,  tcTelefono, 
                                    tcCorreo);
    }
}
