package Refactorizacion.NumeroTarjeta;

import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjeta;

public class AsignadorNumTarjeta {
    String valorActual;
    ControlNumTarjetas controlNumTarjetas = new ControlNumTarjetas();
    public String asignarNumeroDeTarjeta(int limiteDeCredito, TipoTarjeta tipo){
        valorActual=null; //Cada vez que ingrese aca se va a reiniciar el valor que tenia el valorActual.
        if(limiteDeCredito>=tipo.getLimite()){ //se evalua si es del tipo 1 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual=controlNumTarjetas.leerYAsingarNumeroEnArchivo(tipo);
            System.out.println("Solicitud del tipo "+tipo.getNombre()+" aprobada con exito");
        }
        return valorActual;
    }
}
