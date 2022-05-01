package Refactorizacion.OperacionTarjeta;


public class OperacionFactor {
    
    public Operacion obtenerOperacion(String line){
        if(line.startsWith("SOLICITUD")){
            return new SolicitudR();
        }
        else if(line.startsWith("MOVIMIENTO")){
            return new MovimientoR();
        }
        else if(line.startsWith("AUTORIZACION_TARJETA")){
           return new AutorizacionR();
        }
        else if(line.startsWith("CANCELACION_TARJETA")){
            return new CancelacionR();
        }
        else if(line.startsWith("CONSULTAR_TARJETA")){
            return new ConsultaTarjetaR();
        }
        else if(line.startsWith("ESTADO_CUENTA")){
           return new ObtencionEstadoCuentaR();
        }else{
            return null;
        }
    }
}
