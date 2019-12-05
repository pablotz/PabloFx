/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui.components;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.glassware.model.Empleado;


/**
 *  Esta clase contiene los métodos necesarios para definir y configurar
 *  las columnas que contendrán las tablas 
 *  (objetos de tipo <code>TableView</code>) que desplegarán datos de los 
 *  empleados (objetos de tipo {@link org.utl.myspa.model.Empleado}.
 * 
 *  @author LiveGrios
 */
public class TableAdapterEmpleado
{
    /**
     * En este método creamos y configuramos las columnas que tendrá la 
     * tabla que mostrará datos de empleados (objetos de tipo
     * {@link org.utl.myspa.model.Empleado}.
     * @param table 
     */
    public static void adapt(TableView<Empleado> table)
    {
        //Creamos las columnas y establecemos el texto de cabecera que mostraran:
        TableColumn<Empleado, String> tcNombre = new TableColumn<>("Nombre");
        TableColumn<Empleado, String> tcApellidoPaterno = new TableColumn<>("Apellido Paterno");
        TableColumn<Empleado, String> tcApellidoMaterno = new TableColumn<>("Apellido Materno");
        TableColumn<Empleado, String> tcGenero = new TableColumn<>("Genero");
        TableColumn<Empleado, String> tcRFC = new TableColumn<>("RFC");
        TableColumn<Empleado, String> tcDomicilio = new TableColumn<>("Domicilio");
        TableColumn<Empleado, String> tcTelefono = new TableColumn<>("Telefono");
        TableColumn<Empleado, String> tcNumeroEmpleado = new TableColumn<>("NumeroEmpleado");
        TableColumn<Empleado, String> tcPuesto = new TableColumn<>("Puesto");
        TableColumn<Empleado, String> tcNombreUsuario = new TableColumn<>("Nombre de Usuario");
        TableColumn<Empleado, String> tcRol = new TableColumn<>("Rol");
        
        //Para propiedades directas, del objeto podemos utilizar:
        tcNumeroEmpleado.setCellValueFactory(new PropertyValueFactory<Empleado, String>("numeroEmpleado"));
        tcPuesto.setCellValueFactory(new PropertyValueFactory<Empleado, String>("puesto"));
        
        //Para propiedades anidadas, debemos utilizar:
        tcNombre.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set(e.getPersona().getNombre());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcApellidoPaterno.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getApellidoPaterno());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcApellidoMaterno.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getApellidoMaterno());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcGenero.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getGenero());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcRFC.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getRfc());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcDomicilio.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getDomicilio());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcTelefono.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getPersona().getTelefono());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcNombreUsuario.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getUsuario().getNombreUsuario());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        tcRol.setCellFactory(new Callback<TableColumn<Empleado, String>, 
                                       TableCell<Empleado, String>>()
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, 
                                                    String> param)
            {
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        //Pedimos el indice del elemento que quiere mostrar
                        //el TableView:
                        int indice = getIndex();
                        
                        Empleado e = null;
                        
                        //Inicializamos la celda con el valor que nos pasa el
                        //TableView:
                        super.updateItem(item, empty);
                        
                        //Preguntamos si el indice (posicion) del objeto
                        //está dentro del tamaño de la lista:
                        if (indice >= 0 && indice < table.getItems().size())
                        {
                            //Obtenemos el empleado de la posición requerida:
                            e = table.getItems().get(indice);
                            
                            //Establecemos el valor de la celda:
                            textProperty().set("" + e.getUsuario().getRol());                            
                        }
                        else
                            setText(null);
                    }
                };
            }
        });
        
        //Una vez configuradas las columnas, las pondremos en la tabla,
        //pero antes, quítaremos cualquier columna que pudiera tener:
        table.getColumns().clear();
        
        //Agregamos las columnas a la tabla, en el orden 
        //que deseamos que aparezcan:
        table.getColumns().addAll(  tcNombre, tcApellidoPaterno, tcApellidoMaterno,
                                    tcGenero, tcRFC, tcDomicilio, tcTelefono, 
                                    tcNumeroEmpleado, tcPuesto, tcNombreUsuario,
                                    tcRol);
    }
}
