/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio;

import gestionnegocio.entidades.Categoria;
import gestionnegocio.entidades.Producto;
import gestionnegocio.entidades.Proveedor;
import gestionnegocio.services.CategoriaSerice;
import gestionnegocio.services.ProductoServices;
import gestionnegocio.services.ProveedorService;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

public class FXMLController implements Initializable {
    ProveedorService ps = new ProveedorService();
    CategoriaSerice cs = new CategoriaSerice();
    ProductoServices proS = new ProductoServices();
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
    //ID DE LOS CAMPOS DONDE LEO LOS DATOS PAR ASETAR LOS OBJETOS
    
    @FXML
    private TextField nombreProveedor;
    @FXML
    private TextField direccionProveedor;
    @FXML
    private TextField contactoProveedor;
    @FXML
    private TextField nombreCategoria;
    @FXML
    private TextField codigoProducto;
    @FXML
    private TextField nombreProducto;
    @FXML 
    private TextField marcaProducto;
    @FXML
    private TextField descripcionProducto;
    @FXML
    private TextField cantidadProducto;
    @FXML
    private TextField precioSinIvaProducto;
    @FXML
    private ComboBox<Proveedor> listProveedor;
    private List<Proveedor> proveedores = new ArrayList<>();
    @FXML
    private ComboBox<Categoria> listCategoria;
    private List<Categoria> categorias = new ArrayList<>();
    
    //BUSCAR 
    @FXML
    private ComboBox<Categoria> buscarCategoria;
    @FXML
    private ComboBox<Proveedor> buscarProveedor;
    @FXML
    private TextField buscarNombre;
    @FXML
    private TextField buscarCodigo;
    
    
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
    public void handleAddProveedor(ActionEvent event) throws Exception{
        String nombre = nombreProveedor.getText();
        String direccion = direccionProveedor.getText();
        String contacto = contactoProveedor.getText();
        Proveedor proveedor = ps.crearProvedoor(nombre, direccion, contacto);
        proveedores.add(proveedor);
        listProveedor.getItems().add(proveedor);
    }
    @FXML
    public void handleAddProducto(ActionEvent event) throws Exception{
        Categoria categoria = listCategoria.getValue();
        Proveedor proveedor = listProveedor.getValue();
        String codigo = codigoProducto.getText();
        String nombre = nombreProducto.getText();
        String marca = marcaProducto.getText();
        int cantidad = Integer.parseInt(cantidadProducto.getText());
        double precioSI = Double.parseDouble(precioSinIvaProducto.getText());
        Producto producto = proS.crearProducto(codigo, nombre, marca, marca, cantidad, precioSI, proveedor, categoria);
        
                
    }
    @FXML
    public void handleAddCategoria(ActionEvent event) throws Exception{
        String nombre = nombreCategoria.getText();
        Categoria categoria = cs.crearCategoria(nombre);
        categorias.add(categoria);
        listCategoria.getItems().add(categoria);
        
    }
    
    
    //FILTRO PARA BUSCAR PRODUCTO
    @FXML
    public void viewCategoria(ActionEvent event){
        Categoria categoria =  buscarCategoria.getValue();
        List<Producto> productos = proS.obtenerProductos(null, categoria.getId());
         
    }
    @FXML
    public void viewProveedor(ActionEvent event){
        Proveedor proveedor =  buscarProveedor.getValue();
        List<Producto> productos = proS.obtenerProductos(proveedor.getId(), null);
        
    }
    
    @FXML
    public void viewNombre(ActionEvent event){
        String nombre = buscarNombre.getText();
        List<Producto> productos = proS.consultarNombre(nombre);
        
    }
    @FXML
    public void viewCodigo(ActionEvent event){
        String codigo = buscarCodigo.getText();
        Producto producto = proS.consultarCodigo(codigo);
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar el StringConverter para mostrar el nombre del proveedor
        proveedores = ps.obtenerProvedores();//VERIFICAR SI ES ASI
        categorias = cs.obtenerCategorias();
    listProveedor.setConverter(new StringConverter<Proveedor>() {
        @Override
        public String toString(Proveedor proveedor) {
            return proveedor.getNombre(); // Ajusta esto según la propiedad que represente el nombre del proveedor
        }

        @Override
        public Proveedor fromString(String string) {
            // Esto no se utilizará en este caso, por lo que se puede dejar sin implementar
            return null;
        }
    });
    listCategoria.setConverter(new StringConverter<Categoria>() {
        @Override
        public String toString(Categoria categoria) {
            return categoria.getNombre(); // Ajusta esto según la propiedad que represente el nombre del proveedor
        }

        @Override
        public Categoria fromString(String string) {
            // Esto no se utilizará en este caso, por lo que se puede dejar sin implementar
            return null;
        }
    });
    }    
    
    
    }    
    
    

