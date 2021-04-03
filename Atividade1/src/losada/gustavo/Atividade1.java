/*
Gustavo Lourenço Losada
19.00345-5
 */

package losada.gustavo;
import java.util.Scanner;

public class Atividade1 {
    private boolean continuarExecucao;
    private final Scanner scanner;
    //c1(1,1000,"max@uol.com","123","Max");
    //c2(2,250,"mel@uol.com","321","Mel");
    //c3(3,3000,"Stla@uol.com","231","Stella");
    private Contas conta;

    public Atividade1(){
        this.continuarExecucao = true;
        this.scanner = new Scanner(System.in);
    }

    public void executar(){
        this.conta = Contas.login();
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
                System.out.println("Saldo: R$"+this.conta.getSaldo());
                break;
            case 2:
                System.out.println("Digite valor para sacar");
                String valorSacar = scanner.next();
                if(conta.saldoPositivo(valorSacar)){
                    System.out.println("Operação realizada com sucesso");
                }else{
                    System.out.println("Falha na operação");
                }
                break;
            case 3:
                System.out.println("Valor para depositar:");
                String valorAdicionar = scanner.next();
                this.conta.adicionarValor(valorAdicionar);
                break;
            case 4:
                System.out.println("Digite o nome do recebedor: ");
                String nomeRecebedor = scanner.next();
                System.out.println("Digite o valor que ele vai receber: ");
                String valorPagamento = scanner.next();
                System.out.println("Digitar o 'QRcode'");
                String codigo = scanner.next();
                if(Transacoes.transacaoEfetuada(nomeRecebedor,valorPagamento,codigo,conta)){
                    System.out.println("Operração realizada com sucesso");
                }else{
                    System.out.println("Falha na operação");
                }
                break;
            case 5:
                System.out.println("Digite o valor que vai receber: ");
                valorPagamento = scanner.next();
                System.out.println(QRcode.gerarQRcode(conta.getIdConta(),conta.usuario.getNome(),valorPagamento));
                break;
            case 9:
                this.conta = Contas.login();
                break;
            default :
                System.out.println("Opção invalida");
                break;
        }
    }

    private void exibirMenu(){
        System.out.println("Menu:");
        System.out.println("0 - Fim");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Pagar");
        System.out.println("5 - Receber");
        System.out.println("9 - Trocar conta");//
    }
}
