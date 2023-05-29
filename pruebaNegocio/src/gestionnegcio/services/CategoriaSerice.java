/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegcio.services;

import gestionnegcio.entidades.Categoria;
import gestionnegcio.persistencia.CategoriaDAO;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class CategoriaSerice {
    
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    CategoriaDAO cDAO = new CategoriaDAO();
     //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    
    public Categoria crearCategoria(String nombre) throws Exception{
        Categoria categoria = new Categoria();
        categoria.setId(UUID.randomUUID().toString());
        System.out.println("Creando categoria nueva");

        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar una categoria");
            }
        } catch (Exception e) {
            throw e;
        
        }
        categoria.setNombre(nombre);
        //METODO PARA AGREGAR A LA BASE DE DATOS
        return categoria;
        
        
    }
    //======================================
    //=============CONSULTAS================
    //======================================
    
    public List<Categoria> obtenerCategorias(){
        
        try {
            return cDAO.obtenerCategorias();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Categoria buscarCategoriaPorId(String id){
        
        try {
            
            return  cDAO.buscarPorId(id);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
     //======================================
    //=============MODIFICACIONES================
    //======================================
}
