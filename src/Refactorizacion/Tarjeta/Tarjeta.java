package Refactorizacion.Tarjeta;

import java.io.Serializable;

public abstract class Tarjeta implements Serializable{
    
    public abstract boolean abonar(double cantidad);
    public abstract boolean cargar(double cantidad);
    public abstract boolean cancelar();
    public abstract String consultar();

}
