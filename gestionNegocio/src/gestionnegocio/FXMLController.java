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
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class FXMLController implements Initializable {

    //ATRIBUTOS PARA VER LOS DATOS
    @FXML
    private Tab buttonVerDatos;
    @FXML
    private CheckBox verProductos;
    @FXML
    private CheckBox verProveedores;
    @FXML
    private CheckBox verCategorias;
    @FXML
    private TextField buscarNombre;
    @FXML
    private ComboBox<String> buscarProveedor;
    @FXML
    private ComboBox<String> buscarCategoria;

    //ATRIBUTOS PARA AGREGAR LOS DATOS
    @FXML
    private Tab buttonAgregarDatos;
    @FXML
    private ComboBox eleccionAgregar;
    @FXML
    private Button nuevoDato;

    //AÑADIR PRODUCTO
    @FXML
    private Pane paneAgregarProducto;
    @FXML
    private ComboBox<String> addProductoProveedor;
    @FXML
    private ComboBox<String> addProductoCategoria;
    private ObservableList<Proveedor> listaProveedor;
    private ObservableList<Categoria> listaCategoria;
    @FXML
    private Button confirmarAddProducto;
    @FXML
    private Button cancelarAddProducto;
    @FXML
    private TextField codigoNuevoProducto;
    @FXML
    private TextField nombreNuevoProducto;
    @FXML
    private TextField precioSinIvaNuevoProducto;
    @FXML
    private TextField stockNuevoProducto;
    @FXML
    private TextArea descripcionNuevoProducto;
    @FXML
    private TextField marcaNuevoProducto;

    //AÑADIR CATEGORIA
    @FXML
    private Pane paneAgregarCategoria;
    @FXML
    private TextArea nombreNuevaCategoria;
    @FXML
    private Button confirmarAddCategoria;
    @FXML
    private Button cancelarAddCategoria;

    //AÑADIR PROVEEDOR
    @FXML
    private Pane paneAgregarProveedor;
    @FXML
    private TextArea nombreNuevoProveedor;
    @FXML
    private TextArea contactoNuevoProveedor;
    @FXML
    private TextArea direccionNuevoProveedor;
    @FXML
    private Button confirmarAddProveedor;
    @FXML
    private Button cancelarAddProveedor;
    
    
    //MODIFICAR DATOS
    @FXML
    private Pane paneDeleteDato;
    
    

    //VISUALIZAR TABLA
    
    //TABLA PRODUCTOS
    private ObservableList<Producto> productosObservableList;
    private List<Producto> productos;
    ProductoServices ps = new ProductoServices();
    ProveedorService provS = new ProveedorService();
    CategoriaSerice cs = new CategoriaSerice();
    @FXML
    private TableView<Producto> viewTable;
    @FXML
    private TableColumn<Producto, String> productoCodigo;
    @FXML
    private TableColumn<Producto, String> productoNombre;
    @FXML
    private TableColumn<Producto, String> productoMarca;
    @FXML
    private TableColumn<Producto, String> productoDescripcion;
    @FXML
    private TableColumn<Producto, Integer> productoStock;
    @FXML
    private TableColumn<Producto, Double> productoPrecioSinIva;
    @FXML
    private TableColumn<Producto, Double> productoPrecioConIva;
    @FXML
    private TableColumn<Producto,String> productoProveedor;
    //TABLA PROVEEDORES
     private ObservableList<Proveedor> proveedorObservableList;
    private List<Proveedor> proveedores;
    @FXML
    private TableView<Proveedor> viewTableProveedor;
    @FXML
    private TableColumn<Proveedor, String> nombreProveedor;
    @FXML
    private TableColumn<Proveedor, String> direccionProveedor;
    @FXML
    private TableColumn<Proveedor, String> contactoProveedor;
    
    

    //ACTUALIZAR LA TABLA DE DATOS
    public void actualizarTabla() {
        //PONER PROVEEDORES A LA LISTA DE PROVEEDOR Y CATEGORIAS A LA MISMA


        //=====================
        productos = ps.obtenerProductos();
        proveedores = provS.obtenerProvedores();
        productosObservableList = FXCollections.observableArrayList(productos);
        proveedorObservableList = FXCollections.observableArrayList(proveedores);
        viewTable.setItems(productosObservableList);
        viewTableProveedor.setItems(proveedorObservableList);
    }

    //METODOS CONTROLES POR BOTON
    public void verProveedores(ActionEvent event){
        verCategorias.setSelected(false);
        verProductos.setSelected(false);
        if(verProveedores.isSelected()){
            viewTableProveedor.setVisible(true);
        proveedores = provS.obtenerProvedores();
         proveedorObservableList = FXCollections.observableArrayList(proveedores);
         viewTableProveedor.setItems(proveedorObservableList);
         nombreProveedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
         direccionProveedor.setCellValueFactory(new PropertyValueFactory<>("direccion"));
         contactoProveedor.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        }else{
            viewTableProveedor.setVisible(false);
        }
        
    }
    public void verCategorias(ActionEvent event){
        verProveedores.setSelected(false);
        verProductos.setSelected(false);
    }
    public void verProducto(ActionEvent event) {
        viewTable.setVisible(true);
        viewTableProveedor.setVisible(false);
        verCategorias.setSelected(false);
        verProveedores.setSelected(false);
        boolean selected = verProductos.isSelected();
        if (selected) {
            productos = ps.obtenerProductos();
            productosObservableList = FXCollections.observableArrayList(productos);
            viewTable.setItems(productosObservableList);
            productoCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo_producto"));
            productoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            productoMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            productoDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            productoStock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            productoPrecioSinIva.setCellValueFactory(new PropertyValueFactory<>("precio_sin_IVA"));
            productoPrecioConIva.setCellValueFactory(new PropertyValueFactory<>("precio_con_IVA"));
            productoProveedor.setCellValueFactory(new PropertyValueFactory<>("id_proveedor"));
        } else {

        }
    }
    //METODO PARA MOSTAR PROVEEDORE
    //METODO PARA MOSTRAR CATEGORIAS

    private String opcion;
    public void addNewDate(ActionEvent event) {
        opcion = (String) eleccionAgregar.getValue();
        if (opcion.equals("Producto")) {
            paneAgregarProducto.setVisible(true);
            paneAgregarCategoria.setVisible(false);
            paneAgregarProveedor.setVisible(false);
        } else if (opcion.equals("Proveedor")) {
            paneAgregarProveedor.setVisible(true);
            paneAgregarProducto.setVisible(false);
            paneAgregarCategoria.setVisible(false);
        } else if (opcion.equals("Categoria")) {
            paneAgregarCategoria.setVisible(true);
            paneAgregarProducto.setVisible(false);
            paneAgregarProveedor.setVisible(false);
        }
    }
    public void cancelAddProveedor(ActionEvent event) {
        paneAgregarProveedor.setVisible(false);
    }
    public void cancelAddCategoria(ActionEvent event) {
        paneAgregarCategoria.setVisible(false);
    }
    public void cancelAddProducto(ActionEvent event) {
        paneAgregarProducto.setVisible(false);
    }
    public void confirmAddProveedor(ActionEvent event) throws Exception {
        String nombre = nombreNuevoProveedor.getText();
        String contacto = contactoNuevoProveedor.getText();
        String direccion = direccionNuevoProveedor.getText();
        Proveedor proveedor = provS.crearProvedoor(nombre, direccion, contacto);
        actualizarProveedores(proveedor);
        paneAgregarProveedor.setVisible(false);
    }
     public void confirmAddCategoria(ActionEvent event) throws Exception {
        String nombre = nombreNuevaCategoria.getText();
        Categoria categoria = cs.crearCategoria(nombre);
        actualizarCategorias(categoria);
       

        paneAgregarCategoria.setVisible(false);
    }
    public void actualizarCategorias(Categoria categoria){
        mapCategorias.put(categoria.getNombre(), categoria);
        addProductoCategoria.getItems().add(categoria.getNombre());
        buscarCategoria.getItems().add(categoria.getNombre());
    }
    public void actualizarProveedores(Proveedor proveedor){
         mapProveedores.put(proveedor.getNombre(), proveedor);
        addProductoProveedor.getItems().add(proveedor.getNombre());
        buscarProveedor.getItems().add(proveedor.getNombre());
    } 
    public void confirmAddProducto(ActionEvent event) throws Exception {
        String codigo = codigoNuevoProducto.getText();
        String nombre = nombreNuevoProducto.getText();
        String precioSinIVA = precioSinIvaNuevoProducto.getText();
        int stock = Integer.parseInt(stockNuevoProducto.getText());
        double precioSinIva = Double.parseDouble(precioSinIvaNuevoProducto.getText());
        String descripcion = descripcionNuevoProducto.getText();
        String marca = marcaNuevoProducto.getText();
        Proveedor proveedor = mapProveedores.get(addProductoProveedor.getValue());
        Categoria categoria = mapCategorias.get(addProductoCategoria.getValue());
        Producto producto = new Producto();
        ps.crearProducto(codigo, nombre, marca, descripcion, stock, precioSinIva, proveedor, categoria);
        actualizarTabla();
        paneAgregarProducto.setVisible(false);
    }
    
    public void buscarNombre(ActionEvent event){
        ps.consultarNombre(buscarNombre.getText());
        
    }
    //ELIMINAR UN DATO SELECCIONADO EN LA TABLA
    public void deleteDato(ActionEvent event){
        paneDeleteDato.setVisible(true);
        
    }
    public void cancelDelete(ActionEvent event){
        paneDeleteDato.setVisible(false);
    }
    public void acceptDelete(ActionEvent event){
        Producto producDelte = viewTable.getSelectionModel().getSelectedItem();
        ps.borrarProducto(producDelte);
        actualizarTabla();
        paneDeleteDato.setVisible(false);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private Map<String, Categoria> mapCategorias = new HashMap<>();
    private Map<String, Proveedor> mapProveedores = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eleccionAgregar.getItems().add("Producto");
        eleccionAgregar.getItems().add("Proveedor");
        eleccionAgregar.getItems().add("Categoria");
        
        productos = ps.obtenerProductos();
        productosObservableList = FXCollections.observableArrayList(productos);
        viewTable.setItems(productosObservableList);
        productoCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo_producto"));
        productoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        productoMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        productoStock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));   
        productoDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        productoPrecioSinIva.setCellValueFactory(new PropertyValueFactory<>("precio_sin_IVA"));
        productoPrecioConIva.setCellValueFactory(new PropertyValueFactory<>("precio_con_IVA"));
       
        
        //PONER PROVEEDORES A LA LISTA DE PROVEEDOR Y CATEGORIAS A LA MISMA
        //PARA ESTO CREO UN MAP CON LLAVE COMO NOMBRE DEL OBJETO Y VALOR EL OBJETO
        //SETEO EL COMOBOX CON LA LLAVE Y A LA HORA DE BUSCAR BUSCO POR EL VALOR DE ESA LALVE
        

        for (Categoria categoria : cs.obtenerCategorias()) {
            mapCategorias.put(categoria.getNombre(), categoria);
            addProductoCategoria.getItems().add(categoria.getNombre());
        }
        
        for (Proveedor proveedor : provS.obtenerProvedores()) {
            mapProveedores.put(proveedor.getNombre(), proveedor);
            addProductoProveedor.getItems().add(proveedor.getNombre());
        }
        
        //=====================
    }

}
