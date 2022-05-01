package Refactorizacion.Tarjeta;

import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjeta;

public class TarjetaCredito extends Tarjeta {

    private String NumeroDeTarjeta;
    private TipoTarjeta tipo;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    private int movCount;

    public TarjetaCredito(String NumeroDeTarjeta, TipoTarjeta tipo, String nombreDelCliente,
            String direccionDelCliente, double credito) {
        this.NumeroDeTarjeta = NumeroDeTarjeta;
        this.tipo = tipo;
        this.nombreDelCliente = nombreDelCliente;
        this.direccionDelCliente = direccionDelCliente;
        this.credito = credito;
        this.estaActiva = true;
        this.movCount = 0;
    }

    @Override
    public boolean abonar(double cantidad) {        
        this.movCount +=1;
        this.credito = this.credito - cantidad;
        return false;
    }

    @Override
    public boolean cargar(double cantidad) {
        if(tipo.getLimite()>=this.credito+cantidad){
            this.movCount +=1;
            this.credito = this.credito + cantidad;
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public boolean cancelar() {
        this.estaActiva = this.credito > 0;
        return !this.estaActiva;
    }

    public boolean ejecutarMovimiento(String tipo, double monto) {
        switch (tipo) {
            case "CARGO":
                return cargar(monto);
            case "ABONO":                
                return abonar(monto);
        
            default:
                return false;
        }
    }

    public double getIntereses(){
        return this.credito*tipo.getInteres();
    }

    public double getSaldoTotal(){
        return this.credito*tipo.getInteres()+this.credito;
    }

    @Override
    public String consultar() {
        String activa = this.estaActiva ? "Activa" : "Inactiva";
        String reporteHTML = "<h3>Consulta de Tarjeta: " + this.NumeroDeTarjeta + "</h3>" +
                "	<table style=\"border-collapse: collapse;\">\n" +
                "	  <tr>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
                "	  </tr>\n" +
                "	  <tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + this.NumeroDeTarjeta + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + this.tipo.getNombre() + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + this.tipo.getLimite() + ".00" + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + this.nombreDelCliente + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + this.direccionDelCliente + "</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">" + activa + "</td>\n" +
                "	  </tr>\n" +
                "	</table>";
        return reporteHTML;
    }

    

    public String getNumeroDeTarjeta() {
        return NumeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        NumeroDeTarjeta = numeroDeTarjeta;
    }

    public TipoTarjeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getDireccionDelCliente() {
        return direccionDelCliente;
    }

    public void setDireccionDelCliente(String direccionDelCliente) {
        this.direccionDelCliente = direccionDelCliente;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public int getMovCount() {
        return movCount;
    }

    public void setMovCount(int movCount) {
        this.movCount = movCount;
    }

    

    
}
