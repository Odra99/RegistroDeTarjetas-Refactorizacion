package Refactorizacion.OperacionTarjeta;

import java.io.Serializable;

import Refactorizacion.ControladorDeArchivos;


public abstract class Operacion implements Serializable{

    public String nombre;

    public  boolean guardar(Object objeto, String nombreArchivo){
        ControladorDeArchivos.escribirEnArchivo(nombreArchivo, objeto);
        return true;
    };

    public abstract boolean operar(String line);
    
    public abstract void obtenerDatos(String line);
}
