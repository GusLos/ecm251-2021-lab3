package losada.gustavo;

import java.util.Scanner;

public class Contas {
    private static Scanner scanner;
    private int idConta;
    private double saldo;
    public Usuarios usuario;
    //contas disponíveis para teste
    private static Contas c1 = new Contas(1,1000,"max@uol.com","123","Max");
    private static Contas c2 = new Contas(2,250,"mel@uol.com","321","Mel");
    private static Contas c3 = new Contas(3,3000,"Stla@uol.com","231","Stella");

    //construtor de Contas
    public Contas(int idConta, double saldo, String eMail, String senha, String nome){
        this.idConta = idConta;
        this.saldo = saldo;
        this.usuario = new Usuarios(nome, senha, eMail);
        this.scanner = new Scanner(System.in);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getIdConta(){
        return this.idConta;
    }

    //verifica se o valor que foi passado é menor ou igual ao saldo, se for já retira do saldo
    public boolean saldoPositivo(String valor){
        double valorDouble = Double.valueOf(valor).doubleValue();
        if(this.saldo >= valorDouble){
            this.saldo -= valorDouble;
            return true;
        }else{
            return false;
        }
    }

    //adiciona valor no saldo
    public void adicionarValor(String valor){
        double valorDouble = Double.valueOf(valor).doubleValue();
        this.saldo += valorDouble;
    }

    /* Integer.parseInt() --> aprendi/colei de https://dicasdejava.com.br/java-como-converter-string-para-int/ */

    //recebe o id de uma conta, compara com os existentes e retorna a conta com o id
    public static Contas conectarConta(String id){
        int idInt = Integer.parseInt(id);   //transforma string para int
        if (idInt == 1){
            return c1;
        } else if (idInt == 2){
            return c2;
        }else {
            return c3;
        }
    }

    //permite a conecxão das contas
    public static Contas login (){
        scanner = new Scanner(System.in);
        String senha = "0";     //garante a senha errada e inicializa a variável
        Contas conta = conectarConta("1");  //inicializa a variavel e garante que a senha esteja errada
        while(conta.usuario.getSenha().intern() != senha.intern()){
            //Pode colocar um contador i para passar por todos os IDs e ir apresentando os dados
            System.out.println("Escolher conta: (1) - Max[123], (2) - Mel[321] ou (3) - Stella[231]");
            String op = scanner.next();
            System.out.println("Digite a senha da conta:");
            senha = scanner.next();
            conta = conectarConta(op);  //conecta a conta na variavel local para poder comparar
            if(conta.usuario.getSenha().intern() != senha.intern()){
                System.out.println("ID da conta ou senha errado."); //avisa que a senha está errada
            }
        }
        System.out.println("Logado como "+ conta.usuario.getNome());    //mostra o nome do usuário da conta
        return conta;       //retorna a conta 'permitindo' a conecxão
    }

    @Override
    public String toString() {
        return "Contas{" +
                "idConta=" + idConta +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }
}
