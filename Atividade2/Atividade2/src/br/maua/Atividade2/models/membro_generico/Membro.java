package br.maua.Atividade2.models.membro_generico;

import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.TiposMembros;
import br.maua.Atividade2.interfaces.Apresentacao;
import br.maua.Atividade2.interfaces.PostarMensagem;

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
public class Membro implements PostarMensagem, Apresentacao {
    //Ao implementar as interfaces em Membro há um acoplamento, para resolver,
    //implementar as interfaces nas classes filhas.
    protected String nome;
    protected String eMail;
    protected TiposMembros funcao;
    protected int id;

    /**
     * Construtor da classe Membro.
     * @param nome String nome do membro
     * @param eMail String e-mail do membro
     * @param funcao TiposMembros (tipo/função) do membro
     * @param id Int id do membro
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

    /**
     * Método que permite aos membros postarem/assinarem uma mensagem.
     * @param horario SistemaHorario para verificar se o horario do sistema esta em NORMAL ou EXTRA.
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        System.out.println(".");
    }

    /**
     * Método para poder pegar o id do membro.
     * @return Int id do membro.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Permite mudar o id do membro.
     * @param id Int id membro.
     */
    public void setId(int id){
        this.id = id;
    }
}
