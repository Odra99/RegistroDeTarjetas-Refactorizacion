package Refactorizacion.Tarjeta.TiposTarjeta;

public class Internacional extends TipoTarjeta{
    public Internacional(){
        super.archivoName = "numeroInternacionalCorriente.txt";
        super.interes = 3.75;
        super.limite=12000;
        super.numS="4256-3102-6595-";
        super.numero=3;
        super.nombre="INTERNACIONAL";
    }
    
}
