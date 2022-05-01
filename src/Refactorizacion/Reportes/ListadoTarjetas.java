package Refactorizacion.Reportes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Refactorizacion.Tarjeta.TarjetaCredito;

public class ListadoTarjetas extends Reporte {

    List<TarjetaCredito> tarjetas = new ArrayList<>();

    @Override
    public void obtenerDatos() {
        File carpeta = new File(new File(".").getAbsolutePath());
        File[] files = carpeta.listFiles((dir1, name) -> name.endsWith(".tacre"));
        for (File file : files) {
            tarjetas.add(controlador.leerTarjetaDeCredito(file.getPath()));
        }

    }

    @Override
    public void escribirReporte() {
        obtenerDatos();
        reporteHTML = "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
                "	  </tr>";

        for (TarjetaCredito tarjetaCredito : tarjetas) {
            String condicion = tarjetaCredito.isEstaActiva() ? "ACTIVA" : "CANCELADA";
            reporteHTML += "         <tr>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + tarjetaCredito.getNumeroDeTarjeta() + "</th>\n"
                    +
                    "	    <td style=\"border: 1px solid #000000;\">" + tarjetaCredito.getTipo().getNombre()
                    + "</th>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + tarjetaCredito.getTipo().getLimite()
                    + "</th>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + tarjetaCredito.getNombreDelCliente()
                    + "</th>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + tarjetaCredito.getDireccionDelCliente()
                    + "</th>\n" +
                    "           <td style=\"border: 1px solid #000000;\">" + "" + "</th>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + condicion + "</th>\n" +
                    "	  </tr>";
        }
        reporteHTML += "</table>";
        controlador.edicionDeReporteHTML(reporteHTML);

    }

}
