package Refactorizacion.NumeroTarjeta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Refactorizacion.Tarjeta.TiposTarjeta.TipoTarjeta;

public class ControlNumTarjetas {
    private String noTarjeta;
   
    private  void actualizarArchivo(int numero, TipoTarjeta tipo){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream(tipo.getArchivo(), false));
                    fileOut.writeInt(numero);
                    fileOut.close();
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
    }
    
    public  String leerYAsingarNumeroEnArchivo(TipoTarjeta tipo){
        try{
        DataInputStream fileIn;
            fileIn =
            new DataInputStream(
                    new FileInputStream(tipo.getArchivo()));
                    int numero = (Integer) fileIn.readInt();  //este comando lee el valor que tiene nuestro archivo numeroNacionalCorriente.txt
                    noTarjeta=asingarNumeroTarjeta(tipo.getNumS(),numero); //aca Obtenemos el numero de nuestra siguiente tarjeta a instanciar
                    numero=numero+1;
                    actualizarArchivo(numero,tipo); 
                    fileIn.close(); //Mediante este comando se invoca al metodo actualizarArchivo el cual sobreescribe el siguiente numero.
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
    }

    private String asingarNumeroTarjeta(String base,int valor){
        String numeroDeTarjeta = null;
        if(valor>=1 & valor<10){
            numeroDeTarjeta=base+"000"+valor;
        }
        if(valor>=10& valor<100){
            numeroDeTarjeta=base+"00"+valor;
        }
        if(valor>=100&valor<10000){
            numeroDeTarjeta=base+"0"+valor;
        }
    return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }
}
                 