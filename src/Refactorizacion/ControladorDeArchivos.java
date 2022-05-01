/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Refactorizacion;

import Refactorizacion.OperacionTarjeta.MovimientoR;
import Refactorizacion.OperacionTarjeta.SolicitudR;
import Refactorizacion.Tarjeta.TarjetaCredito;

import java.io.*;

/**
 *
 * @author kevin
 */
public class ControladorDeArchivos implements Serializable {
    SolicitudR solicitud;
    MovimientoR movimientoR;
    TarjetaCredito tarjeta;

    /*
     * El siguiente codigo funciona para escribir archivos binarios en el disco duro
     */
    public  void escribirEnArchivo(String nombreDelArchivo, Object objetoAEscribir) {
        ObjectOutputStream fileOut;
        try {
            fileOut = new ObjectOutputStream( // Este comando inizializa un nuevo flujo de salida
                    new FileOutputStream(nombreDelArchivo)); // en otras palabras abre el archivo, como no existe, lo
                                                             // crea.
            fileOut.writeObject(objetoAEscribir); // Escribe el objeto solicitud en el archivo
            fileOut.close(); // Cierra el archivo
        } catch (IOException e) { // Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public  void crearArchivo(String nombre) {
        DataOutputStream fileOut;
        try {
            fileOut = new DataOutputStream( // Este comando inizializa un nuevo flujo de salida
                    new FileOutputStream(nombre)); // en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeInt(1);
            fileOut.close(); // Cierra el archivo
        } catch (IOException e) { // Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public TarjetaCredito leerTarjetaDeCredito(String archivoEntrante) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream(archivoEntrante));
            tarjeta = (TarjetaCredito) fileIn.readObject(); // Al nuevo objeto Solicitud le ponemos la mascara de la
                                                              // solicitud;
            fileIn.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return tarjeta;
    }

    public SolicitudR leerSolicitud(String archivoEntrante) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream(archivoEntrante));
            solicitud = (SolicitudR) fileIn.readObject(); // Al nuevo objeto Solicitud le ponemos la mascara de la
                                                         // solicitud;
            fileIn.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return solicitud;
    }

    public MovimientoR leerMovimiento(String archivoEntrante) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream(archivoEntrante));
            movimientoR = (MovimientoR) fileIn.readObject(); // Al nuevo objeto Solicitud le ponemos la mascara de la
                                                         // solicitud;
            fileIn.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return movimientoR;
    }

    public void edicionDeReporteHTML(String textoEntrante) {
        File archivo = new File("Reportes.html");
        FileOutputStream salida = null;
        try {
            salida = new FileOutputStream(archivo, true);
            salida.write(textoEntrante.getBytes());
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " no se pudo gravar el texto");
        }
    }
}
