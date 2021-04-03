package losada.gustavo;

import java.util.Scanner;

public class Contas {
    private static Scanner scanner;
    private int idConta;
    private double saldo;
    private Usuarios usuario;
    private static Contas c1 = new Contas(1,1000,"max@uol.com","123","Max");
    private static Contas c2 = new Contas(2,250,"mel@uol.com","321","Mel");
    private static Contas c3 = new Contas(3,3000,"Stla@uol.com","231","Stella");

    public Contas(int idConta, double saldo, String eMail, String senha, String nome){
        this.idConta = idConta;
        this.saldo = saldo;
        this.usuario = new Usuarios(nome);
        this.scanner = new Scanner(System.in);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getIdConta(){
        return this.idConta;
    }

    public String getNome(){
        return this.usuario.getNome();
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

    public static Contas login (Contas conta){
        scanner = new Scanner(System.in);
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
        return conta;
    }



}
