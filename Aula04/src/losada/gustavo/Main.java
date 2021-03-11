package losada.gustavo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Conta c1;

        c1 = new Conta();
        c1.cliente = new Cliente();

        c1.cliente.titular = "Inuyasha";
        c1.saldo = 199.99;

        c1.visualizarSaldo();

        Conta c2 = new Conta();
        c2.cliente = new Cliente();
        c2.cliente.titular = "Sasha";
        c2.saldo = 1000;

        c2.visualizarSaldo();

        c1.depositar(21);
        c2.depositar(50);

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        if(c1.sacar(1000)){
            System.out.println("Deu bom !");
        } else{
            System.out.println("Deu ruim");
        }
        c1.visualizarSaldo();

        if(c1.transferirPara(100,c2)){
            System.out.println("Tranferiu!");
        } else {
            System.out.println("Não Tranferiu!");
        }

        c1.visualizarSaldo();
        c2.visualizarSaldo();


    }
}
