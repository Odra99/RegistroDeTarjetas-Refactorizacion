package Instrucciones;

import java.io.Serializable;

import Refactorizacion.OperacionTarjeta.Operacion;
import Refactorizacion.OperacionTarjeta.OperacionFactor;
import Refactorizacion.Reportes.Reporte;
import Refactorizacion.Reportes.ReporteFactor;


public class Instruccion implements Serializable {

    private OperacionFactor operacionFactor = new OperacionFactor();
    private ReporteFactor reporteFactor = new ReporteFactor();
    
    public void evaluarLinea(String line){
        Operacion operacion = operacionFactor.obtenerOperacion(line);
        if(operacion!=null){
            operacion.operar(line);
        }else{
            Reporte reporte = reporteFactor.obtnerReporte(line);
            if(reporte!=null){
                reporte.escribirReporte();
            }else{
                System.out.println("Operacion no aceptada");
            }
        }
    }
}
