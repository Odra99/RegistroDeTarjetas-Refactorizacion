package Refactorizacion.Reportes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Refactorizacion.OperacionTarjeta.SolicitudR;
import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjeta;
import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjetaFactor;

public class ListadoSolicitudes extends Reporte {
    List<SolicitudR> solicitudes = new ArrayList<>();

    @Override
    public void obtenerDatos() {
        File carpeta = new File(new File(".").getAbsolutePath());
        File[] files = carpeta.listFiles((dir1, name) -> name.endsWith(".sol"));
        for (File file : files) {
            solicitudes.add(controlador.leerSolicitud(file.getPath()));
        }

    }

    @Override
    public void escribirReporte() {
        obtenerDatos();
        reporteHTML = "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
                "	  <tr>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
                "	  </tr>";

        TipoTarjetaFactor factor = new TipoTarjetaFactor();
        for (SolicitudR solicitudR : solicitudes) {
            TipoTarjeta tipo = factor.obtenerTarjeta(solicitudR.getTipoDeSolicitud());
            reporteHTML += "         <tr>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + solicitudR.getNumeroDeSolicitud() + "</td>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + solicitudR.getFechaDeSolicitud() + "</td>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + tipo.getNombre() + "</td>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + solicitudR.getNombreDeSolicitud() + "</td>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + solicitudR.getSalarioDeSolicitud() + "</td>\n"
                    +
                    "	    <td style=\"border: 1px solid #000000;\">" + solicitudR.getDireccionDeSolicitud()
                    + "</td>\n" +
                    "           <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n" +
                    "	    <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n" +
                    "	  </tr>";

        }
        reporteHTML += "</table>";
        controlador.edicionDeReporteHTML(reporteHTML);

    }

}
