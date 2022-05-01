package Refactorizacion.Reportes;

import Refactorizacion.ControladorDeArchivos;

public abstract class Reporte {
    
    protected String reporteHTML;
    
    ControladorDeArchivos controlador = new ControladorDeArchivos();
    
    public abstract void obtenerDatos();
    public abstract void escribirReporte();
}
