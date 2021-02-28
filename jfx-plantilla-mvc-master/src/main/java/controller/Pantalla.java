package controller;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicoc
 */
public class Pantalla implements INavigation {

    private final HashMap<ScreenEnum, Scene> scenes;//hash donde almacenamos las diferentes escenas con una id
    private final Stage stage;//stage

    public Pantalla(Stage stage) {
        this.scenes = new HashMap<>();//inicializamos el hashmap
        this.stage = stage;//metemos a nuestro estage el parametro
    }

    /**
     * Fucnion para añadir escena
     *
     * @param screen la id es un enmum
     * @param scene escena
     */
    public void Add(ScreenEnum screen, Scene scene) {
        this.scenes.put(screen, scene);
    }

    @Override
    /**
     * Funcion donde navegamos por el hash y en caso de que encuentre la clave id nos mostrara su scena
     */
    public void Navigate(ScreenEnum screen) {

        var scene = this.scenes.get(screen);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean esVisible(){
        boolean comprobacion=false;
        
        return comprobacion;
    }
}
 

    
    

