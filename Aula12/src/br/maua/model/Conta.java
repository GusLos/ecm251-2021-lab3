package br.maua.model;

/**
 * Classe criada para representar o modelo conta.
 */
public class Conta {
    public double saldo;

    /**
     * Construtor para inicializar o saldo com um valor inicial.
     * @param saldo Valor inicial do saldo.
     */
    public Conta(double saldo){
        this.saldo = saldo;
    }

    /**
     * Construtor que inicializa o saldo com valor 0.
     */
    public Conta() {
    }

    /**
     * Método que traz o estado atual do objeto.
     * @return String com o estado do saldo.
     */
    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
