package Refactorizacion.OperacionTarjeta;

import Refactorizacion.Tarjeta.TarjetaCredito;

public class CancelacionR extends Operacion {

    TarjetaCredito tarjeta;

    @Override
    public boolean operar(String line) {
        obtenerDatos(line);
        if (tarjeta != null) {
            if (tarjeta.cancelar()) {
                System.out.println("Cancelacion exitosa");
                return true;
            } else {
                System.out.println("No se pudo cancelar, saldo pendiente");
                return false;
            }
        }else{
            System.out.println("Tarjeta no existe");
            return false;
        }
    }

    @Override
    public void obtenerDatos(String line) {
        String numeroDeTarjeta = line
                .replaceAll("CANCELACION_TARJETA", "")
                .replace("(", "")
                .replace(")", "");
        String nombreDelArchivo = "Tarjeta" + numeroDeTarjeta + ".tacre";
        tarjeta = controlador.leerTarjetaDeCredito(nombreDelArchivo);

    }

}
