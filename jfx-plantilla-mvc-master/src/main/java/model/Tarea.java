/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nicoc
 */
public class Tarea {
    
    private String nombreTarea;
    private String contenidoTarea;
    private String fechaTarea;
    /**
     * Constructor de tarea en vacio
     */
    public Tarea(){
        
    }
    
    
    public Tarea(String nombreTarea,String contenidoTarea,String fechaTarea){
        this.nombreTarea=nombreTarea;
        this.contenidoTarea=contenidoTarea;
        this.fechaTarea=fechaTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getContenidoTarea() {
        return contenidoTarea;
    }

    public String getFechaTarea() {
        return fechaTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setContenidoTarea(String contenidoTarea) {
        this.contenidoTarea = contenidoTarea;
    }

    public void setFechaTarea(String fechaTarea) {
        this.fechaTarea = fechaTarea;
    }
    
    
    
}
