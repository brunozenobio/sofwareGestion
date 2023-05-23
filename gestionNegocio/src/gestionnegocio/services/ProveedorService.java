/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.services;

import gestionnegocio.entidades.Proveedor;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class ProveedorService {
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    public Proveedor crearProvedoor() throws Exception{
        Proveedor proveedor = new Proveedor();
        proveedor.setId(UUID.randomUUID().toString());
        System.out.println("Creando proveedor");
        System.out.print("Nombre: ");
        String nombre = read.next();
        System.out.print("Diriccion: ");
        String direccion = read.next();
        System.out.println("Contaco: ");
        String contacto = read.next();
        
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
        
        return proveedor;
        
    }
    
    public Proveedor buscarProveedorPorNombre(String nombre){
       // Proveedor proveedor = METODO PARA BUSCAR EN LA BASE DE DATOS
       return null;
    }
}
