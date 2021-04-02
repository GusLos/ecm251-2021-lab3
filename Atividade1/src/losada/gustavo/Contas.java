package losada.gustavo;

public class Contas {
    private int idConta;
    private double saldo;
    private Usuarios usuario;

    public Contas(int idConta, double saldo, String eMail, String senha, String nome){
        this.idConta = idConta;
        this.saldo = saldo;
        this.usuario = new Usuarios(nome);
    }

    public double getSaldo(){
        return this.saldo;
    }
}
