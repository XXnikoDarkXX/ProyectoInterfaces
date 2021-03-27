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
    
    /**
     * Constructor de Tarea con todos los parametros
     * @param nombreTarea nombre de la tarea
     * @param contenidoTarea contenido de la tarea
     * @param fechaTarea  fecha de la tarea
     */
    public Tarea(String nombreTarea,String contenidoTarea,String fechaTarea){
        this.nombreTarea=nombreTarea;
        this.contenidoTarea=contenidoTarea;
        this.fechaTarea=fechaTarea;
    }
    /**
     * Getter de nombre de la tarea
     * @return  el nombre de la tarea
     */
    public String getNombreTarea() {
        return nombreTarea;
    }
    /**
     * Getter de contenido de tarea
     * @return el contenido de la tarea
     */
    public String getContenidoTarea() {
        return contenidoTarea;
    }
    /**
     * Getter de fecha de Tarea
     * @return la fecha de Tarea
     */
    public String getFechaTarea() {
        return fechaTarea;
    }
    /**
     * Setter de nombre de Tarea
     * @param nombreTarea a cambiar
     */
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
    /**
     * Setter de contenidoTarea
     * @param contenidoTarea a cambiar
     */
    public void setContenidoTarea(String contenidoTarea) {
        this.contenidoTarea = contenidoTarea;
    }
    /**
     * Setter de fechaTarea
     * @param fechaTarea a cambiar
     */
    public void setFechaTarea(String fechaTarea) {
        this.fechaTarea = fechaTarea;
    }
    
    
    
}
