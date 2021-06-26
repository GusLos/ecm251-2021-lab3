package losada.gustavo.models;

import losada.gustavo.enums.TiposMembros;
import losada.gustavo.interfaces.Apresentacao;
import losada.gustavo.interfaces.PostarMensagem;

/**
 * Classe abstrata Membros possui o que os membros tem em comum:
 * nome - nome do usuario;
 * eMail - e-mail do usuario;
 * funcao - função ou o tipo de membro que ele é.
 * Também implementa:
 * PostarMensagem - para cada membro postar sua propria mensagem;
 * Apresentacao - para cada membro fazer sua apresentacao.
 */
public abstract class Membros implements PostarMensagem, Apresentacao {
    protected String nome;
    protected String eMail;
    protected TiposMembros funcao;

    public Membros (String nome, String eMail, TiposMembros funcao){
        this.nome = nome;
        this.eMail = eMail;
        this.funcao = funcao;
    }
}
