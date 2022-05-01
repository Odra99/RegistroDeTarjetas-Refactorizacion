package Refactorizacion.OperacionTarjeta;

import Refactorizacion.Tarjeta.TarjetaCredito;

public class ConsultaTarjetaR extends Operacion{
    TarjetaCredito tarjeta;

    @Override
    public boolean operar(String line) {
        obtenerDatos(line);
        if(tarjeta!=null){            
            controlador.edicionDeReporteHTML(tarjeta.consultar());
            return true;
        }else{
            System.out.println("Tarjeta no existe");
            return false;
        }
        
    }

    @Override
    public void obtenerDatos(String line) {
        String numeroDeTarjeta=line
                .replaceAll("CONSULTAR_TARJETA","")
                .replace("(","")
                .replace(")","");
        
        tarjeta=controlador.leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");        
    }
    
}
