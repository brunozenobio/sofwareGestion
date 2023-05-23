/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.services;

import gestionnegocio.entidades.Categoria;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class CategoriaSerice {
    
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Categoria crearCategoria() throws Exception{
        Categoria categoria = new Categoria();
        categoria.setId(UUID.randomUUID().toString());
        System.out.println("Creando categoria nueva");
        System.out.println("Nombre: ");
        String nombre = read.next();
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar una categoria");
            }
        } catch (Exception e) {{
            throw e;
        }
        }
        //METODO PARA AGREGAR A LA BASE DE DATOS
        return categoria;
        
        
    }
    
    public Categoria buscarPorCategoria(String nombre){
        //BUSCO UNA CATEGORIA EN LA BASE DE DATOS
        return null;
    }
    
}
