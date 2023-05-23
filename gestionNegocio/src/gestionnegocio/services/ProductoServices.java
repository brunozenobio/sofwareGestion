/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.services;

import gestionnegocio.entidades.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class ProductoServices {

    private Scanner read = new Scanner(System.in).useDelimiter("\n");

    public Producto crearProducto(Proveedor prov, Categoria cat) throws Exception {
        Producto producto = new Producto();
        producto.setId(UUID.randomUUID().toString());
        producto.setId_categoria(cat);
        producto.setId_proveedor(prov);
        System.out.println("Creando producto: ");
        System.out.print("Codigo del producto: ");
        String codigo = read.next();
        System.out.print("Nombre: ");
        String nombre = read.next();
        System.out.print("Marca: ");
        String marca = read.next();
        System.out.print("Descripcion: ");
        String descripcion = read.next();
        System.out.print("Cantidad: ");
        int cantidad = read.nextInt();
        System.out.println("Precio sin IVA");
        double precioSinIva = read.nextDouble();
        double precioConIva = precioSinIva * 0.21;
        try {
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe indicar el codigo del producto");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (marca == null || marca.trim().isEmpty()) {
                throw new Exception("Debe indicar una marca");
            }
            if (cantidad < 0) {
                throw new Exception("Debe ingresar una cantidad correcta");
            }
            if (precioSinIva <= 0) {
                throw new Exception("Debe indicar el precio de lista");
            }

        } catch (Exception e) {
            throw e;
        }

        producto.setCodigo_producto(codigo);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setPrecio_sin_IVA(precioSinIva);
        producto.setPrecio_con_IVA(precioConIva);

        //METODO PARA AGREGAR EL PRODUCTO
        return producto;
    }

    public ArrayList<Producto> buscarProductos(String nombre, String marca, String codigo, String nombreProv) {
        //METODO PARA BUSCAR
        

        return null;

    }

}
