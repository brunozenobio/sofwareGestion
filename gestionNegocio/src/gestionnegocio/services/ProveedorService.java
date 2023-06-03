/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.services;

import gestionnegocio.entidades.Proveedor;
import gestionnegocio.persistencia.CategoriaDAO;
import gestionnegocio.persistencia.ProveedorDAO;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class ProveedorService {
    ProveedorDAO pDAO = new ProveedorDAO();
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
     //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    public Proveedor crearProvedoor(String nombre,String direccion,String contacto) throws Exception{
        Proveedor proveedor = new Proveedor();
        proveedor.setId(UUID.randomUUID().toString());
        System.out.println("Creando proveedor");
        System.out.print("Nombre: ");
        
        //VERIFICO LOS DATOS
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar un nombre");
            }
            if(direccion == null || direccion.trim().isEmpty()){
                throw new Exception("Debe indicar una direccion");
            }
            if(contacto == null || contacto.trim().isEmpty()){
                throw new Exception("Debe indicar un dato de contacto");
            }
            
        } catch (Exception e) {
            throw e;
        }
        //LLAMO AL METODO PARA AGREGAR A LA BASE DE DATOS
        
        proveedor.setNombre(nombre);
        proveedor.setDireccion(direccion);
        proveedor.setContacto(contacto);
        pDAO.agregarProvedor(proveedor);
        return proveedor;
        
    }
    //======================================
    //=============CONSULTAS================
    //======================================
    public List<Proveedor> obtenerProvedores(){
        try {
            return pDAO.obtenerProveedores();
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Proveedor buscarProveedorPorId(String id){
        try {
            return pDAO.buscarPorId(id);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    //======================================
    //=============MODIFICACIONES================
    //======================================
}
