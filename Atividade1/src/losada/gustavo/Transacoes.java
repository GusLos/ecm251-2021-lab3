package losada.gustavo;

public class Transacoes {
    /*  String.intern() -->  aprendi/colei de https://pt.stackoverflow.com/questions/3905/como-comparar-strings-em-java  */

    public static boolean transacaoEfetuada(String nome, String valor, String codigo, Contas conta){
        String[] informacao = QRcode.lerQRcode(codigo);
        if ((informacao[1].intern() == nome.intern()) && (informacao[2].intern() == valor.intern()) && conta.saldoPositivo(valor)){
            return true;
        }else {
            return false;
        }
    }
}
