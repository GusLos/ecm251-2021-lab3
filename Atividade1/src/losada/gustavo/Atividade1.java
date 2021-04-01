package losada.gustavo;
import java.util.Scanner;

public class Atividade1 {
    private boolean continuarExecucao;
    private Scanner scanner;

    public Atividade1(){
        this.continuarExecucao = true;
        this.scanner = new Scanner(System.in);
    }

    public void executar(){
        while(continuarExecucao) {
            exibirMenu();
            int opcao = scanner.nextInt();
            avaliarOpcao(opcao);
        }
    }

    private void avaliarOpcao (int opcao){
        switch (opcao){
            case 0:
                this.continuarExecucao = false;
                break;
            case 1:
                System.out.println("Função não implementada");
                break;
            case 2:
                System.out.println("Função não implementada");
                break;
            default :
                System.out.println("Opção invalida");
                break;
        }
    }

    private void exibirMenu(){
        System.out.println("Menu:");
        System.out.println("1 - Pagar");
        System.out.println("2 - Receber");
        System.out.println("0 - Fim");
    }
}
