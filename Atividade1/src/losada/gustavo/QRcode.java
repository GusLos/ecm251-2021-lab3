package losada.gustavo;

import java.util.Random;

public class QRcode {

    public static String gerarQRcode(int id, String nome, String valor){
        return id + ";" + nome + ";" + valor + ";" + getRandomNumberInRange(1000,9999);
    }

    private static int getRandomNumberInRange(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String[] lerQRcode(String codigoQR){
        return codigoQR.split(";");
    }
    /*
    public static boolean qrCodeValido(String nome, String valor, String codigo){

    }*/
}
