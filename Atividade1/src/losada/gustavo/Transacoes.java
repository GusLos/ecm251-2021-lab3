package losada.gustavo;

public class Transacoes {

    /*  String.intern() -->  aprendi/colei de https://pt.stackoverflow.com/questions/3905/como-comparar-strings-em-java  */

    public static boolean transacaoEfetuada(String nome, String valor, String codigo, Contas conta){
        String[] informacao = QRcode.lerQRcode(codigo);
        if ((informacao[1].intern() == nome.intern()) && (informacao[2].intern() == valor.intern()) && conta.saldoPositivo(valor)){
            //conectar a conta e realizar a transferencia
            Contas contaRecebedor = Contas.conectarConta(informacao[0]);
            return true;
        }else if (!conta.saldoPositivo(valor)){
            System.out.println("Quantia de dineiro indisponivel");
            return false;
        } else {
            System.out.println("Falha na autenticação dos dados, certificar de que os dados solicitados estão corretos");
            return false;
        }
    }


}
