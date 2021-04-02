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
                System.out.println("Digite o nome do recebedor: ");
                String nomeRecebedor = scanner.next();
                System.out.println("Digite o valor que ele vai receber: ");
                double valorPagamento = scanner.nextDouble();
                System.out.println("Código QRcode: ");
                int QRcode = scanner.nextInt();
                String codigoTransacao = "0;"+nomeRecebedor+";"+valorPagamento+";"+QRcode;
                System.out.println(codigoTransacao);
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
