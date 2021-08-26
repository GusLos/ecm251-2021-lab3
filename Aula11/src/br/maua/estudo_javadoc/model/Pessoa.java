package br.maua.estudo_javadoc.model;

public abstract class Pessoa {
    String nome;
    String cpf;

    /**
     * Método construtor da classe pessoa que inicializa seus parâmetros.
     * @param nome Nome atribuido a instância de pessoa
     * @param cpf CPF atribuido a instância de pessoa, sempre deve existir.
     */
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Método construtor alternativo para classe <strong>Pessoa</strong>. Inicializa o atributo com uma String "".
     * @param cpf
     */
    public Pessoa(String cpf){
        this.nome = "";
        this.cpf = cpf;
    }

    /**
     * Getter do valor do nome da instância de Pessoa.
     * @return O valor do atributo nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @return O valor do atributo cpf.
     */
    public String getCpf() {
        return this.cpf;
    }
}
