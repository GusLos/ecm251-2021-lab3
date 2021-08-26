package br.maua.estudo_excecao;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio do main");
        metodo1();
        System.out.println("Fim do main");
    }

    //finally - bloco de código que roda tendo ou não acontecido a exceção.

    private static void metodo1(){
        System.out.println("Inicio do metodo1");
        try{
            metodo2();
            String nulo = null;
            nulo.toUpperCase();
        }
        //mostrar que pode ter varios catch, cada um com uma ação.
        catch (NullPointerException exception){
            System.out.println("Faltou algo não?");
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Algo de errado aconteceu!");
        }
        System.out.println("Fim do metodo1");
    }

    /*
    //Primeiro jeito de tratar
    //for n para de rodar, consegue mostrar na tela 10,11,12,13,14,15.
    private static void metodo2(){
        System.out.println("Inicio do metodo2");
        int [] array = new int[10];
        for(int i = 0; i <= 15; i++){
            try{
                array[i] = i;
            }
            catch (ArrayIndexOutOfBoundsException exception){
                //exception.printStackTrace();//mostra o q q teve de erro
                System.out.println("OPA! Fora do limite do vetor.");
            }
            System.out.println(i);
        }
        System.out.println("Fim do metodo2");
    }
    */

    /*
    //Segundo jeito de tratar
    //for é interrompido no momento que exceção acontece
    private static void metodo2(){
        System.out.println("Inicio do metodo2");
        int [] array = new int[10];
        try {
            for (int i = 0; i <= 15; i++) {
                array[i] = i;
                System.out.println(i);
            }
        }
        catch (ArrayIndexOutOfBoundsException exception){
            exception.printStackTrace();//mostra o q q teve de erro
        }
        System.out.println("Fim do metodo2");
    }
     */

    /*
    //Terceiro jeito de tratar
    //tratar exceção na sua chamada
    //try{
    //    metodo2();
    //} [...]
    //Não roda até o final do metodo2, quando a exceção acontecer o metodo2 termina.
    private static void metodo2(){
        System.out.println("Inicio do metodo2");
        int [] array = new int[10];
        for (int i = 0; i <= 15; i++) {
            array[i] = i;
            System.out.println(i);
        }
        System.out.println("Fim do metodo2");
    }
    */

    //Quarto jeito de tratar;
    //Ter um try na chamada do metodo2 e um try dentro do metodo2;
    //Ver que, como tem um try dentro do metodo2, a exceção é tratada dentro do metodo
    //e por isso o metodo2 roda até o final.
    private static void metodo2(){
        System.out.println("Inicio do metodo2");
        int [] array = new int[10];
        try{
            for (int i = 0; i <= 15; i++) {
                array[i] = i;
                System.out.println(i);
            }
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Banana");
        }
        System.out.println("Fim do metodo2");
    }
}
