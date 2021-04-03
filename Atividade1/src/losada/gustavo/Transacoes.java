package losada.gustavo;

public class Transacoes {

    /*  String.intern() -->  aprendi/colei de https://pt.stackoverflow.com/questions/3905/como-comparar-strings-em-java  */

    //função principal, usa para pagar com um código
    public static boolean transacaoEfetuada(String nome, String valor, String codigo, Contas conta){
        String[] informacao = QRcode.lerQRcode(codigo);//separa o código onde estiver ; gerando um vetor de string
        //usa o vetor de string para certificar de que os dados inseridos estão certos/ iguais ao do código
        if ((informacao[1].intern() == nome.intern()) && (informacao[2].intern() == valor.intern()) && conta.saldoPositivo(valor)){
            //conectar a conta e realizar a transferencia
            Contas contaRecebedor = Contas.conectarConta(informacao[0]);
            contaRecebedor.adicionarValor(informacao[2]);
            return true;
        }else if (!conta.saldoPositivo(valor)){     //verifica se a causa da falha foi a falde de dinheiro
            System.out.println("Quantia de dineiro indisponivel");
            return false;
        } else {        //qualquer outro tipo de falha
            System.out.println("Falha na autenticação dos dados, certificar de que os dados solicitados estão corretos");
            return false;
        }
    }


}
