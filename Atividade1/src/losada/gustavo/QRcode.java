package losada.gustavo;

import java.util.Random;

public class QRcode {

    public String gerarQRcode(int id, String nome, double valor){
        return id + ";" + nome + ";" + valor + ";" + getRandomNumberInRange(1000,9999);
    }

    private static int getRandomNumberInRange(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
