package Refactorizacion.Reportes;

public class ReporteFactor {
    

    public Reporte obtnerReporte(String line){
        if(line.startsWith("LISTADO_SOLICITUDES")){
            return new ListadoSolicitudes();
        }
        else if(line.startsWith("LISTADO_TARJETAS")){
           return new ListadoTarjetas();
        }else{
            return null;
        }
    }
}
