/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebanegocio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author brunopc
 */
public class FXMLDocumentController implements Initializable {
    
    //BOTONES PARA CONTROLAR LA LA VISIBILIDAD DE LOS PANELES
    @FXML
    private Button btnProducto;//ver la tabla producto
    @FXML
    private Button btnCategoria;//ver la tabla categoria
    @FXML
    private Button btnProveedor;//ver la tabla proveedor
    @FXML
    private Button cerrarAddProveedor; //cerrar la pestaña de agregar proveedor
    @FXML
    private Button cerrarAddProducto;//cerrar la pestaña de agregar producto
    @FXML
    private Button cerrarAddCategoria;//cerrar la pestaña de agregar categoria
    @FXML
    private Button addDatos;//ver pestaña de agregar datos
    //============AGREGAR LOS DATOS===============
    @FXML
    private Button addDatosProductos;//añade productos
    @FXML
    private Button addDatosCategorias;//añade categorias
    @FXML
    private Button addDatosProveedor;//añade proveedor
    //==========================================
    @FXML
    private Button verDatos;//Ver pestaña de visualizar datos
    
    
    //PANELES CON VISIBILIDAD CAMBIABLE
    @FXML
    private Pane buttosVisualizacion;//CONTROLADO POR VER DATOS
    @FXML
    private Pane agregarProveedor;//CONTROLADO por addDatosProveedor
    @FXML
    private Pane agregarProducto;//CONTROLADO por addDatosProductos
    @FXML
    private Pane agregarCategoria;//CONTROLADO por addDatosCategorias
    @FXML
    private HBox botonesAgregar;//CONTROLADO por addDatos
    @FXML
    private HBox filtroProductos;//CONTROLADO por verDatos
    @FXML
    private Pane panelVisualizacion;//CONTROLADO por btnProducto,btnCategoria,btnProveedor
    
    
    //VER BOTONES PARA AGREGAR PRODUCTOS
    @FXML
    public void handleAddDatos(ActionEvent event){
        botonesAgregar.setVisible(true);
        filtroProductos.setVisible(false);
        buttosVisualizacion.setVisible(false);
        filtroProductos.setVisible(false);
        
    }
    //VER LOS FILTROS PARA BUSCAR LOS PRODUCTOS
    @FXML
    public void handleVerDatos(ActionEvent event){
        agregarProveedor.setVisible(false);
        agregarCategoria.setVisible(false);
        agregarProducto.setVisible(false);
        botonesAgregar.setVisible(false);
        filtroProductos.setVisible(true);
        buttosVisualizacion.setVisible(true);
    }
    //ABRIR FORMULARIO PARA AGREGAR PRODUCTOS
    @FXML
    public void handleAddDatosProductos(ActionEvent event){
        agregarProveedor.setVisible(false);
        agregarCategoria.setVisible(false);
        agregarProducto.setVisible(true);      
    }
    //ABRIR FORMULARIO PARA AGREGAR PROVEDORES
    @FXML
    public void handleAddDatosProveedor(ActionEvent event){
        agregarProveedor.setVisible(true);
        agregarCategoria.setVisible(false);
        agregarProducto.setVisible(false);      
    }
    //ABRIR FORMULARIO PARA AGREGAR CATEGORIAS
    @FXML
    public void handleAddDatosCategorias(ActionEvent event){
        agregarProveedor.setVisible(false);
        agregarCategoria.setVisible(true);
        agregarProducto.setVisible(false);      
    }
    @FXML
    public void handleCloseProveedor(ActionEvent event){
        agregarProveedor.setVisible(false);
    }
    @FXML
    public void handleCloseProducto(ActionEvent event){
        agregarProducto.setVisible(false);
    }
    @FXML
    public void handleCloseCategoria(ActionEvent event){
        agregarCategoria.setVisible(false);
    }
    
    //VER O AGREGAR DATOS
    
    //VISUALIZAR
    @FXML 
    public void handleProducto(ActionEvent event){
        
    }
     @FXML 
    public void handleProveedor(ActionEvent event){
        
    }
     @FXML 
    public void handleCategoria(ActionEvent event){
        
    }
    
    //AGREGAR PROVEDORES CATEGORIAS O PRODUCTOS
    
    @FXML
    public void handleAddProveedor(ActionEvent event){
        
    }
    @FXML
    public void handleAddProducto(ActionEvent event){
        
    }
    @FXML
    public void handleAddCategoria(ActionEvent event){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
