package Refactorizacion.Tarjeta.TiposTarjeta;

import java.io.Serializable;

public abstract class TipoTarjeta implements Serializable {

    // NACIONAL(1, 2000, "4256-3102-6585-", "numeroNacionalCorriente.txt",1.2),
    // REGIONAL(2, 5000, "4256-3102-6590-", "numeroRegionalCorriente.txt",2.3),
    // INTERNACIONAL(3, 12000, "4256-3102-6595-", "numeroInternacionalCorriente.txt",3.75);

    protected int numero;
    protected int limite;
    protected String numS;
    protected String archivoName;
    protected double interes;
    protected String nombre;


    public int getNum() {
        return numero;
    }

    public int getLimite() {
        return limite;
    }

    public String getNumS() {
        return numS;
    }

    public String getArchivo() {
        return archivoName;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setNumS(String numS) {
        this.numS = numS;
    }

    public void setArchivoName(String archivoName) {
        this.archivoName = archivoName;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    

}
