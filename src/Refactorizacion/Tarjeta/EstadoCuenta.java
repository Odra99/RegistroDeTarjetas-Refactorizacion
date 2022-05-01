package Refactorizacion.Tarjeta;

import java.util.ArrayList;
import java.util.List;

import Refactorizacion.ControladorDeArchivos;
import Refactorizacion.OperacionTarjeta.MovimientoR;

public class EstadoCuenta {
    private List<MovimientoR> movimientoRs = new ArrayList<>();
    public String obtenerEstadoCuenta(TarjetaCredito tarjeta) {
        String reporteHTML = "<h3>Consulta de Tarjeta: " + tarjeta.getNumeroDeTarjeta() + "</h3>" +
                "	<table style=\"border-collapse: collapse;\">\n" +
                "	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> NUMERO DE TARJETA: " + tarjeta.getNumeroDeTarjeta() + "</td>\n" +
                "	  </tr>\n" +
                "	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> NOMBRE DEL CLIENTE: " + tarjeta.getNombreDelCliente() + "</td>\n" +
                "	  </tr>\n" +
                "	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> DIRECCION DEL CLIENTE: " + tarjeta.getDireccionDelCliente() + "</td>\n" +
                "	  </tr>\n";

                reporteHTML+= reporteMovimientos(tarjeta.getMovCount(), tarjeta.getNumeroDeTarjeta());

                reporteHTML +="	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> MONTO TOTAL: " + tarjeta.getCredito() + "</td>\n" +
                "	  </tr>\n" +                
                "	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> INTERESES: " + tarjeta.getCredito() + "</td>\n" +
                "	  </tr>\n" +
                "	  <tr>\n" +
                "	    <td colspan=\"5\" style=\"border: 1px solid #000000;\"> INTERESES: " + tarjeta.getSaldoTotal() + "</td>\n" +
                "	  </tr>\n" +
                "	</table>";
        return reporteHTML;
    }

    private String reporteMovimientos(int num, String name){
        obtenerMovimientos(num, name);
        String reporte = "	  <tr>\n" +
        "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> FECHA </td>\n" +
        "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> TIPOMOVIMIENTO </td>\n" +
        "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> DESCRIPCION </td>\n" +
        "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> ESTABLECIMIENTO </td>\n" +
        "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> MONTO </td>\n" +
        "	  </tr>\n" ;  
        for (MovimientoR movimientoR : movimientoRs) {
        reporte+= "	  <tr>\n" +
            "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> " + movimientoR.getFecha() + " </td>\n" +
            "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> " + movimientoR.getTipoDeMovimiento() + " </td>\n" +
            "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> " + movimientoR.getDescripcion() + " </td>\n" +
            "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> " + movimientoR.getEstablecimiento() + " </td>\n" +
            "	    <td colspan=\"1\" style=\"border: 1px solid #000000;\"> " + movimientoR.getMonto() + " </td>\n" +
            "	  </tr>\n" ;  
        }
        return reporte;
    }

    private void obtenerMovimientos(int num, String name){
        ControladorDeArchivos controler = new ControladorDeArchivos();
        for (int i = 0; i < num; i++) {
            String nombre = "Movimiento"+name+(i+1)+".mvito";
            MovimientoR aux = controler.leerMovimiento(nombre);
            if(aux!=null){
                movimientoRs.add(aux);
            }
        }
    }
}
