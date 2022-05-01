package Refactorizacion.Tarjeta.TiposTarjeta;

public class TipoTarjetaFactor {

    public TipoTarjeta obtenerTarjeta(int tipo){
        switch (tipo) {
            case 1:
                return new Nacional();
            case 2:
                return new Regional();
            case 3:
                return new Internacional();
            default:
                return null;
        }
    }
    
}
