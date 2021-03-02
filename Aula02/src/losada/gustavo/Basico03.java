package losada.gustavo;

import java.util.Random;

public class Basico03 {
    public static void main(String[] args) {
        int limite = 10;
        int contador;
        for(contador = 0; contador < limite; contador++){
            System.out.println("Contagem:" + contador);
        }
        //Quebrador de senha ruim!!!
        int senha = 123456;

        //Gerador de chutes
        Random gerador = new Random();
        int chute = gerador.nextInt(999999);
        System.out.println("Chute:" + chute);
        int tentativas = 0;
        while(chute != senha){
            System.out.println("Tentativa:" + tentativas);
            System.out.println("Chute:" + chute);
            tentativas++;
            chute = gerador.nextInt(999999);
        }
        System.out.println("Você quebrou a senha!");
    }
}
