package Refactorizacion.OperacionTarjeta;

import Refactorizacion.NumeroTarjeta.AsignadorNumTarjeta;
import Refactorizacion.Tarjeta.TarjetaCredito;
import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjeta;
import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjetaFactor;

public class AutorizacionR extends Operacion {
    String numeroDeSiguienteTarjeta;
    int salario;
    TipoTarjeta tipo;
    String nombre;
    String direccion;
    boolean estado;
    int limite;
    double credito;    
    AsignadorNumTarjeta asignador = new AsignadorNumTarjeta();
    TipoTarjetaFactor tipoFactor = new TipoTarjetaFactor();

    @Override
    public boolean operar(String line) {
        this.numeroDeSiguienteTarjeta = null;
        obtenerDatos(line);
        if(this.numeroDeSiguienteTarjeta==null){
            System.out.println("No se pudo autorizar su tarjeta, porque no cumple con los requisitos.");
        }else {
            TarjetaCredito tarjeta = new TarjetaCredito(numeroDeSiguienteTarjeta, tipo, nombre,
                    direccion, credito);
            String nombreArchivo = "Tarjeta" + numeroDeSiguienteTarjeta + ".tacre";
            super.guardar(tarjeta, nombreArchivo);
        }
        return false;
    }

    @Override
    public void obtenerDatos(String line) {
        int numeroDeSolicitud;
        SolicitudR solicitudActual = new SolicitudR();        /*
         * Las siguientes lineas sirven para capturar el numero de solicitud
         */
        numeroDeSolicitud = Integer.valueOf(line
                .replaceAll("AUTORIZACION_TARJETA", "")
                .replace("(", "")
                .replace(")", ""));
        // Se crea una variable con el nombre del archivo que contiene a nuestra
        // solicitud
        String nombreDelArchivo = "Solicitud" + numeroDeSolicitud + ".sol";
        // Se instancia un objeto controlador para acceder a un metodo que no es
        // estatico
        // De esta manera se captura el objeto del tipo Solicitud y se asigna a la
        // variable Solicitud Actual
        solicitudActual = controlador.leerSolicitud(nombreDelArchivo);
        if(solicitudActual!=null){
            this.tipo = tipoFactor.obtenerTarjeta(solicitudActual.getTipoDeSolicitud());
            this.salario = solicitudActual.getSalarioDeSolicitud();
            this.limite = (int) (salario * 0.6);
            this.nombre = solicitudActual.getNombreDeSolicitud();
            this.direccion = solicitudActual.getDireccionDeSolicitud();
            this.credito = 0;
            this.estado = true;
            // Se capturan los atributos de nuestra solicitud
            this.numeroDeSiguienteTarjeta = asignador.asignarNumeroDeTarjeta(limite, tipo);
            // Ahora si ya tenemos luz verde vamos a instanciar un objeto TarjetaDeCredito
            // para que ya pueda ser utilizada.
        }else{
            System.out.println("No puede autorizar una solicitud que no exista");
        }
        

    }

}
