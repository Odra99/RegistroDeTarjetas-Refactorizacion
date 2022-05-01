package Refactorizacion.OperacionTarjeta;

import java.io.File;

import Refactorizacion.ControladorDeArchivos;
import Refactorizacion.Tarjeta.EstadoCuenta;
import Refactorizacion.Tarjeta.TarjetaCredito;

public class ObtencionEstadoCuentaR extends Operacion{

    private EstadoCuenta estado = new EstadoCuenta();
    ControladorDeArchivos controlador = new ControladorDeArchivos();
    TarjetaCredito tarjetaCredito;
    @Override
    public boolean operar(String line) {
        obtenerDatos(line);
        return true;
    }

    @Override
    public void obtenerDatos(String line) {
        File carpeta = new File(new File (".").getAbsolutePath ());
        File[] files = carpeta.listFiles((dir1, name) ->
        name.endsWith(".tacre"));
        for (File file : files) {
            tarjetaCredito=controlador.leerTarjetaDeCredito(file.getPath());
            controlador.edicionDeReporteHTML(estado.obtenerEstadoCuenta(tarjetaCredito));
        }
        
    }
    
}
