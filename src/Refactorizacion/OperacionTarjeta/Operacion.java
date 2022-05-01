package Refactorizacion.OperacionTarjeta;

import java.io.Serializable;

import Refactorizacion.ControladorDeArchivos;


public abstract class Operacion implements Serializable{

    public String nombre;
    public ControladorDeArchivos controlador = new ControladorDeArchivos();

    public  boolean guardar(Object objeto, String nombreArchivo){
        controlador.escribirEnArchivo(nombreArchivo, objeto);
        return true;
    };

    public abstract boolean operar(String line);
    
    public abstract void obtenerDatos(String line);
}
