package losada.gustavo;

import java.util.Random;

public class QRcode {

    //recebe os dados principais e agrupa eles com ;, e adiciona o número aleatório
    public static String gerarQRcode(int id, String nome, String valor){
        return id + ";" + nome + ";" + valor + ";" + getRandomNumberInRange(1000,9999);
    }

    //gera um número aleatório
    private static int getRandomNumberInRange(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    //recebe o código e separa onde estiver ;
    public static String[] lerQRcode(String codigoQR){
        return codigoQR.split(";");
    }
}
