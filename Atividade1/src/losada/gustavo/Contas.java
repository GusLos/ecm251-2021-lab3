package losada.gustavo;

import java.util.Scanner;

public class Contas {
    private static Scanner scanner;
    private int idConta;
    private double saldo;
    public Usuarios usuario;
    private static Contas c1 = new Contas(1,1000,"max@uol.com","123","Max");
    private static Contas c2 = new Contas(2,250,"mel@uol.com","321","Mel");
    private static Contas c3 = new Contas(3,3000,"Stla@uol.com","231","Stella");

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

    public boolean saldoPositivo(String valor){
        double valorDouble = Double.valueOf(valor).doubleValue();
        if(this.saldo >= valorDouble){
            this.saldo -= valorDouble;
            return true;
        }else{
            return false;
        }
    }

    public void adicionarValor(String valor){
        double valorDouble = Double.valueOf(valor).doubleValue();
        this.saldo += valorDouble;
    }

    /* Integer.parseInt() --> aprendi/colei de https://dicasdejava.com.br/java-como-converter-string-para-int/ */

    public static Contas conectarConta(String id){
        int idInt = Integer.parseInt(id);
        if (idInt == 1){
            return c1;
        } else if (idInt == 2){
            return c2;
        }else {
            return c3;
        }
    }

    public static Contas login (){
        scanner = new Scanner(System.in);
        String senha = "0";
        Contas conta = conectarConta("1");
        while(conta.usuario.getSenha().intern() != senha.intern()){
            //Pode colocar um contador i para passar por todos os IDs e ir apresentando os dados
            System.out.println("Escolher conta: (1) - Max[123], (2) - Mel[321] ou (3) - Stella[231]");
            String op = scanner.next();
            System.out.println("Digite a senha da conta:");
            senha = scanner.next();
            conta = conectarConta(op);
            if(conta.usuario.getSenha().intern() != senha.intern()){
                System.out.println("ID da conta ou senha errado.");
            }
        }
        System.out.println("Logado como "+ conta.usuario.getNome());
        return conta;
    }



}
