package losada.gustavo;
import java.util.Scanner;

public class Atividade1 {
    private boolean continuarExecucao;
    private Scanner scanner;
    private QRcode qrCode = new QRcode();
    private Contas c1;// = new Contas(1,1000,"max@uol.com","123","Max");
    private Contas c2;// = new Contas(2,250,"mel@uol.com","321","Mel");
    private Contas c3;// = new Contas(3,3000,"Stla@uol.com","231","Stella");
    private Contas conta;

    public Atividade1(){
        this.continuarExecucao = true;
        this.scanner = new Scanner(System.in);
        c1 = new Contas(1,1000,"max@uol.com","123","Max");
        c2 = new Contas(2,250,"mel@uol.com","321","Mel");
        c3 = new Contas(3,3000,"Stla@uol.com","231","Stella");
        conta = c1;
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
                System.out.println("Digitar o 'QRcode'");
                String codigo = scanner.next();

                break;
            case 2:
                System.out.println("Digite o valor que vai receber: ");
                valorPagamento = scanner.nextDouble();
                // Precisa gravar o código para comparação ?
                System.out.println(QRcode.gerarQRcode(conta.getIdConta(),conta.getNome(),valorPagamento));
                break;
            case 8:
                System.out.println("Saldo: R$"+this.conta.getSaldo());
                break;
            case 9:
                System.out.println("Escolher conta: c(1), c(2) ou c(3)");
                int op = scanner.nextInt();
                if (op == 1){
                    conta = c1;
                    System.out.println("Logando com c1");
                } else if (op == 2){
                    conta = c2;
                    System.out.println("Logando com c2");
                }else {
                    conta = c3;
                    System.out.println("Logando com c3");
                }
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
        System.out.println("8 - Ver saldo");
        System.out.println("9 - Trocar conta");
        System.out.println("0 - Fim");
    }
}
