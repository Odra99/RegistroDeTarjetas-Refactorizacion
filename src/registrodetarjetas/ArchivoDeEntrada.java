package registrodetarjetas;

import Instrucciones.Instruccion;
import Refactorizacion.ControladorDeArchivos;

import java.util.Scanner;
import java.io.*;

public class ArchivoDeEntrada implements Serializable{
    
    Disenio actualizarInstrucciones = new Disenio();
    ControladorDeArchivos controlador = new ControladorDeArchivos();
/*
    Este procedimiento sirve para leer el archivo de entrada 
    que contiene todas las instrucciones a ingresar al sistema.
    */
protected void asignarArchivo(String path){ 
Scanner archivoDeEntrada;
String line = null;
Instruccion instruccion = new Instruccion();
try{
   archivoDeEntrada = new Scanner(new FileReader(path));
   controlador.crearArchivo("numeroNacionalCorriente.txt");
   controlador.crearArchivo("numeroRegionalCorriente.txt");
   controlador.crearArchivo("numeroInternacionalCorriente.txt");
   
   while (archivoDeEntrada.hasNextLine()){
       line = archivoDeEntrada.nextLine();
       System.out.println(line);
       actualizarInstrucciones.setAreaInstrucciones(String.valueOf(line)); //Las lineas que se van leyendo se almacenan en line
       instruccion.evaluarLinea(line);
   }
   archivoDeEntrada.close(); //luego de haber abierto el archivo de entrada tambien hay que cerrarlo para 
   //que se liberen desbloquerlo y que se liberen recursos. 
}
catch (FileNotFoundException e){ // si el archivo no existe captura la excepcion y lanza un mensaje
   System.out.println("Error: " + e.getMessage());
} 
}//cerramos el procedimiento asignarArchivo
}//cerramos la clase ArchivoDeEntrada. 
