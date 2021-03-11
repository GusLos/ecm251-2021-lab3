package losada.gustavo;

public class Conta {
    int numero;
    double saldo;
    Cliente cliente;
    
    void visualizarSaldo(){
        //double saldo = 10;
        System.out.println("Saldo da conta: R$" + this.saldo);
    }
    void depositar(double valor){
        //this.saldo = this.saldo + valor;
        this.saldo += saldo;
    };


    boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    };

    boolean transferirPara(double valor, Conta destino) {
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    };

}
