package Refactorizacion.OperacionTarjeta;

import java.util.StringTokenizer;

import Refactorizacion.ControladorDeArchivos;
import Refactorizacion.Tarjeta.TarjetaCredito;

public class MovimientoR extends Operacion{

    String numeroDeTarjeta;
    String fecha;
    String tipoDeMovimiento;
    String descripcion;
    String establecimiento;
    double monto;        
    ControladorDeArchivos controlador = new ControladorDeArchivos();
    TarjetaCredito tarjeta;

    @Override
    public boolean operar(String line) {
        obtenerDatos(line);
        if(tarjeta!=null){
            if(tarjeta.ejecutarMovimiento(tipoDeMovimiento, monto)){
                ControladorDeArchivos.escribirEnArchivo("Tarjeta"+numeroDeTarjeta+".tacre", tarjeta);     //Actualizacion del objeto en el archivo
                String nombreArchivo="Movimiento"+numeroDeTarjeta+tarjeta.getMovCount()+".mvito";                
                super.guardar(this, nombreArchivo);
                return true;
            }else{
                System.out.println("Movimiento no aceptado");
                return false;
            }                   
        }else{
            System.out.println("La tarjeta no existe");
            return false;
        }
    }

    @Override
    public void obtenerDatos(String line) {
        StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp=token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token que en este caso es Movimiento(
        this.numeroDeTarjeta=temp.replaceAll("MOVIMIENTO", "");//Luego aca se le se quita la palabra movimiento a la variable numero de tarjeta y se convierte a entero
        this.fecha=token.nextToken().replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha 
        this.tipoDeMovimiento=(token.nextToken().replace("\"", ""));
        this.descripcion=(token.nextToken().replace("\"", ""));
        this.establecimiento=(token.nextToken().replace("\"", ""));
        this.monto=Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
        this.tarjeta=controlador.leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");        
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ControladorDeArchivos getControlador() {
        return controlador;
    }

    public void setControlador(ControladorDeArchivos controlador) {
        this.controlador = controlador;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
}
