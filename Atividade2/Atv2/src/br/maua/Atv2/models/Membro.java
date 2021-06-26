package br.maua.Atv2.models;

import br.maua.Atv2.interfaces.PostarMensagem;
import br.maua.Atv2.enums.TiposMembros;
import br.maua.Atv2.interfaces.Apresentacao;

/**
 * Classe abstrata Membro possui o que os membros tem em comum:
 * id - id do usuário;
 * nome - nome do usuario;
 * eMail - e-mail do usuario;
 * funcao - função ou o tipo de membro que ele é.
 * Também implementa:
 * PostarMensagem - para cada membro postar sua propria mensagem;
 * Apresentacao - para cada membro fazer sua apresentacao.
 */
public abstract class Membro implements PostarMensagem, Apresentacao {
    protected String nome;
    protected String eMail;
    protected TiposMembros funcao;
    protected int id;

    /**
     * Construtor da classe Membro.
     * @param nome
     * @param eMail
     * @param funcao
     * @param id
     */
    public Membro(String nome, String eMail, TiposMembros funcao, int id){
        this.nome = nome;
        this.eMail = eMail;
        this.funcao = funcao;
        this.id = id;
    }

    /**
     * Método que permite o usuário fazer sua apresentação.
     * @return String "formal" contendo id, nome, eMail e função.
     */
    @Override
    public String apresentar() {
        return "Usuario: "+ this.id+'-'+ this.nome + "("+ this.funcao +") e-mail: "+this.eMail ;
    }

    public int getId(){
        return this.id;
    }
}
