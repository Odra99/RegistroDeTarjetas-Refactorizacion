package Refactorizacion.OperacionTarjeta;


import java.util.StringTokenizer;


public class SolicitudR extends Operacion {

    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;

    @Override
    public void obtenerDatos(String line) {
        StringTokenizer token = new StringTokenizer(line, ","); // se define un nuevo objeto StringTokenizer con la                                                            // cadena line y el delmitador ","
        String temp; // la variable temp sirve para almacenar datos y poder operar con ellos antes de    // ingresarlos a sus datos fijos
        temp = token.nextToken().replace("(", ""); // aca se le quita el parentesis al primer token
        numeroDeSolicitud = Integer.parseInt(temp.replaceAll("SOLICITUD", ""));// Luego aca se le se quita la palabra
                                                                               // solicitud a la variable numero de
                                                                               // solicitud y se convierte a entero
        temp = token.nextToken(); // este token es de la fecha de la solicitud
        this.fecha = temp.replaceAll("\"", ""); // mediante esta instruccion se quitan las comillas a la fecha
        this.tipo = Integer.valueOf(token.nextToken().replace("\"", ""));
        this.nombre = String.valueOf(token.nextToken().replaceAll("\"", ""));
        this.salario = Integer.valueOf(token.nextToken());
        this.direccion = token.nextToken().replaceAll("\"", "").replace(")", "");
    }
    @Override
    public boolean operar(String line) {
        obtenerDatos(line);
        String nombreArchivo = "Solicitud"+String.valueOf(this.numeroDeSolicitud)+".sol";
        super.guardar(this, nombreArchivo);
        return false;
    }

    public int getNumeroDeSolicitud(){
        return this.numeroDeSolicitud;
    }
    public String getFechaDeSolicitud(){
        return this.fecha;
    }
    public int getTipoDeSolicitud(){
        return this.tipo;
    }
    public String getNombreDeSolicitud(){
        return this.nombre;
    }
    public int getSalarioDeSolicitud(){
        return this.salario;
    }
    public String getDireccionDeSolicitud(){
        return this.direccion;
    }
    
  


}
